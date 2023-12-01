# I'm not Vietnamese?

- [![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/luanon404/awChromium/blob/main/README.en.md)

# Lưu ý nè

- **Siêu Lag**.
- **Không thể đa luồng**.
- Phiên bản WebView hiện tại: [120.0.6076.4](https://chromium.googlesource.com/chromium/src.git/+/refs/tags/120.0.6076.4).
- Đừng có đụng class hay function có `@JNINamespace` hoặc `@CalledByNative` phỏng tay đó.

# Mục tiêu

- Tạo `structure.json` chứa chỉ những file Java cần.
- Vẫn đang cố xóa những file không cần thiết.
- Càng ít file càng đỡ fix bug🫣.
- “~~Nếu không fix được thì xóa cmnr nó, khỏi fix chi cho mệt~~”

# Cho ai muốn build (cực lắm)

- Sài Intel Core thì sài Ubuntu.
- Còn Ryzen Core thì sài Debian (vì Ryzen méo có wifi 😐).
- Đọc và làm theo [cái này](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md) trước.
- Tới bước `gclient sync`, nếu thích đổi phiên bản thì đổi (không cũng được).

    ```
    git checkout tags/120.0.6076.4
    gclient sync
    ```

- Paste cái này vô `out/$abi/args.gn`:

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

- Thắc mắc về `target_cpu` thì bấm vô [link này](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md#figuring-out-target_cpu).
- Sau đó mở terminal, nhập `cd chromium/src` rồi chạy `autoninja -C out/$abi -j11 webview_instrumentation_apk` để bắt đầu build.
- Lưu ý
    - `$abi` đặt là gì cũng được, chạy lệnh này `gn gen out/$abi` thì nó là tên folder thui.
    - Còn `-j11` là chạy 11 / 12 threads vì chả ai muốn PC chạy cháy máy, chuẩn không?
    - Với cần cỡ `30GB` RAM để build nếu không muốn đang build thì bị kill vì tràn RAM.
- Build xong thì chạy `tools/blind_copy.py` để copy shared object or layout, style, image, ...
- Xong chạy `tools/path2java.py` để lấy chỉ những file Java cần thiết.

# Tham khảo

- [Chromium docs](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md)
- [ridi/chromium-aw](https://github.com/ridi/chromium-aw)
- [xueqiya/AwDemo](https://github.com/xueqiya/AwDemo)
- [pwnall/chromeview](https://github.com/pwnall/chromeview)
- [pwnall/chromeview-src](https://github.com/pwnall/chromeview-src)
