// Copyright 2019 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.metrics;

/**
 * Contains command line switches that are specific to the metrics component.
 */
public final class MetricsSwitches {


    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../components/metrics/metrics_switches.cc
    // Into
    //     ../../components/metrics/android/java_templates/MetricsSwitches.java.tmpl

    // Enables the observing of all UMA logs created during the session and
    // automatically exports them to the passed file path on shutdown (the file is
    // created if it does not already exist). This also enables viewing all UMA logs
    // in the chrome://metrics-internals debug page. The format of the exported file
    // is outlined in MetricsServiceObserver::ExportLogsAsJson().
    // Example usage: --export-uma-logs-to-file=/tmp/logs.json
    public static final String EXPORT_UMA_LOGS_TO_FILE = "export-uma-logs-to-file";

    // Forces metrics reporting to be enabled. Should not be used for tests as it
    // will send data to servers.
    public static final String FORCE_ENABLE_METRICS_REPORTING = "force-enable-metrics-reporting";

    // Forces MSBB setting to be on for UKM recording. Should only be used in
    // automated testing browser sessions in which it is infeasible or impractical
    // to toggle the setting manually.
    public static final String FORCE_MSBB_SETTING_ON_FOR_UKM = "force-msbb-setting-on-for-ukm";

    // Enables the recording of metrics reports but disables reporting. In contrast
    // to kForceEnableMetricsReporting, this executes all the code that a normal
    // client would use for reporting, except the report is dropped rather than sent
    // to the server. This is useful for finding issues in the metrics code during
    // UI and performance tests.
    public static final String METRICS_RECORDING_ONLY = "metrics-recording-only";

    // Override the standard time interval between each metrics report upload for
    // UMA and UKM. It is useful to set to a short interval for debugging. Unit in
    // seconds. (The default is 1800 seconds on desktop).
    public static final String METRICS_UPLOAD_INTERVAL_SEC = "metrics-upload-interval";

    // Forces a reset of the one-time-randomized FieldTrials on this client, also
    // known as the Chrome Variations state.
    public static final String RESET_VARIATION_STATE = "reset-variation-state";

    // Overrides the URL of the server that UKM reports are uploaded to. This can
    // only be used in debug builds.
    public static final String UKM_SERVER_URL = "ukm-server-url";

    // Overrides the URL of the server that UMA reports are uploaded to. This can
    // only be used in debug builds.
    public static final String UMA_SERVER_URL = "uma-server-url";

    // Overrides the URL of the server that UMA reports are uploaded to when the
    // connection to the default secure URL fails (see |kUmaServerUrl|). This can
    // only be used in debug builds.
    public static final String UMA_INSECURE_SERVER_URL = "uma-insecure-server-url";

    // Prevents instantiation.
    private MetricsSwitches() {}
}
