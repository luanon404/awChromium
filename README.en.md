# Note

- **Lag**.
- **Cant MultiThread**.
- Android Studio version: `Iguana | 2023.2.1 Canary 16 for Windows`.
- Download link: [Android Studio](https://developer.android.com/studio/preview).
- Example code: [demo](https://github.com/luanon404/awChromium/tree/main/app/src/main/java/aw/chromium/demo).
- Current WebView version: [120.0.6076.4](https://chromium.googlesource.com/chromium/src.git/+/refs/tags/120.0.6076.4).
- Do not modify classes or functions with the `@JNINamespace` or `@CalledByNative` annotations.

# Goal

- Create `structure.json` that includes only the necessary files.
- I'm trying to remove as many unnecessary files as possible.
- That will minimize errors that I cannot fix it🫣.
- “~~If there are somethings that u cant fix it, just delete it~~”

# For developer

- If you are using Intel Core then you can use Ubuntu.
- Else if you are using Ryzen Core then you can use Debian (because Ryzen has no wifi driver 😐).
- You can follow [this docs](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md).
- After running `gclient sync`, you can set chromium version.

    ```
    git checkout tags/120.0.6076.4
    gclient sync
    ```

- And config `out/$abi/args.gn` like this:

    ```
    Take from README.md
    ```

- You can find the available `target_cpu` information in [this link](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md#figuring-out-target_cpu).
- Then open terminal and `cd chromium/src` then run `autoninja -C out/$abi -j11 system_webview_apk` to start build.
- Note:
    - `$abi` can be any name you prefer when running `gn gen out/$abi`, it's just the folder name.
    - The option `-j11` means that only use 11 / 12 threads because nobody wants their PC running at 100% CPU usage, yet?
    - Also, you'll need approximately `30GB` of RAM for a successful build if you want to avoid it being terminated due to running out of RAM.
- After build successfully, you can run `tools/blind_copy.py` to copy resources like shared object or layout, style, image, ...
- Then run `tools/path2java.py` to take only necessary Java files.

# References

- [Chromium docs](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md)
- [ridi/chromium-aw](https://github.com/ridi/chromium-aw)
- [xueqiya/AwDemo](https://github.com/xueqiya/AwDemo)
- [pwnall/chromeview](https://github.com/pwnall/chromeview)
- [pwnall/chromeview-src](https://github.com/pwnall/chromeview-src)
