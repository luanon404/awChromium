import os
import json
from utils import Utils
from pathlib import Path


def update_structure(structure: dict, file_name_check: str, target: str, print_dumplicate: bool = False, override: bool = False) -> dict:
    remove = []
    for key, value in structure.items():
        if isinstance(value, dict):
            if ".java" not in key:
                structure[key] = update_structure(value, file_name_check, target, print_dumplicate, override)
            else:
                file_name = key
                dest = value["dest"]
                if file_name == file_name_check and utils.join(dest, file_name_check) in target:
                    if not override:
                        value["target"].append(target)
                        value["times"] += 1
                    else:
                        value["target"] = [target]
                        value["times"] = 1
                if print_dumplicate:
                    if value["times"] == 0:
                        remove.append(file_name)
                    else:
                        if value["times"] > 1:
                            print(utils.join(dest, file_name), value["times"], json.dumps(value["target"], indent=4), end="\n\n")
    for file_name in remove:
        del structure[file_name]
    return structure


if __name__ == "__main__":
    prefix = "/"
    utils = Utils(prefix)
    chromium_src_path = utils.join(os.environ["HOME"], "chromium", "src")

    data = json.load(open("structure.json"))
    for file in Path(chromium_src_path).glob("**/*.java"):
        print("Updating...", end="\r")
        if utils.join(chromium_src_path, "out") in str(file):
            if prefix + "arm64" + prefix not in str(file):
                # Only copy from arm64
                continue
        data = update_structure(data, file.name, str(file))

    # Hook
    data = update_structure(data, "ProductConfig.java", utils.join(chromium_src_path, "out/arm64/gen/android_webview/test/webview_instrumentation_apk/generated_java/input_srcjars/org/chromium/android_webview/ProductConfig.java"), override=True)
    data = update_structure(data, "BuildConfig.java", utils.join(chromium_src_path, "out/arm64/gen/android_webview/test/webview_instrumentation_apk/generated_java/input_srcjars/org/chromium/build/BuildConfig.java"), override=True)
    data = update_structure(data, "NativeLibraries.java",  utils.join(chromium_src_path, "out/arm64/gen/android_webview/test/webview_instrumentation_apk/generated_java/input_srcjars/org/chromium/build/NativeLibraries.java"), override=True)
    data = update_structure(data, "GEN_JNI.java", utils.join(chromium_src_path, "out/arm64/gen/android_webview/test/webview_instrumentation_apk/generated_java/input_srcjars/org/jni_zero/GEN_JNI.java"), override=True)

    update_structure(data, None, None, print_dumplicate=True)
    json.dump(data, open("structure.json", "w"), indent=4)
