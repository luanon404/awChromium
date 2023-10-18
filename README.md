# AWChromium (THIS PROJECT STILL REMAKING)

Android WebView separated from Chromium source code.

# Note

- This project name will change into LNWebDriver in future.
- This wont open this as public library because this is for automation app.
- PLease use android.webkit.WebView instead of this.
- Current WebView version: 92.0.4515.115
- Do not convert Java classes to Kotlin with '@JNINamespace' annotation (maybe that annotation only see Java class but Kotlin not).
- Do not remove functions with '@CalledByNative' annotation.

# Goal

- Convert all Java code to Kotlin for easier processing.

# Why Kotlin?

- Google create Kotlin for prevent null exception.
- Android Studio changed to compile Kotlin better (Kotlin > Java).
- So debug or doing something maybe easier than Java (but Java still is the best).
