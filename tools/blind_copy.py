import io
import os
import re
import time
import shutil
import colorama
import subprocess
from PIL import Image
from utils import Utils
from pathlib import Path
from zipfile import ZipFile

colorama.init(autoreset=True) 

shutil.rmtree("__pycache__", ignore_errors=True)

def main():
    for target, long_target, short_target in [("arm64", "arm64-v8a", "64"), ("arm", "armeabi-v7a", "32"), ("x86", "x86", "86"), ("x64", "x86_64", "86_64")]:
        output_target_abi_path = utils.join(base_output_path, "source")
        os.makedirs(output_target_abi_path, exist_ok=True)

        target_abi_dir = utils.join(chromium_src_path, "out", target)

        if not os.path.exists(target_abi_dir):
            continue

        # Extract Java code from WebView APK
        apk_source_path = utils.join(target_abi_dir, "apks", f"{base_output_path}.apk")
        apk_output_target_abi_path = utils.join(base_output_path, "base", target)
        source_output_target_abi_path = utils.join(apk_output_target_abi_path, "output")
        utils.copy(apk_source_path, apk_output_target_abi_path)

        # Use apktool to decompile the APK
        apktool_command = [
            apktool_executable_path,
            "d",
            utils.join(apk_output_target_abi_path, "WebViewInstrumentation.apk"),
            "-o",
            source_output_target_abi_path,
            "-f",
            "-p",
            "__cache__"
        ]
        print(colorama.Fore.GREEN + "Decoding the apk file...")
        subprocess.call(" ".join(apktool_command), shell=True, stdout=subprocess.DEVNULL)
        print(colorama.Fore.GREEN + "Decode success!")

        # Use dex2jar to convert APK to jar
        os.makedirs(utils.join(apk_output_target_abi_path, "decoded"), exist_ok=True)
        dex2jar_command = [
            dex2jar_executable_path,
            utils.join(apk_output_target_abi_path, "WebViewInstrumentation.apk"),
            "-o",
            utils.join(apk_output_target_abi_path, "decoded"),
            "--force"
        ]
        print(colorama.Fore.GREEN + "Converting apk to jar...")
        subprocess.call(" ".join(dex2jar_command), shell=True, stdout=subprocess.DEVNULL)
        print(colorama.Fore.GREEN + "Convert success!")

        # Clean up apktool output
        shutil.rmtree("__cache__")
        shutil.rmtree(utils.join(source_output_target_abi_path, "original"))
        shutil.rmtree(utils.join(source_output_target_abi_path, "unknown"))
        os.remove(utils.join(source_output_target_abi_path, "apktool.yml"))

        # Filter for important Java files
        allow_libraries = [
            "org/chromium/", # org.chromium.*
            "jni_zero", # org.jni_zero
            # "android/widget/directwriting",
            # "com/android/webview/chromium",
            # "J" 
        ]


        # This outdated I dont know why google still use it???
        outdated = [
            # android/webkit
            # android/app/compat
            # androidx/interpolator/view/animation
            # androidx/test/espresso/contrib
            # com/google/android/apps/common/testing/accessibility/framework
        ]

        result_java_path = {}

        # Walk decompiled Java code and find matches
        for dir_name in os.listdir(source_output_target_abi_path):
            dir_path = utils.join(source_output_target_abi_path, dir_name)
            if os.path.isdir(dir_path) and "smali" in dir_path:
                for library_name in os.listdir(dir_path):
                    library_path = utils.join(dir_path, library_name)
                    if os.path.isdir(library_path):
                        for root, _, files in os.walk(library_path):
                            for file_name in files:
                                if (
                                    any(allow in root for allow in allow_libraries) and 
                                    file_name.endswith(".smali") and
                                    "$" not in file_name
                                ):
                                    library_full_path = root.replace(dir_path, "")  
                                    java_file = file_name.replace("smali", "java")
                                    if result_java_path.get(java_file, None):
                                        result_java_path[java_file].append(library_full_path)
                                    else:
                                        result_java_path[java_file] = [library_full_path]

        block_files = [
            "R.java"
        ]

        for block_file in block_files:
            if result_java_path.get(block_file, None):
                del result_java_path[block_file]

        # Copy matching Java files  
        for file in Path(chromium_src_path).glob("**/*.java"):
            if utils.join(chromium_src_path, "out") in str(file):
                if target not in str(file):
                    continue
                if utils.join(chromium_src_path, "out", target, "obj") in str(file):
                    # No copy obj
                    continue
            file_name = os.path.basename(str(file))
            if result_java_path.get(file_name, None):
                for library_full_path in result_java_path[file_name]:
                    if isinstance(library_full_path, str):
                        if utils.join(library_full_path, file_name) in str(file):
                            if f"package {library_full_path.strip(prefix).replace(prefix, '.')};" in open(str(file)).read():
                                dest = utils.join(output_target_abi_path, "java", library_full_path)
                                os.makedirs(dest, exist_ok=True)
                                print(
                                    f"[{colorama.Fore.GREEN + target + colorama.Style.RESET_ALL}] "
                                    f"[{colorama.Fore.GREEN + 'COPY' + colorama.Style.RESET_ALL}] "
                                    f"{colorama.Fore.BLUE + str(file)} " 
                                    f"{colorama.Fore.MAGENTA + '->'} "
                                    f"{colorama.Fore.YELLOW + dest}"
                                )
                                utils.copy(str(file), dest)
                                # Is this necessary? Yes
                                file_content = open(utils.join(dest, file_name)).read()
                                open(utils.join(dest, file_name), "w").write(re.sub(f"import (.+?).R;", "import org.chromium.android_webview.R;", file_content))
                if isinstance(result_java_path[file_name][0], int):
                    result_java_path[file_name][0] += 1
                else:
                    result_java_path[file_name].insert(0, 1)
            else:
                for path in outdated:
                    if path in str(file):
                        dest = utils.join(output_target_abi_path, "java", path)
                        os.makedirs(dest, exist_ok=True)
                        print(
                            f"[{colorama.Fore.GREEN + target + colorama.Style.RESET_ALL}] "
                            f"[{colorama.Fore.GREEN + 'COPY' + colorama.Style.RESET_ALL}] "
                            f"{colorama.Fore.BLUE + str(file)} " 
                            f"{colorama.Fore.MAGENTA + '->'} "
                            f"{colorama.Fore.YELLOW + dest}"
                        )
                        utils.copy(str(file), dest)
                        # Is this necessary? Yes
                        file_content = open(utils.join(dest, file_name)).read()
                        open(utils.join(dest, file_name), "w").write(re.sub(f"import (.+?).R;", "import org.chromium.android_webview.R;", file_content))

        # This file have too many instances, maybe duplicate?
        utils.copy(utils.join(target_abi_dir, "gen", "android_webview", "test", "webview_instrumentation_apk", "generated_java", "input_srcjars", "J", "N.java"), utils.join(output_target_abi_path, "java", "J"))
        utils.copy(utils.join(target_abi_dir, "gen", "android_webview", "test", "webview_instrumentation_apk", "generated_java", "input_srcjars", "org", "jni_zero", "GEN_JNI.java"), utils.join(output_target_abi_path, "java", "org", "jni_zero"))

        import json
        json.dump(result_java_path, open("LOG.json", "w"), indent=4)
        for key, value in result_java_path.items():
            if not any(isinstance(x, int) for x in value):
                print("LOG", target, key)
                continue
            if value[0] != len(value[1:]):
                print("LOG", target, key, value[0], len(value[1:]))

        # Copy relevant assets

        utils.copy(utils.join(target_abi_dir, "icudtl.dat"), utils.join(output_target_abi_path, "assets"))
        utils.copy(utils.join(target_abi_dir, "snapshot_blob.bin"), utils.join(output_target_abi_path, "assets"))
        os.rename(utils.join(output_target_abi_path, "assets", "snapshot_blob.bin"), utils.join(output_target_abi_path, "assets", f"snapshot_blob_{short_target}.bin"))
        utils.copy(utils.join(target_abi_dir, "gen", "android_webview", "chrome_100_percent.pak"), utils.join(output_target_abi_path, "assets"))
        utils.copy(utils.join(target_abi_dir, "gen", "android_webview", "resources.pak"), utils.join(output_target_abi_path, "assets"))

        for file in Path(utils.join(target_abi_dir, "android_webview/locales")).glob("*.pak"):
            utils.copy(str(file), utils.join(output_target_abi_path, "assets/locales"))

        # Copy resource files

        res_path = utils.join(source_output_target_abi_path, "res")
        res_target_abi_path = utils.join(output_target_abi_path, "res")
        utils.copy(res_path, res_target_abi_path)

        # Process resource files
        
        for root, _, files in os.walk(res_target_abi_path):
            for file_name in files:
                file_path = utils.join(root, file_name)
                new_file_path = file_path + ".png"
                if "." not in file_name:
                    # Convert files without extension to PNG
                    with open(file_path, "rb") as file:
                        image_bytes = file.read()

                    try:
                        with Image.open(io.BytesIO(image_bytes)) as img:
                            if img.format == "PNG":
                                print(
                                    f"[{colorama.Fore.GREEN + target + colorama.Style.RESET_ALL}] "
                                    f"[{colorama.Fore.GREEN + 'RENAME' + colorama.Style.RESET_ALL}] "
                                    f"{colorama.Fore.BLUE + file_path} " 
                                    f"{colorama.Fore.MAGENTA + '->'} "
                                    f"{colorama.Fore.YELLOW + new_file_path}"
                                )
                                os.rename(file_path, new_file_path)
                    except Exception as ex:
                        print(colorama.Fore.RED + f"Failed to rename {file_path} -> {new_file_path}")
                        print(colorama.Fore.RED + str(ex))

                if "$" in file_name:
                    # Remove $ prefix
                    new_file_path = utils.join(root, file_name[1:])
                    print(
                        f"[{colorama.Fore.GREEN + target + colorama.Style.RESET_ALL}] "
                        f"[{colorama.Fore.GREEN + 'RENAME' + colorama.Style.RESET_ALL}] "
                        f"{colorama.Fore.BLUE + file_path} " 
                        f"{colorama.Fore.MAGENTA + '->'} "
                        f"{colorama.Fore.YELLOW + new_file_path}"
                    )
                    os.rename(file_path, new_file_path)
                    match = re.search(r"\$+(.+?)__\d+.xml", file_name)
                    if match:
                        # Also update corresponding XML files
                        old_file_path = utils.join(root, match.group(1) + ".xml")

                        with open(old_file_path, "r") as old_file:
                            old_content = old_file.read()
                            new_content = old_content.replace("$", "")

                        with open(old_file_path, "w") as new_file:
                            new_file.write(new_content)

        # Copy library
        utils.copy(utils.join(target_abi_dir, "libstandalonelibwebviewchromium.so"), utils.join(output_target_abi_path, "jniLibs", long_target))
        utils.copy(utils.join(target_abi_dir, "libtest_trace_processor.so"), utils.join(output_target_abi_path, "jniLibs", long_target))

    print(colorama.Fore.GREEN + "Zipping the apk file...")
    # Zip convert
    with ZipFile(zip_filename, "w") as zip_file:

        for root, _, files in os.walk(base_output_path):
            for file in files:
                zip_file.write(utils.join(root, file))

    # Close the ZIP file
    zip_file.close()
    print(colorama.Fore.GREEN + "Zip success!")
    shutil.rmtree(base_output_path, ignore_errors=True)

if __name__ == "__main__":
    prefix = "/"
    utils = Utils(prefix)
    apktool_executable_path = "apktool"
    dex2jar_executable_path = "d2j-dex2jar.sh"
    base_output_path = "WebViewInstrumentation"
    zip_filename = base_output_path + ".zip"
    chromium_src_path = utils.join(os.environ["HOME"], "chromium", "src")

    shutil.rmtree(base_output_path, ignore_errors=True)
    os.makedirs(base_output_path)

    start_time = time.time()
    main()
    print(f"Finished, time took {round(time.time() - start_time, 2)}s")
