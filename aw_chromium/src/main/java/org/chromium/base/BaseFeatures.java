// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.base;

/**
* Constants for the names of //base Features.
*/
public final class BaseFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../base/allocator/partition_alloc_features.cc,
    //     ../../base/android/base_features.cc,
    //     ../../base/features.cc,
    //     ../../base/task/task_features.cc
    // Into
    //     ../../base/android/java/src/org/chromium/base/BaseFeatures.java.tmpl


    public static final String PARTITION_ALLOC_UNRETAINED_DANGLING_PTR = "PartitionAllocUnretainedDanglingPtr";


    public static final String PARTITION_ALLOC_DANGLING_PTR = "PartitionAllocDanglingPtr";

    // If enabled, PCScan is turned on by default for all partitions that don't
    // disable it explicitly.
    public static final String PARTITION_ALLOC_PC_SCAN = "PartitionAllocPCScan";

    // If enabled, PCScan is turned on only for the browser's malloc partition.
    public static final String PARTITION_ALLOC_PC_SCAN_BROWSER_ONLY = "PartitionAllocPCScanBrowserOnly";

    // If enabled, PCScan is turned on only for the renderer's malloc partition.
    public static final String PARTITION_ALLOC_PC_SCAN_RENDERER_ONLY = "PartitionAllocPCScanRendererOnly";

    // Use a larger maximum thread cache cacheable bucket size.
    public static final String PARTITION_ALLOC_LARGE_THREAD_CACHE_SIZE = "PartitionAllocLargeThreadCacheSize";


    public static final String PARTITION_ALLOC_LARGE_EMPTY_SLOT_SPAN_RING = "PartitionAllocLargeEmptySlotSpanRing";


    public static final String PARTITION_ALLOC_BACKUP_REF_PTR = "PartitionAllocBackupRefPtr";


    public static final String PARTITION_ALLOC_BACKUP_REF_PTR_FOR_ASH = "PartitionAllocBackupRefPtrForAsh";


    public static final String PARTITION_ALLOC_MEMORY_TAGGING = "PartitionAllocMemoryTagging";


    public static final String KILL_PARTITION_ALLOC_MEMORY_TAGGING = "KillPartitionAllocMemoryTagging";


    public static final String PARTITION_ALLOC_PERMISSIVE_MTE = "PartitionAllocPermissiveMte";

    // We enable this by default everywhere except for 32-bit Android, since we saw
    // regressions there.
    public static final String PARTITION_ALLOC_USE_DENSER_DISTRIBUTION = "PartitionAllocUseDenserDistribution";


    public static final String PARTITION_ALLOC_MEMORY_RECLAIMER = "PartitionAllocMemoryReclaimer";

    // Configures whether we set a lower limit for renderers that do not have a main
    // frame, similar to the limit that is already done for backgrounded renderers.
    public static final String LOWER_PA_MEMORY_LIMIT_FOR_NON_MAIN_RENDERERS = "LowerPAMemoryLimitForNonMainRenderers";

    // If enabled, switches PCScan scheduling to a mutator-aware scheduler. Does not
    // affect whether PCScan is enabled itself.
    public static final String PARTITION_ALLOC_PC_SCAN_MU_AWARE_SCHEDULER = "PartitionAllocPCScanMUAwareScheduler";

    // If enabled, PCScan frees unconditionally all quarantined objects.
    // This is a performance testing feature.
    public static final String PARTITION_ALLOC_PC_SCAN_IMMEDIATE_FREEING = "PartitionAllocPCScanImmediateFreeing";

    // If enabled, PCScan clears eagerly (synchronously) on free().
    public static final String PARTITION_ALLOC_PC_SCAN_EAGER_CLEARING = "PartitionAllocPCScanEagerClearing";

    // In addition to heap, scan also the stack of the current mutator.
    public static final String PARTITION_ALLOC_PC_SCAN_STACK_SCANNING = "PartitionAllocPCScanStackScanning";


    public static final String PARTITION_ALLOC_DC_SCAN = "PartitionAllocDCScan";

    // Whether to straighten free lists for larger slot spans in PurgeMemory() ->
    // ... -> PartitionPurgeSlotSpan().
    public static final String PARTITION_ALLOC_STRAIGHTEN_LARGER_SLOT_SPAN_FREE_LISTS = "PartitionAllocStraightenLargerSlotSpanFreeLists";

    // Whether to sort free lists for smaller slot spans in PurgeMemory().
    public static final String PARTITION_ALLOC_SORT_SMALLER_SLOT_SPAN_FREE_LISTS = "PartitionAllocSortSmallerSlotSpanFreeLists";

    // Whether to sort the active slot spans in PurgeMemory().
    public static final String PARTITION_ALLOC_SORT_ACTIVE_SLOT_SPANS = "PartitionAllocSortActiveSlotSpans";

    // Whether to retry allocations when commit fails.
    public static final String PAGE_ALLOCATOR_RETRY_ON_COMMIT_FAILURE = "PageAllocatorRetryOnCommitFailure";


    public static final String ENABLE_CONFIGURABLE_THREAD_CACHE_MULTIPLIER = "EnableConfigurableThreadCacheMultiplier";


    public static final String ENABLE_CONFIGURABLE_THREAD_CACHE_PURGE_INTERVAL = "EnableConfigurableThreadCachePurgeInterval";


    public static final String ENABLE_CONFIGURABLE_THREAD_CACHE_MIN_CACHED_MEMORY_FOR_PURGING = "EnableConfigurableThreadCacheMinCachedMemoryForPurging";

    // When the browser process has been in the background for several minutes at a
    // time, trigger an artificial critical memory pressure notification. This is
    // intended to reduce memory footprint.
    public static final String BROWSER_PROCESS_MEMORY_PURGE = "BrowserProcessMemoryPurge";

    // Crash the browser process if a child process is created which does not match
    // the browser process and the browser package appears to have changed since the
    // browser process was launched, so that the browser process will be started
    // fresh when next used, hopefully resolving the issue.
    public static final String CRASH_BROWSER_ON_CHILD_MISMATCH_IF_BROWSER_CHANGED = "CrashBrowserOnChildMismatchIfBrowserChanged";

    // Crash the browser process if a child process is created which does not match
    // the browser process regardless of whether the browser package appears to have
    // changed.
    public static final String CRASH_BROWSER_ON_ANY_CHILD_MISMATCH = "CrashBrowserOnAnyChildMismatch";

    // Enforce that writeable file handles passed to untrusted processes are not
    // backed by executable files.
    public static final String ENFORCE_NO_EXECUTABLE_FILE_HANDLES = "EnforceNoExecutableFileHandles";

    // TODO(crbug.com/851128): Roll out this to 100% before replacing existing
    // NOTREACHED()s with NOTREACHED_NORETURN() as part of NOTREACHED() migration.
    // Note that a prerequisite for rolling out this experiment is that existing
    // NOTREACHED reports are at a very low rate. Once this rolls out we should
    // monitor that crash rates for the experiment population is within a 1-5% or
    // lower than the control group.
    public static final String NOT_REACHED_IS_FATAL = "NotReachedIsFatal";

    // Optimizes parsing and loading of data: URLs.
    public static final String OPTIMIZE_DATA_URLS = "OptimizeDataUrls";


    public static final String USE_RUST_JSON_PARSER = "UseRustJsonParser";


    public static final String JSON_NEGATIVE_ZERO = "JsonNegativeZero";

    // TODO(crbug.com/1434873): |#if| out 32-bit before launching or going to
    // high Stable %, because we will enable the feature only for <8GB 64-bit
    // devices, where we didn't ship yet. However, we first need a larger
    // population to collect data.
    public static final String PARTIAL_LOW_END_MODE_ON_MID_RANGE_DEVICES = "PartialLowEndModeOnMidRangeDevices";

    // Whether to report frame metrics to the Android.FrameTimeline.* histograms.
    public static final String COLLECT_ANDROID_FRAME_TIMELINE_METRICS = "CollectAndroidFrameTimelineMetrics";


    public static final String USE_UTILITY_THREAD_GROUP = "UseUtilityThreadGroup";


    public static final String NO_WORKER_THREAD_RECLAIM = "NoWorkerThreadReclaim";

    // static
    public static final String NO_WAKE_UPS_FOR_CANCELED_TASKS = "NoWakeUpsForCanceledTasks";


    public static final String REMOVE_CANCELED_TASKS_IN_TASK_QUEUE = "RemoveCanceledTasksInTaskQueue2";


    public static final String DELAY_FIRST_WORKER_WAKE = "DelayFirstWorkerWake";


    public static final String ADD_TASK_LEEWAY_FEATURE = "AddTaskLeeway";


    public static final String ALIGN_WAKE_UPS = "AlignWakeUps";


    public static final String TIMER_SLACK_MAC = "TimerSlackMac";


    public static final String EXPLICIT_HIGH_RESOLUTION_TIMER_WIN = "ExplicitHighResolutionTimerWin";


    public static final String RUN_TASKS_BY_BATCHES = "RunTasksByBatches";


    public static final String THREAD_POOL_CAP2 = "ThreadPoolCap2";


    public static final String MAX_DELAYED_STARVATION_TASKS = "MaxDelayedStarvationTasks";

    // Prevents instantiation.
    private BaseFeatures() {}
}
