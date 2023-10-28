// Copyright 2021 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.variations;

/**
 * Contains command line switches that are specific to the variations component.
 */
public final class VariationsSwitches {


    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../components/variations/variations_switches.cc
    // Into
    //     ../../components/variations/android/java_templates/VariationsSwitches.java.tmpl

    // Disable field trial tests configured in fieldtrial_testing_config.json.
    public static final String DISABLE_FIELD_TRIAL_TESTING_CONFIG = "disable-field-trial-config";

    // Disable variations safe mode.
    public static final String DISABLE_VARIATIONS_SAFE_MODE = "disable-variations-safe-mode";

    // Disables throttling for fetching the variations seed on mobile platforms. The
    // seed will be fetched on startup and every time the app enters the foreground,
    // regardless of the time passed in between the fetches. On Desktop, this switch
    // has no effect (the seed is fetched periodically instead).
    public static final String DISABLE_VARIATIONS_SEED_FETCH_THROTTLING = "disable-variations-seed-fetch-throttling";

    // TODO(asvitkine): Consider removing or renaming this functionality.
    // Enables the benchmarking extensions.
    public static final String ENABLE_BENCHMARKING = "enable-benchmarking";

    // Enable field trial tests configured in fieldtrial_testing_config.json. If the
    // "disable_fieldtrial_testing_config" GN flag is set to true, then this switch
    // is a no-op. Otherwise, for non-Chrome branded builds, the testing config is
    // already applied by default, unless the "--disable-field-trial-config",
    // "--force-fieldtrials", and/or "--variations-server-url" switches are passed.
    // It is however possible to apply the testing config as well as specify
    // additional field trials (using "--force-fieldtrials") by using this switch.
    // For Chrome-branded builds, the testing config is not enabled by default, so
    // this switch is required to enable it.
    public static final String ENABLE_FIELD_TRIAL_TESTING_CONFIG = "enable-field-trial-config";

    // Fakes the channel of the browser for purposes of Variations filtering. This
    // is to be used for testing only. Possible values are "stable", "beta", "dev"
    // and "canary". This works for official builds as well.
    public static final String FAKE_VARIATIONS_CHANNEL = "fake-variations-channel";

    // This option can be used to force parameters of field trials when testing
    // changes locally. The argument is a param list of (key, value) pairs prefixed
    // by an associated (trial, group) pair. You specify the param list for multiple
    // (trial, group) pairs with a comma separator.
    // Example:
    //   "Trial1.Group1:k1/v1/k2/v2,Trial2.Group2:k3/v3/k4/v4"
    // Trial names, groups names, parameter names, and value should all be URL
    // escaped for all non-alphanumeric characters.
    public static final String FORCE_FIELD_TRIAL_PARAMS = "force-fieldtrial-params";

    // Forces additional Chrome Variation Ids that will be sent in X-Client-Data
    // header, specified as a 64-bit encoded list of numeric experiment ids. Ids
    // prefixed with the character "t" will be treated as Trigger Variation Ids.
    public static final String FORCE_VARIATION_IDS = "force-variation-ids";

    // Forces to remove Chrome Variation Ids from being sent in X-Client-Data
    // header, specified as a 64-bit encoded list of numeric experiment ids. Ids
    // prefixed with the character "t" will be treated as Trigger Variation Ids.
    public static final String FORCE_DISABLE_VARIATION_IDS = "force-disable-variation-ids";

    // Used to share variations seed version with child processes.
    public static final String VARIATIONS_SEED_VERSION = "variations-seed-version";

    // Allows overriding the country used for evaluating variations. This is similar
    // to the "Override Variations Country" entry on chrome://translate-internals,
    // but is exposed as a command-line flag to allow testing First Run scenarios.
    // Additionally, unlike chrome://translate-internals, the value isn't persisted
    // across sessions.
    public static final String VARIATIONS_OVERRIDE_COUNTRY = "variations-override-country";

    // Specifies the location of a seed file for Local State's seed to be
    // populated from. The seed file must be in json format with the keys
    // |kVariationsCompressedSeed| and |kVariationsSeedSignature|.
    public static final String VARIATIONS_TEST_SEED_JSON_PATH = "variations-test-seed-path";

    // Specifies a custom URL for the server which reports variation data to the
    // client. Specifying this switch enables the Variations service on
    // unofficial builds. See variations_service.cc.
    public static final String VARIATIONS_SERVER_URL = "variations-server-url";

    // Specifies a custom URL for the server to use as an insecure fallback when
    // requests to |kVariationsServerURL| fail. Requests to this URL will be
    // encrypted.
    public static final String VARIATIONS_INSECURE_SERVER_URL = "variations-insecure-server-url";

    // Override the time interval between each variation seed fetches. Unit is in
    // minutes. The minimum is 1 minute. The default is 30 minutes.
    public static final String VARIATIONS_SEED_FETCH_INTERVAL = "variations-seed-fetch-interval";

    // Enables delta-compression when fetching a new seed via the "first run" code
    // path on Android.
    public static final String ENABLE_FINCH_SEED_DELTA_COMPRESSION = "enable-finch-seed-delta-compression";

    // Accept an empty signature when loading a variations seed. This is for
    // testing purposes.
    public static final String ACCEPT_EMPTY_SEED_SIGNATURE_FOR_TESTING = "accept-empty-variations-seed-signature";

    // Prevents instantiation.
    private VariationsSwitches() {}
}
