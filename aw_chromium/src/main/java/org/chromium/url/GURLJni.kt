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
internal class GURLJni : GURL.Natives {
    override fun init(uri: String?, target: GURL?) {
        GEN_JNI.org_chromium_url_GURL_init(uri, target)
    }

    override fun getOrigin(spec: String?, isValid: Boolean, nativeParsed: Long, target: GURL?) {
        GEN_JNI.org_chromium_url_GURL_getOrigin(spec, isValid, nativeParsed, target)
    }

    override fun domainIs(
        spec: String?,
        isValid: Boolean,
        nativeParsed: Long,
        domain: String?
    ): Boolean {
        return GEN_JNI.org_chromium_url_GURL_domainIs(spec, isValid, nativeParsed, domain)
    }

    override fun createNative(spec: String?, isValid: Boolean, nativeParsed: Long): Long {
        return GEN_JNI.org_chromium_url_GURL_createNative(spec, isValid, nativeParsed)
    }

    companion object {
        private var testInstance: GURL.Natives? = null
        val TEST_HOOKS: JniStaticTestMocker<GURL.Natives?> =
            object : JniStaticTestMocker<GURL.Natives?> {
                override fun setInstanceForTesting(instance: GURL.Natives?) {
                    if (!GEN_JNI.TESTING_ENABLED) {
                        throw RuntimeException("Tried to set a JNI mock when mocks aren't enabled!")
                    }
                    testInstance = instance
                }
            }

        fun get(): GURL.Natives? {
            if (GEN_JNI.TESTING_ENABLED) {
                if (testInstance != null) {
                    return testInstance
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw UnsupportedOperationException("No mock found for the native implementation for org.chromium.url.GURL.Natives. The current configuration requires all native implementations to have a mock instance.")
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(true)
            return GURLJni()
        }
    }
}