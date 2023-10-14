package org.chromium.url

import org.chromium.base.JniStaticTestMocker
import org.chromium.base.NativeLibraryLoadedStatus
import org.chromium.base.annotations.CheckDiscard
import org.chromium.base.annotations.MainDex
import org.chromium.base.natives.GEN_JNI
import javax.annotation.Generated

@Generated("org.chromium.jni_generator.JniProcessor")
@MainDex
@CheckDiscard("crbug.com/993421")
internal class ParsedJni : Parsed.Natives {
    override fun createNative(
        schemeBegin: Int,
        schemeLength: Int,
        usernameBegin: Int,
        usernameLength: Int,
        passwordBegin: Int,
        passwordLength: Int,
        hostBegin: Int,
        hostLength: Int,
        portBegin: Int,
        portLength: Int,
        pathBegin: Int,
        pathLength: Int,
        queryBegin: Int,
        queryLength: Int,
        refBegin: Int,
        refLength: Int,
        potentiallyDanglingMarkup: Boolean,
        innerUrl: Long
    ): Long {
        return GEN_JNI.org_chromium_url_Parsed_createNative(
            schemeBegin,
            schemeLength,
            usernameBegin,
            usernameLength,
            passwordBegin,
            passwordLength,
            hostBegin,
            hostLength,
            portBegin,
            portLength,
            pathBegin,
            pathLength,
            queryBegin,
            queryLength,
            refBegin,
            refLength,
            potentiallyDanglingMarkup,
            innerUrl
        )
    }

    companion object {
        private var testInstance: Parsed.Natives? = null
        val TEST_HOOKS: JniStaticTestMocker<Parsed.Natives?> =
            JniStaticTestMocker<Parsed.Natives?> { instance ->
                if (!GEN_JNI.TESTING_ENABLED) {
                    throw RuntimeException("Tried to set a JNI mock when mocks aren't enabled!")
                }
                testInstance = instance
            }

        fun get(): Parsed.Natives? {
            if (GEN_JNI.TESTING_ENABLED) {
                if (testInstance != null) {
                    return testInstance
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw UnsupportedOperationException("No mock found for the native implementation for org.chromium.url.Parsed.Natives. The current configuration requires all native implementations to have a mock instance.")
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(true)
            return ParsedJni()
        }
    }
}