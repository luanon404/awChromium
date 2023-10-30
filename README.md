<div align="center">
    <kbd><img src="./assets/logo.png" width="256" height="256"></kbd>
    <br>
    “Logo tạo bằng <a href="https://www.bing.com/create">Dall·E-3</a>”
    <br>
    <strong>Android WebDriver</strong> dựa trên <strong>Chromium</strong>
    <br>
    <strong>🐾Moe Moe🐾</strong> <em>- Thế hệ tiếp theo của <a href="https://github.com/luanon404/Seledroid">Seledroid</a></em>
    <br>
    “Đừng hỏi tại sao lại đặt tên là <strong>🐾Moe Moe🐾</strong>”
</div>

# I'm not Vietnamese?

- [![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/luanon404/Moe-Moe/blob/main/README.en.md)

# Lưu ý nè

- > **_Chưa sài được_** <= Đọc cái này đi
- Phiên bản WebView hiện tại: [120.0.6076.4](https://chromium.googlesource.com/chromium/src.git/+/refs/tags/120.0.6076.4).
- Đừng có đụng class hay function có `@JNINamespace` hoặc `@CalledByNative` phỏng tay đó.

# Mục tiêu

- Tạo `structure.json` chứa chỉ những file Java cần.
- Vẫn đang cố xóa những file không cần thiết.
- Càng ít file càng đỡ fix bug🫣.
- “~~Nếu không fix được thì xóa cmnr nó, khỏi fix chi cho mệt~~”

# Bản phát hành

- Phiên bản nào cũng có 3 bản như này.

    | Release | JniLibs.zip | AwChromium.aar | Moe-Moe.apk |
    |:-------:|:-----------:|:--------------:|:-----------:|
    |   CP    |     Có      |     Không      |    Không    |
    |   3R    |     Có      |     Không      |    Không    |
    |   TR    |     Có      |       Có       |     Có      |

- Lưu ý (CP, 3R, TR dịch từ bên english)
    - CP: Copy và paste code mới vô code cũ.
    - 3R: Xem xét, làm đẹp và xóa mấy cái không cần.
    - TR: Thử nghiệm và xuất bản.

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
- Xong chạy `tools/path2java.py` để lấy file Java (chỉ file cần thui).

# Tham khảo

- [Chromium docs](https://chromium.googlesource.com/chromium/src/+/HEAD/docs/android_build_instructions.md)
- [ridi/chromium-aw](https://github.com/ridi/chromium-aw)
- [xueqiya/AwDemo](https://github.com/xueqiya/AwDemo)
- [pwnall/chromeview](https://github.com/pwnall/chromeview)
- [pwnall/chromeview-src](https://github.com/pwnall/chromeview-src)
