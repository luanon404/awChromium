<div align="center">
    <kbd><img src="./assets/logo.png" width="256" height="256"></kbd>
    <br>
    “Logo created by <a href="https://www.bing.com/create">Dall·E-3</a>”
    <br>
    <strong>Android WebDriver</strong> based on <strong>Chromium</strong>
    <br>
    <strong>🐾Moe Moe🐾</strong> <em>- The next-generation of <a href="https://github.com/luanon404/Seledroid">Seledroid</a></em>
    <br>
    “I have no idea why I named it <strong>🐾Moe Moe🐾</strong>”
</div>

# Note

- > **_Under development_** <= READ THIS PLEASE
- Current WebView
  version: [120.0.6076.4](https://chromium.googlesource.com/chromium/src.git/+/refs/tags/120.0.6076.4).
- Do not modify classes or functions with the `@JNINamespace` or `@CalledByNative` annotations.

# Goal

- Create `structure.json` that includes only the necessary files.
- I'm trying to remove as many unnecessary files as possible.
- That will minimize errors that I cannot fix it🫣.
- “~~If there are somethings that u cant fix it, just delete it~~”

# Release

- Each version will include at least 3 releases:

    | Release | JniLibs.zip | AwChromium.aar | Moe-Moe.apk |
    |:-------:|:-----------:|:--------------:|:-----------:|
    |   CP    |     Yes     |       No       |     No      |
    |   3R    |     Yes     |       No       |     No      |
    |   TR    |     Yes     |      Yes       |     Yes     |

- Note
    - CP: Copy and paste the new source into the old source.
    - 3R: Review, reformat, and remove unused resources.
    - TR: Testing and release.

# For developer

- If you are using Intel Core then you can use Ubuntu (because no wifi 😐).
- Else if you are using Ryzen Core then you can use Debian.
- You can follow [this docs](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md).
- After running `gclient sync`, you can set chromium version.

    ```
    git checkout tags/120.0.6076.4
    gclient sync
    ```

- And config args.gn like this:

    ```
    # Set build arguments here. See gn help buildargs.
    
    target_os = "android"
    target_cpu = "arm64"
    
    symbol_level = 0
    blink_symbol_level = 0
    v8_symbol_level = 0
    
    is_debug = false
    is_java_debug = false
    is_clang = true
    fatal_linker_warnings = false
    treat_warnings_as_errors = false
    
    clang_use_chrome_plugins = false
    
    enable_nacl = false
    enable_iterator_debugging = false
    enable_remoting = false
    
    use_thin_lto = true
    use_debug_fission = false
    
    dcheck_always_on = false
    update_android_aar_prebuilts = true
    proprietary_codecs = true
    ffmpeg_branding = "Chrome"
    ```

- You can find the available `target_cpu` information in [this link](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md#figuring-out-target_cpu).
- Then open terminal and `cd chromium/src` then run `autoninja -C out/$abi -j11 webview_instrumentation_apk`
- Note
    - `$abi` can be any name you prefer when running `gn gen out/$abi`, it's just the folder name.
    - The option `-j11` means that only use 11 / 12 threads because nobody wants their PC running at 100% CPU usage, yet?
    - Also, you'll need approximately `30GB` of RAM for a successful build if you want to avoid it being terminated due to running out of RAM.
- After build successfully, you can run `tools/blind_copy.py` to copy resources like shared object or layout, style, image, ...
- And `tools/path2java.py` for good Java files (only necessary files).
