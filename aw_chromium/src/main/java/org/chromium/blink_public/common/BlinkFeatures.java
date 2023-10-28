// Copyright 2020 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.blink_public.common;

/**
 * Constants for the names of Blink Features.
 */
public final class BlinkFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     gen/third_party/blink/common/features_generated.cc,
    //     ../../third_party/blink/common/features.cc
    // Into
    //     ../../third_party/blink/public/common/android/java_templates/BlinkFeatures.java.tmpl


    public static final String ABORT_SIGNAL_ANY = "AbortSignalAny";


    public static final String ABORT_SIGNAL_COMPOSITION = "AbortSignalComposition";


    public static final String ACCESSIBILITY_EAGER_AX_TREE_UPDATE = "AccessibilityEagerAXTreeUpdate";


    public static final String ACCORDION_PATTERN = "AccordionPattern";


    public static final String ADD_IDENTITY_IN_CAN_MAKE_PAYMENT_EVENT = "AddIdentityInCanMakePaymentEvent";


    public static final String AD_INTEREST_GROUP_API = "AdInterestGroupAPI";


    public static final String ANCHOR_HREF_CHECK_INVALID_URL = "AnchorHrefCheckInvalidURL";


    public static final String ARROW_KEYS_IN_VERTICAL_WRITING_MODES = "ArrowKeysInVerticalWritingModes";


    public static final String AUTOFILL_SHADOW_DOM = "AutofillShadowDOM";


    public static final String BACKDROP_INHERIT_ORIGINATING = "BackdropInheritOriginating";


    public static final String BACKFACE_VISIBILITY_INTEROP = "BackfaceVisibilityInterop";


    public static final String BACK_FORWARD_CACHE_SEND_NOT_RESTORED_REASONS = "BackForwardCacheSendNotRestoredReasons";


    public static final String BEFOREUNLOAD_EVENT_CANCEL_BY_PREVENT_DEFAULT = "BeforeunloadEventCancelByPreventDefault";


    public static final String BLINK_LIFECYCLE_SCRIPT_FORBIDDEN = "BlinkLifecycleScriptForbidden";


    public static final String BLOCKING_FOCUS_WITHOUT_USER_ACTIVATION = "BlockingFocusWithoutUserActivation";


    public static final String BYOB_FETCH = "ByobFetch";


    public static final String CANONICALIZE_WHITESPACE_STRINGS = "CanonicalizeWhitespaceStrings";


    public static final String CAPABILITY_DELEGATION_DISPLAY_CAPTURE_REQUEST = "CapabilityDelegationDisplayCaptureRequest";


    public static final String CAPTURED_MOUSE_EVENTS = "CapturedMouseEvents";


    public static final String CCT_NEW_RFM_PUSH_BEHAVIOR = "CCTNewRFMPushBehavior";


    public static final String CLIENT_HINTS_META_EQUIV_DELEGATE_CH = "ClientHintsMetaEquivDelegateCH";


    public static final String CLIENT_HINTS_META_HTTP_EQUIV_ACCEPT_CH = "ClientHintsMetaHTTPEquivAcceptCH";


    public static final String CLIENT_HINT_THIRD_PARTY_DELEGATION = "ClientHintThirdPartyDelegation";


    public static final String CLIPBOARD_CUSTOM_FORMATS = "ClipboardCustomFormats";


    public static final String CLIPBOARD_WELL_FORMED_HTML_SANITIZATION_WRITE = "ClipboardWellFormedHtmlSanitizationWrite";


    public static final String CLIP_PATH_GEOMETRY_BOX = "ClipPathGeometryBox";


    public static final String CLIP_PATH_REJECT_EMPTY_PATHS = "ClipPathRejectEmptyPaths";


    public static final String CLIP_PATH_XYWH_AND_RECT = "ClipPathXYWHAndRect";


    public static final String CLOSE_WATCHER = "CloseWatcher";


    public static final String COMPOSITION_FOREGROUND_MARKERS = "CompositionForegroundMarkers";


    public static final String COMPOSITION_UPDATE_BEFORE_BEFORE_INPUT = "CompositionUpdateBeforeBeforeInput";


    public static final String COMPUTE_PRESSURE = "ComputePressure";


    public static final String CROSS_FRAME_PERFORMANCE_TIMELINE = "CrossFramePerformanceTimeline";


    public static final String CSS_ANIMATION_DELAY_START_END = "CSSAnimationDelayStartEnd";


    public static final String CSS_AT_SUPPORTS_ALWAYS_NON_FORGIVING_PARSING = "CSSAtSupportsAlwaysNonForgivingParsing";


    public static final String CSS_BACKGROUND_CLIP_UNPREFIX = "CSSBackgroundClipUnprefix";


    public static final String CSS_BASELINE_SOURCE = "CSSBaselineSource";


    public static final String CSS_CAP_FONT_UNITS = "CSSCapFontUnits";


    public static final String CSS_CONTAIN_INTRINSIC_SIZE_AUTO_NONE = "CSSContainIntrinsicSizeAutoNone";


    public static final String CSS_CONTENT_VISIBILITY_IMPLIES_CONTAIN_INTRINSIC_SIZE_AUTO = "CSSContentVisibilityImpliesContainIntrinsicSizeAuto";


    public static final String CSS_CUSTOM_PROPERTIES_ABLATION = "CSSCustomPropertiesAblation";


    public static final String CSS_DISPLAY_ANIMATION = "CSSDisplayAnimation";


    public static final String CSS_DYNAMIC_RANGE_LIMIT = "CSSDynamicRangeLimit";


    public static final String CSS_EXPONENTIAL_FUNCTIONS = "CSSExponentialFunctions";


    public static final String CSS_FIELD_SIZING = "CssFieldSizing";


    public static final String CSS_FIRST_LETTER_NO_NEW_LINE_AS_PRECEDING_CHAR = "CSSFirstLetterNoNewLineAsPrecedingChar";


    public static final String CSS_HYPHENATE_LIMIT_CHARS = "CSSHyphenateLimitChars";


    public static final String CSS_IMAGE_SET = "CSSImageSet";


    public static final String CSS_LINEAR_TIMING_FUNCTION = "CSSLinearTimingFunction";


    public static final String CSS_MASKING_INTEROP = "CSSMaskingInterop";


    public static final String CSS_NESTING = "CSSNesting";


    public static final String CSS_NESTING_IDENT = "CSSNestingIdent";


    public static final String CSS_NUMERIC_FACTORY_COMPLETENESS = "CSSNumericFactoryCompleteness";


    public static final String CSS_OFFSET_PATH_BASIC_SHAPES_CIRCLE_AND_ELLIPSE = "CSSOffsetPathBasicShapesCircleAndEllipse";


    public static final String CSS_OFFSET_PATH_BASIC_SHAPES_RECTANGLES_AND_POLYGON = "CSSOffsetPathBasicShapesRectanglesAndPolygon";


    public static final String CSS_OFFSET_PATH_COORD_BOX = "CSSOffsetPathCoordBox";


    public static final String CSS_OFFSET_PATH_RAY = "CSSOffsetPathRay";


    public static final String CSS_OFFSET_PATH_RAY_CONTAIN = "CSSOffsetPathRayContain";


    public static final String CSS_OFFSET_PATH_URL = "CSSOffsetPathUrl";


    public static final String CSS_OFFSET_POSITION_ANCHOR = "CSSOffsetPositionAnchor";


    public static final String CSS_OVERFLOW_MEDIA_FEATURES = "CSSOverflowMediaFeatures";


    public static final String CSS_PAINTING_FOR_SPELLING_GRAMMAR_ERRORS = "CssPaintingForSpellingGrammarErrors";


    public static final String CSS_PARSER_IGNORE_CHARSET_FOR_UR_LS = "CSSParserIgnoreCharsetForURLs";


    public static final String CSS_PHRASE_LINE_BREAK = "CSSPhraseLineBreak";


    public static final String CSS_PSEUDO_DIR = "CSSPseudoDir";


    public static final String CSS_PSEUDO_HAS_NON_FORGIVING_PARSING = "CSSPseudoHasNonForgivingParsing";


    public static final String CSS_RELATIVE_COLOR = "CSSRelativeColor";


    public static final String CSS_SCOPE = "CSSScope";


    public static final String CSS_SCROLL_SNAP_EVENTS = "CSSScrollSnapEvents";


    public static final String CSS_SCROLL_START = "CSSScrollStart";


    public static final String CSS_SELECTOR_FRAGMENT_ANCHOR = "CssSelectorFragmentAnchor";


    public static final String CSS_SIGN_RELATED_FUNCTIONS = "CSSSignRelatedFunctions";


    public static final String CSS_SNAP_CONTAINER_QUERIES = "CSSSnapContainerQueries";


    public static final String CSS_STARTING_STYLE = "CSSStartingStyle";


    public static final String CSS_STEPPED_VALUE_FUNCTIONS = "CSSSteppedValueFunctions";


    public static final String CSS_STICKY_CONTAINER_QUERIES = "CSSStickyContainerQueries";


    public static final String CSS_STYLE_QUERIES_BOOLEAN = "CSSStyleQueriesBoolean";


    public static final String CSS_SYSTEM_ACCENT_COLOR = "CSSSystemAccentColor";


    public static final String CSS_TEXT_AUTO_SPACE = "CSSTextAutoSpace";


    public static final String CSS_TEXT_BOX_TRIM = "CSSTextBoxTrim";


    public static final String CSS_TEXT_SPACING_TRIM = "CSSTextSpacingTrim";


    public static final String CSS_TEXT_WRAP_BALANCE_BY_SCORE = "CSSTextWrapBalanceByScore";


    public static final String CSS_TEXT_WRAP_PRETTY = "CSSTextWrapPretty";


    public static final String CSS_TOP_LAYER_FOR_TRANSITIONS = "CSSTopLayerForTransitions";


    public static final String CSS_TRANSFORM_BOX_ADDITIONAL_KEYWORDS = "CSSTransformBoxAdditionalKeywords";


    public static final String CSS_TRANSITION_DISCRETE = "CSSTransitionDiscrete";


    public static final String CSS_TRANSLATE_PRESERVE_Y_PERCENT = "CSSTranslatePreserveYPercent";


    public static final String CSS_UPDATE_MEDIA_FEATURE = "CSSUpdateMediaFeature";


    public static final String CSS_VARIABLES2_IMAGE_VALUES = "CSSVariables2ImageValues";


    public static final String CSS_VARIABLES2_TRANSFORM_VALUES = "CSSVariables2TransformValues";


    public static final String CSS_VIEW_TIMELINE_INSET_SHORTHAND = "CSSViewTimelineInsetShorthand";


    public static final String CUSTOM_ELEMENTS_GET_NAME = "CustomElementsGetName";


    public static final String DATE_INPUT_INLINE_BLOCK = "DateInputInlineBlock";


    public static final String DELAY_OUT_OF_VIEWPORT_LAZY_IMAGES = "DelayOutOfViewportLazyImages";


    public static final String DELEGATED_INK_TRAILS = "DelegatedInkTrails";


    public static final String DEPRECATED_NON_STREAMING_DECLARATIVE_SHADOW_DOM = "DeprecatedNonStreamingDeclarativeShadowDOM";


    public static final String DESKTOP_PW_AS_ADDITIONAL_WINDOWING_CONTROLS = "DesktopPWAsAdditionalWindowingControls";


    public static final String DESKTOP_PW_AS_SUB_APPS = "DesktopPWAsSubApps";


    public static final String DETAILS_ELEMENT_TOGGLE_EVENT = "DetailsElementToggleEvent";


    public static final String DETAILS_STYLING = "DetailsStyling";


    public static final String DIALOG_NEW_FOCUS_BEHAVIOR = "DialogNewFocusBehavior";


    public static final String DISABLE_SELECT_ALL_FOR_EMPTY_TEXT = "DisableSelectAllForEmptyText";


    public static final String DOCUMENT_OPEN_ORIGIN_ALIAS_REMOVAL = "DocumentOpenOriginAliasRemoval";


    public static final String DOCUMENT_OPEN_SANDBOX_INHERITANCE_REMOVAL = "DocumentOpenSandboxInheritanceRemoval";


    public static final String DOCUMENT_PICTURE_IN_PICTURE_API = "DocumentPictureInPictureAPI";


    public static final String DOM_PARTS_API = "DOMPartsAPI";


    public static final String DOM_PARTS_API_ACTIVE_PART_TRACKING = "DOMPartsAPIActivePartTracking";


    public static final String EDIT_CONTEXT = "EditContext";


    public static final String ELEMENT_CAPTURE = "ElementCapture";


    public static final String EMPTY_CARET_IN_VERTICAL = "EmptyCaretInVertical";


    public static final String ENFORCE_ANONYMITY_EXPOSURE = "EnforceAnonymityExposure";


    public static final String ESCAPE_LT_GT_IN_ATTRIBUTES = "EscapeLtGtInAttributes";


    public static final String EXCLUDE_BROKEN_IMAGE_ICON_FROM_BEING_LCP_ELIGIBLE = "ExcludeBrokenImageIconFromBeingLcpEligible";


    public static final String FAST_COMPARE_POSITIONS = "FastComparePositions";


    public static final String FAST_POSITION_ITERATOR = "FastPositionIterator";


    public static final String FENCED_FRAMES_API_CHANGES = "FencedFramesAPIChanges";


    public static final String FENCED_FRAMES_DEFAULT_MODE = "FencedFramesDefaultMode";


    public static final String FETCH_LATER_API = "FetchLaterAPI";


    public static final String FILE_HANDLING_API = "FileHandlingAPI";


    public static final String FILE_SYSTEM_ACCESS_GET_CLOUD_IDENTIFIERS = "FileSystemAccessGetCloudIdentifiers";


    public static final String FILE_SYSTEM_ACCESS_LOCKING_SCHEME = "FileSystemAccessLockingScheme";


    public static final String FILE_SYSTEM_OBSERVER = "FileSystemObserver";


    public static final String FIRST_RECT_FOR_RANGE_VERTICAL = "FirstRectForRangeVertical";


    public static final String FIXED_ELEMENTS_DONT_OVERSCROLL = "FixedElementsDontOverscroll";


    public static final String FLEDGE_BIDDING_AND_AUCTION_SERVER_API = "FledgeBiddingAndAuctionServerAPI";


    public static final String FLEDGE_CLEAR_ORIGIN_JOINED_AD_INTEREST_GROUPS = "FledgeClearOriginJoinedAdInterestGroups";


    public static final String FLEDGE_DIRECT_FROM_SELLER_SIGNALS_HEADER_AD_SLOT = "FledgeDirectFromSellerSignalsHeaderAdSlot";


    public static final String FLEDGE_NEGATIVE_TARGETING = "FledgeNegativeTargeting";


    public static final String FLUSH_PARSER_BEFORE_CREATING_CUSTOM_ELEMENTS = "FlushParserBeforeCreatingCustomElements";


    public static final String FONT_ACCESS = "FontAccess";


    public static final String FONTATIONS_FONT_BACKEND = "FontationsFontBackend";


    public static final String FONT_PALETTE_ANIMATION = "FontPaletteAnimation";


    public static final String FONT_VARIANT_POSITION = "FontVariantPosition";


    public static final String FORM_CONTROL_RESTORE_STATE_IF_AUTOCOMPLETE_OFF = "FormControlRestoreStateIfAutocompleteOff";


    public static final String FORM_CONTROLS_VERTICAL_WRITING_MODE_DIRECTION_SUPPORT = "FormControlsVerticalWritingModeDirectionSupport";


    public static final String FORM_CONTROLS_VERTICAL_WRITING_MODE_SUPPORT = "FormControlsVerticalWritingModeSupport";


    public static final String FORM_CONTROLS_VERTICAL_WRITING_MODE_TEXT_SUPPORT = "FormControlsVerticalWritingModeTextSupport";


    public static final String FORM_REL_ATTRIBUTE = "FormRelAttribute";


    public static final String FORM_STATE_RESTORE_CALLBACK_CALL_WITH_STATE = "FormStateRestoreCallbackCallWithState";


    public static final String FULLSCREEN_POPUP_WINDOWS = "FullscreenPopupWindows";


    public static final String GAMEPAD_MULTITOUCH = "GamepadMultitouch";


    public static final String GET_ALL_SCREENS_MEDIA = "GetAllScreensMedia";


    public static final String GET_COMPUTED_STYLE_OUT_OF_FLOW_INSETS_FIX = "GetComputedStyleOutOfFlowInsetsFix";


    public static final String GET_DISPLAY_MEDIA_REQUIRES_USER_ACTIVATION = "GetDisplayMediaRequiresUserActivation";


    public static final String HANGING_WHITESPACE_DOES_NOT_DEPEND_ON_ALIGNMENT = "HangingWhitespaceDoesNotDependOnAlignment";


    public static final String HIT_TEST_OPAQUENESS = "HitTestOpaqueness";


    public static final String HIT_TEST_TRANSPARENCY = "HitTestTransparency";


    public static final String HTML_PARSER_YIELD_AND_DELAY_OFTEN_FOR_TESTING = "HTMLParserYieldAndDelayOftenForTesting";


    public static final String HTML_POPOVER_ATTRIBUTE = "HTMLPopoverAttribute";


    public static final String HTML_POPOVER_HINT = "HTMLPopoverHint";


    public static final String HTML_SEARCH_ELEMENT = "HTMLSearchElement";


    public static final String HTML_SELECT_ELEMENT_SHOW_PICKER = "HTMLSelectElementShowPicker";


    public static final String HTML_UNSAFE_METHODS = "HTMLUnsafeMethods";


    public static final String IMPORT_ATTRIBUTES_DISALLOW_UNKNOWN_KEYS = "ImportAttributesDisallowUnknownKeys";


    public static final String INCOMING_CALL_NOTIFICATIONS = "IncomingCallNotifications";


    public static final String INERT_DISPLAY_TRANSITION = "InertDisplayTransition";


    public static final String INHERIT_USER_MODIFY_WITHOUT_CONTENTEDITABLE = "InheritUserModifyWithoutContenteditable";


    public static final String INNER_HTML_PARSER_FASTPATH = "InnerHTMLParserFastpath";


    public static final String INNER_HTML_PARSER_FASTPATH_LOG_FAILURE = "InnerHTMLParserFastpathLogFailure";


    public static final String INSERT_LINE_BREAK_IF_PHRASING_CONTENT = "InsertLineBreakIfPhrasingContent";


    public static final String INTEROPERABLE_PRIVATE_ATTRIBUTION = "InteroperablePrivateAttribution";


    public static final String INTERRUPT_COMPOSED_SCROLLBAR_DISAPPEARANCE = "InterruptComposedScrollbarDisappearance";


    public static final String INTERSECTION_OBSERVER_SCROLL_MARGIN = "IntersectionObserverScrollMargin";


    public static final String INTERSECTION_OPTIMIZATION = "IntersectionOptimization";


    public static final String INVERTED_COLORS = "InvertedColors";


    public static final String INVISIBLE_SVG_ANIMATION_THROTTLING = "InvisibleSVGAnimationThrottling";


    public static final String JAVA_SCRIPT_COMPILE_HINTS_MAGIC_RUNTIME = "JavaScriptCompileHintsMagicRuntime";


    public static final String KEYBOARD_FOCUSABLE_SCROLLERS = "KeyboardFocusableScrollers";


    public static final String LAYOUT_FLEX_NEW_ROW_ALGORITHM_V3 = "LayoutFlexNewRowAlgorithmV3";


    public static final String LAYOUT_IGNORE_MARGINS_FOR_STICKY = "LayoutIgnoreMarginsForSticky";


    public static final String LAYOUT_NEW_OVERFLOW_LOGIC = "LayoutNewOverflowLogic";


    public static final String LAYOUT_NEW_SNAP_LOGIC = "LayoutNewSnapLogic";


    public static final String LAYOUT_NEW_STICKY_LOGIC = "LayoutNewStickyLogic";


    public static final String LAYOUT_NG_NO_COPY_BACK = "LayoutNGNoCopyBack";


    public static final String LAYOUT_NG_SHAPE_CACHE = "LayoutNGShapeCache";


    public static final String LCP_MOUSEOVER_HEURISTICS = "LCPMouseoverHeuristics";


    public static final String LCP_MULTIPLE_UPDATES_PER_ELEMENT = "LCPMultipleUpdatesPerElement";


    public static final String LOAD_INPUT_IMAGE_WITHOUT_OBJECT = "LoadInputImageWithoutObject";


    public static final String LONG_ANIMATION_FRAME_MONITORING = "LongAnimationFrameMonitoring";


    public static final String LONG_ANIMATION_FRAME_TIMING = "LongAnimationFrameTiming";


    public static final String LONG_ANIMATION_FRAME_UKM = "LongAnimationFrameUKM";


    public static final String LONG_TASK_FROM_LONG_ANIMATION_FRAME = "LongTaskFromLongAnimationFrame";


    public static final String MANAGED_CONFIGURATION = "ManagedConfiguration";


    public static final String MEDIA_SESSION_ENTER_PICTURE_IN_PICTURE = "MediaSessionEnterPictureInPicture";


    public static final String MONITOR_TYPE_SURFACES = "MonitorTypeSurfaces";


    public static final String MUTATION_EVENTS = "MutationEvents";


    public static final String NAVIGATE_EVENT_CANCELABLE_TRAVERSALS = "NavigateEventCancelableTraversals";


    public static final String NAVIGATE_EVENT_COMMIT_BEHAVIOR = "NavigateEventCommitBehavior";


    public static final String NAVIGATE_EVENT_SOURCE_ELEMENT = "NavigateEventSourceElement";


    public static final String NAVIGATION_ID = "NavigationId";


    public static final String NET_INFO_CONSTANT_TYPE = "NetInfoConstantType";


    public static final String NON_COMPOSED_ENTER_LEAVE_EVENTS = "NonComposedEnterLeaveEvents";


    public static final String NON_INHERITED_WEBKIT_BOX_DIRECTION = "NonInheritedWebkitBoxDirection";


    public static final String NON_STANDARD_APPEARANCE_VALUES_HIGH_USAGE = "NonStandardAppearanceValuesHighUsage";


    public static final String NON_STANDARD_APPEARANCE_VALUE_SLIDER_VERTICAL = "NonStandardAppearanceValueSliderVertical";


    public static final String NON_STANDARD_APPEARANCE_VALUES_LOW_USAGE = "NonStandardAppearanceValuesLowUsage";


    public static final String OBSERVABLE_API = "ObservableAPI";


    public static final String OFFSET_PARENT_NEW_SPEC_BEHAVIOR = "OffsetParentNewSpecBehavior";


    public static final String OPTIMIZED_NODE_CLONE_ORDER = "OptimizedNodeCloneOrder";


    public static final String OPTION_ELEMENT_ALWAYS_USE_LABEL = "OptionElementAlwaysUseLabel";


    public static final String OVERFLOW_OVERLAY_ALIASES_AUTO = "OverflowOverlayAliasesAuto";


    public static final String PAGE_REVEAL_EVENT = "PageRevealEvent";


    public static final String PAINT_FLEX_GRID_SORTED_BY_ORDER = "PaintFlexGridSortedByOrder";


    public static final String PARAKEET = "Parakeet";


    public static final String PASSWORD_STRONG_LABEL = "PasswordStrongLabel";


    public static final String PASTING_BLOCKS_SVG_USE_NON_LOCAL_HREFS = "PastingBlocksSVGUseNonLocalHrefs";


    public static final String PAYMENT_HANDLER_MINIMAL_HEADER_UX = "PaymentHandlerMinimalHeaderUX";


    public static final String PAYMENT_REQUEST_ALLOW_ONE_ACTIVATIONLESS_SHOW = "PaymentRequestAllowOneActivationlessShow";


    public static final String PERFORMANCE_NAVIGATE_SYSTEM_ENTROPY = "PerformanceNavigateSystemEntropy";


    public static final String POINTER_EVENT_DEVICE_ID = "PointerEventDeviceId";


    public static final String POPOVER_DIALOG_DONT_THROW = "PopoverDialogDontThrow";


    public static final String PORTALS = "Portals";


    public static final String POSITION_OUTSIDE_TAB_SPAN_CHECK_SIBLING_NODE = "PositionOutsideTabSpanCheckSiblingNode";


    public static final String PREFERS_REDUCED_TRANSPARENCY = "PrefersReducedTransparency";


    public static final String PRE_PAINT_ANCESTORS_OF_MISSED_OOF = "PrePaintAncestorsOfMissedOOF";


    public static final String PRERENDER2 = "Prerender2";


    public static final String PRETTY_PRINT_JSON_DOCUMENT = "PrettyPrintJSONDocument";


    public static final String QUICK_INTENSIVE_WAKE_UP_THROTTLING_AFTER_LOADING = "QuickIntensiveWakeUpThrottlingAfterLoading";


    public static final String READABLE_STREAM_TEE_CLONE_FOR_BRANCH2 = "ReadableStreamTeeCloneForBranch2";


    public static final String REDUCE_COOKIE_IP_CS = "ReduceCookieIPCs";


    public static final String REDUCE_USER_AGENT_ANDROID_VERSION_DEVICE_MODEL = "ReduceUserAgentAndroidVersionDeviceModel";


    public static final String REDUCE_USER_AGENT_MINOR_VERSION = "ReduceUserAgentMinorVersion";


    public static final String REDUCE_USER_AGENT_PLATFORM_OS_CPU = "ReduceUserAgentPlatformOsCpu";


    public static final String REMOTE_PLAYBACK_BACKEND = "RemotePlaybackBackend";


    public static final String REMOVE_DANGLING_MARKUP_IN_TARGET = "RemoveDanglingMarkupInTarget";


    public static final String REMOVE_DATA_URL_IN_SVG_USE = "RemoveDataUrlInSvgUse";


    public static final String RTC_ENCODED_AUDIO_FRAME_ABS_CAPTURE_TIME = "RTCEncodedAudioFrameAbsCaptureTime";


    public static final String RTC_ENCODED_FRAME_SET_METADATA = "RTCEncodedFrameSetMetadata";


    public static final String RTC_ENCODED_VIDEO_FRAME_ADDITIONAL_METADATA = "RTCEncodedVideoFrameAdditionalMetadata";


    public static final String RTC_RTP_ENCODING_PARAMETERS_CODEC = "RTCRtpEncodingParametersCodec";


    public static final String RTC_RTP_HEADER_EXTENSION_CONTROL = "RTCRtpHeaderExtensionControl";


    public static final String RTC_SVC_SCALABILITY_MODE = "RTCSvcScalabilityMode";


    public static final String SANITIZER_API = "SanitizerAPI";


    public static final String SAVE_AS_WITH_DECLARATIVE_SHADOW_DOM = "SaveAsWithDeclarativeShadowDOM";


    public static final String SCHEDULER_YIELD = "SchedulerYield";


    public static final String SCRIPTING_MEDIA_FEATURE = "ScriptingMediaFeature";


    public static final String SCROLLBAR_COLOR = "ScrollbarColor";


    public static final String SCROLLBAR_WIDTH = "ScrollbarWidth";


    public static final String SCROLL_END_EVENTS = "ScrollEndEvents";


    public static final String SCROLL_TIMELINE = "ScrollTimeline";


    public static final String SCROLL_TIMELINE_CURRENT_TIME = "ScrollTimelineCurrentTime";


    public static final String SCROLL_TIMELINE_ON_COMPOSITOR = "ScrollTimelineOnCompositor";


    public static final String SECURE_PAYMENT_CONFIRMATION_ALLOW_ONE_ACTIVATIONLESS_SHOW = "SecurePaymentConfirmationAllowOneActivationlessShow";


    public static final String SECURE_PAYMENT_CONFIRMATION_EXTENSIONS = "SecurePaymentConfirmationExtensions";


    public static final String SELECT_HR = "SelectHr";


    public static final String SEND_MOUSE_EVENTS_DISABLED_FORM_CONTROLS = "SendMouseEventsDisabledFormControls";


    public static final String SET_SEQUENTIAL_FOCUS_STARTING_POINT = "SetSequentialFocusStartingPoint";


    public static final String SIMPLIFIED_CLEAR_PROPERTY_TREE_CHANGE = "SimplifiedClearPropertyTreeChange";


    public static final String SKIP_SHADOW_HOST_WHEN_HOVERING_FOR_TOOLTIP = "SkipShadowHostWhenHoveringForTooltip";


    public static final String SKIP_TOUCH_EVENT_FILTER = "SkipTouchEventFilter";


    public static final String SMART_CARD = "SmartCard";


    public static final String SMIL_AUTO_SUSPEND_ON_LAG = "SmilAutoSuspendOnLag";


    public static final String SNAP_BORDER_WIDTHS_BEFORE_LAYOUT = "SnapBorderWidthsBeforeLayout";


    public static final String SOFT_NAVIGATION_HEURISTICS = "SoftNavigationHeuristics";


    public static final String SOFT_NAVIGATION_HEURISTICS_EXPOSE_FP_AND_FCP = "SoftNavigationHeuristicsExposeFPAndFCP";


    public static final String SOLID_COLOR_LAYERS = "SolidColorLayers";


    public static final String SPARSE_OBJECT_PAINT_PROPERTIES = "SparseObjectPaintProperties";


    public static final String SPECULATION_RULES_DOCUMENT_RULES_SELECTOR_MATCHES = "SpeculationRulesDocumentRulesSelectorMatches";


    public static final String SPECULATION_RULES_EAGERNESS = "SpeculationRulesEagerness";


    public static final String SPECULATION_RULES_POINTER_DOWN_HEURISTICS = "SpeculationRulesPointerDownHeuristics";


    public static final String SPECULATION_RULES_POINTER_HOVER_HEURISTICS = "SpeculationRulesPointerHoverHeuristics";


    public static final String SPECULATION_RULES_PREFETCH_PROXY = "SpeculationRulesPrefetchProxy";


    public static final String STORAGE_ACCESS_API = "StorageAccessAPI";


    public static final String STORAGE_ACCESS_API_FOR_ORIGIN_EXTENSION = "StorageAccessAPIForOriginExtension";


    public static final String STORAGE_BUCKETS = "StorageBuckets";


    public static final String STORAGE_BUCKETS_DURABILITY = "StorageBucketsDurability";


    public static final String STORAGE_BUCKETS_LOCKS = "StorageBucketsLocks";


    public static final String SUGGESTION_PICKER_DARK_MODE_SUPPORT = "SuggestionPickerDarkModeSupport";


    public static final String SVG_CROSS_ORIGIN_ATTRIBUTE = "SvgCrossOriginAttribute";


    public static final String SVG_NO_PIXEL_SNAPPING_SCALE_ADJUSTMENT = "SvgNoPixelSnappingScaleAdjustment";


    public static final String SVG_RASTER_OPTIMIZATIONS = "SvgRasterOptimizations";


    public static final String SVG_TEXT_FIX_HITTEST_AFTER_SCALE = "SvgTextFixHittestAfterScale";


    public static final String SVG_TEXT_SKIP_ZERO_LENGTH_ITEMS = "SvgTextSkipZeroLengthItems";


    public static final String TEXT_FRAGMENT_ANCHOR = "TextFragmentAnchor";


    public static final String TEXT_METRICS_BASELINES = "TextMetricsBaselines";


    public static final String TIMELINE_SCOPE = "TimelineScope";


    public static final String UNOWNED_ANIMATIONS_SKIP_CSS_EVENTS = "UnownedAnimationsSkipCSSEvents";


    public static final String URL_CAN_PARSE = "URLCanParse";


    public static final String URL_SEARCH_PARAMS_HAS_AND_DELETE_MULTIPLE_ARGS = "URLSearchParamsHasAndDeleteMultipleArgs";


    public static final String USE_BEGIN_FRAME_PRESENTATION_FEEDBACK = "UseBeginFramePresentationFeedback";


    public static final String USED_COLOR_SCHEME_ROOT_SCROLLBARS = "UsedColorSchemeRootScrollbars";


    public static final String USER_AGENT_CLIENT_HINT = "UserAgentClientHint";


    public static final String USER_VALID_USER_INVALID = "UserValidUserInvalid";


    public static final String VIEWPORT_HEIGHT_CLIENT_HINT_HEADER = "ViewportHeightClientHintHeader";


    public static final String VIEW_TRANSITION_LAYOUT_OBJECT_VISUAL_OVERFLOW = "ViewTransitionLayoutObjectVisualOverflow";


    public static final String VIEW_TRANSITION_ON_NAVIGATION = "ViewTransitionOnNavigation";


    public static final String WARN_SANDBOX_INEFFECTIVE = "WarnSandboxIneffective";


    public static final String WEB_APP_ENABLE_DARK_MODE = "WebAppEnableDarkMode";


    public static final String WEB_APP_ENABLE_LAUNCH_HANDLER = "WebAppEnableLaunchHandler";


    public static final String DESKTOP_PW_AS_TAB_STRIP = "DesktopPWAsTabStrip";


    public static final String DESKTOP_PW_AS_TAB_STRIP_CUSTOMIZATIONS = "DesktopPWAsTabStripCustomizations";


    public static final String WEB_APP_ENABLE_TRANSLATIONS = "WebAppEnableTranslations";


    public static final String WEB_AUTHENTICATION_JSON_SERIALIZATION = "WebAuthenticationJSONSerialization";


    public static final String WEB_AUTHENTICATION_PRF_EXTENSION = "WebAuthenticationPRFExtension";


    public static final String WEB_ENVIRONMENT_INTEGRITY = "WebEnvironmentIntegrity";


    public static final String WEB_FONT_RESIZE_LCP = "WebFontResizeLCP";


    public static final String WEB_IDL_BIG_INT_USES_TO_BIG_INT = "WebIDLBigIntUsesToBigInt";


    public static final String WEB_PREFERENCES = "WebPreferences";


    public static final String WEB_XR_ENABLED_FEATURES = "WebXREnabledFeatures";


    public static final String WGI_GAMEPAD_TRIGGER_RUMBLE = "WGIGamepadTriggerRumble";


    public static final String WINDOW_DEFAULT_STATUS = "WindowDefaultStatus";


    public static final String WINDOW_PLACEMENT_FULLSCREEN_ON_SCREENS_CHANGE = "WindowPlacementFullscreenOnScreensChange";


    public static final String WINDOW_PLACEMENT_PERMISSION_ALIAS = "WindowPlacementPermissionAlias";


    public static final String XML_PARSER_MERGE_ADJACENT_C_DATA_SECTIONS = "XMLParserMergeAdjacentCDataSections";


    public static final String XYWH_AND_RECT_COMPUTED_VALUE = "XYWHAndRectComputedValue";


    public static final String ZERO_COPY_TAB_CAPTURE = "ZeroCopyTabCapture";


    public static final String ACCELERATED_STATIC_BITMAP_IMAGE_SERIALIZATION = "AcceleratedStaticBitmapImageSerialization";

    // Enable the Protected Audience's reporting with ad macro API.
    public static final String AD_AUCTION_REPORTING_WITH_MACRO_API = "AdAuctionReportingWithMacroApi";

    // Controls the capturing of the Ad-Auction-Signals header, and the maximum
    // allowed Ad-Auction-Signals header value.
    public static final String AD_AUCTION_SIGNALS = "AdAuctionSignals";

    // See https://github.com/WICG/turtledove/blob/main/FLEDGE.md
    // Changes default Permissions Policy for features join-ad-interest-group and
    // run-ad-auction to a more restricted EnableForSelf.
    public static final String AD_INTEREST_GROUP_API_RESTRICTED_POLICY_BY_DEFAULT = "AdInterestGroupAPIRestrictedPolicyByDefault";

    // Make all pending 'display: auto' web fonts enter the swap or failure period
    // immediately before reaching the LCP time limit (~2500ms), so that web fonts
    // do not become a source of bad LCP.
    public static final String ALIGN_FONT_DISPLAY_AUTO_TIMEOUT_WITH_LCP_GOAL = "AlignFontDisplayAutoTimeoutWithLCPGoal";


    public static final String ALLOW_DEV_TOOLS_MAIN_THREAD_DEBUGGER_FOR_MULTIPLE_MAIN_FRAMES = "AllowDevToolsMainThreadDebuggerForMultipleMainFrames";

    // When enabled, allow dropping alpha on media streams for rendering sinks if
    // other sinks connected do not use alpha.
    public static final String ALLOW_DROP_ALPHA_FOR_MEDIA_STREAM = "AllowDropAlphaForMediaStream";

    // TODO(https://crbug.com/1331187): Delete the flag.
    public static final String ALLOW_PAGE_WITH_IDB_CONNECTION_IN_BF_CACHE = "AllowPageWithIDBConnectionInBFCache";

    // TODO(https://crbug.com/1331187): Delete the flag.
    public static final String ALLOW_PAGE_WITH_IDB_TRANSACTION_IN_BF_CACHE = "AllowPageWithIDBTransactionInBFCache";


    public static final String ALLOW_SOURCE_SWITCH_ON_PAUSED_VIDEO_MEDIA_STREAM = "AllowSourceSwitchOnPausedVideoMediaStream";

    // Allows for synchronous XHR requests during page dismissal
    public static final String ALLOW_SYNC_XHR_IN_PAGE_DISMISSAL = "AllowSyncXHRInPageDismissal";

    // Enables URN URLs like those produced by FLEDGE auctions to be displayed by
    // iframes (instead of requiring fenced frames). This is only intended to be
    // enabled as part of the FLEDGE origin trial.
    public static final String ALLOW_UR_NS_IN_IFRAMES = "AllowURNsInIframes";

    // Anchor Element Interaction
    public static final String ANCHOR_ELEMENT_INTERACTION = "AnchorElementInteraction";

    // Enable anchor element mouse motion estimator.
    public static final String ANCHOR_ELEMENT_MOUSE_MOTION_ESTIMATOR = "AnchorElementMouseMotionEstimator";


    public static final String ANDROID_EXTENDED_KEYBOARD_SHORTCUTS = "AndroidExtendedKeyboardShortcuts";

    // A server-side switch for the kRealtimeAudio thread type of
    // RealtimeAudioWorkletThread object. This can be controlled by a field trial,
    // it will use the kNormal type thread when disabled.
    public static final String AUDIO_WORKLET_THREAD_REALTIME_PRIORITY = "AudioWorkletThreadRealtimePriority";

    // If enabled, whenever form controls are removed from the DOM, the ChromeClient
    // is informed about this. This enables Autofill to trigger a reparsing of
    // forms.
    public static final String AUTOFILL_DETECT_REMOVED_FORM_CONTROLS = "AutofillDetectRemovedFormControls";

    // If disabled (default for many years), autofilling triggers KeyDown and
    // KeyUp events that do not send any key codes. If enabled, these events
    // contain the "Unidentified" key.
    public static final String AUTOFILL_SEND_UNIDENTIFIED_KEY_AFTER_FILL = "AutofillSendUnidentifiedKeyAfterFill";

    // When enabled, Autofill will start identifying web elements using DOMNodeIds
    // instead of static counters.
    public static final String AUTOFILL_USE_DOM_NODE_ID_FOR_RENDERER_ID = "AutofillUseDomNodeIdForRendererId";

    // Apply lazy-loading to ad frames which have embeds likely impacting Core Web
    // Vitals.
    public static final String AUTOMATIC_LAZY_FRAME_LOADING_TO_ADS = "AutomaticLazyFrameLoadingToAds";

    // Apply lazy-loading to frames which have embeds likely impacting Core Web
    // Vitals.
    public static final String AUTOMATIC_LAZY_FRAME_LOADING_TO_EMBEDS = "AutomaticLazyFrameLoadingToEmbeds";

    // Define the allowed websites to use LazyEmbeds. The allowed websites need to
    // be defined separately from kAutomaticLazyFrameLoadingToEmbeds because we want
    // to gather Blink.AutomaticLazyLoadFrame.LazyEmbedFrameCount UKM data even when
    // kAutomaticLazyFrameLoadingToEmbeds is disabled.
    public static final String AUTOMATIC_LAZY_FRAME_LOADING_TO_EMBED_URLS = "AutomaticLazyFrameLoadingToEmbedUrls";


    public static final String AVIF_GAINMAP_HDR_IMAGES = "AvifGainmapHdrImages";


    public static final String BACK_FORWARD_CACHE_DWC_ON_JAVA_SCRIPT_EXECUTION = "BackForwardCacheDWCOnJavaScriptExecution";

    // Allows pages with keepalive requests to stay eligible for the back/forward
    // cache. See https://crbug.com/1347101 for more details.
    public static final String BACK_FORWARD_CACHE_WITH_KEEPALIVE_REQUEST = "BackForwardCacheWithKeepaliveRequest";

    // Enable background resource fetch in Blink. See https://crbug.com/1379780 for
    // more details.
    public static final String BACKGROUND_RESOURCE_FETCH = "BackgroundResourceFetch";

    // Used to configure a per-origin allowlist of performance.mark events that are
    // permitted to be included in slow reports traces. See crbug.com/1181774.
    public static final String BACKGROUND_TRACING_PERFORMANCE_MARK = "BackgroundTracingPerformanceMark";

    // See https://github.com/WICG/turtledove/blob/main/FLEDGE.md
    // Feature flag to enable debug reporting APIs.
    // Due to an issue in how prevWins were stored this flag should not be enabled
    // until July 2023.
    public static final String BIDDING_AND_SCORING_DEBUG_REPORTING_API = "BiddingAndScoringDebugReportingAPI";

    // Blink garbage collection.
    // Enables compaction of backing stores on Blink's heap.
    public static final String BLINK_HEAP_COMPACTION = "BlinkHeapCompaction";

    // Enables concurrently marking Blink's heap.
    public static final String BLINK_HEAP_CONCURRENT_MARKING = "BlinkHeapConcurrentMarking";

    // Enables concurrently sweeping Blink's heap.
    public static final String BLINK_HEAP_CONCURRENT_SWEEPING = "BlinkHeapConcurrentSweeping";

    // Enables incrementally marking Blink's heap.
    public static final String BLINK_HEAP_INCREMENTAL_MARKING = "BlinkHeapIncrementalMarking";

    // Enables a marking stress mode that schedules more garbage collections and
    // also adds additional verification passes.
    public static final String BLINK_HEAP_INCREMENTAL_MARKING_STRESS = "BlinkHeapIncrementalMarkingStress";

    // Enable intervention for download that was initiated from or occurred in an ad
    // frame without user activation.
    public static final String BLOCKING_DOWNLOADS_IN_AD_FRAME_WITHOUT_USER_ACTIVATION = "BlockingDownloadsInAdFrameWithoutUserActivation";

    // Boost the priority of the first N not-small images.
    // crbug.com/1431169
    public static final String BOOST_IMAGE_PRIORITY = "BoostImagePriority";

    // https://github.com/patcg-individual-drafts/topics
    // Kill switch for the Topics API.
    public static final String BROWSING_TOPICS = "BrowsingTopics";

    // If enabled, the check for whether the IP address is publicly routable will be
    // bypassed when determining the eligibility for a page to be included in topics
    // calculation. This is useful for developers to test in local environment.
    public static final String BROWSING_TOPICS_BYPASS_IP_IS_PUBLICLY_ROUTABLE_CHECK = "BrowsingTopicsBypassIPIsPubliclyRoutableCheck";

    // Enables calling the Topics API through Javascript (i.e.
    // document.browsingTopics()). For this feature to take effect, the main Topics
    // feature has to be enabled first (i.e. `kBrowsingTopics` is enabled, and,
    // either a valid Origin Trial token exists or `kPrivacySandboxAdsAPIsOverride`
    // is enabled.)
    public static final String BROWSING_TOPICS_DOCUMENT_API = "BrowsingTopicsDocumentAPI";

    // Decoupled with the main `kBrowsingTopics` feature, so it allows us to
    // decouple the server side configs.
    public static final String BROWSING_TOPICS_PARAMETERS = "BrowsingTopicsParameters";

    // Enables the deprecatedBrowsingTopics XHR attribute. For this feature to take
    // effect, the main Topics feature has to be enabled first (i.e.
    // `kBrowsingTopics` is enabled, and, either a valid Origin Trial token exists
    // or `kPrivacySandboxAdsAPIsOverride` is enabled.)
    public static final String BROWSING_TOPICS_XHR = "BrowsingTopicsXHR";

    // Suppresses console errors for CORS problems which report an associated
    // inspector issue anyway.
    public static final String CORS_ERRORS_ISSUE_ONLY = "CORSErrorsIssueOnly";

    // When enabled, code cache is produced asynchronously from the script execution
    // (https://crbug.com/1260908).
    public static final String CACHE_CODE_ON_IDLE = "CacheCodeOnIdle";

    // When enabled allows the header name used in the blink
    // CacheStorageCodeCacheHint runtime feature to be modified.  This runtime
    // feature disables generating full code cache for responses stored in
    // cache_storage during a service worker install event.  The runtime feature
    // must be enabled via the blink runtime feature mechanism, however.
    public static final String CACHE_STORAGE_CODE_CACHE_HINT_HEADER = "CacheStorageCodeCacheHintHeader";

    // Whether to losslessly compress the resulting image after canvas hibernation.
    public static final String CANVAS_COMPRESS_HIBERNATED_IMAGE = "CanvasCompressHibernatedImage";

    // Whether to aggressively free resources for canvases in background pages.
    public static final String CANVAS_FREE_MEMORY_WHEN_HIDDEN = "CanvasFreeMemoryWhenHidden";


    public static final String CHECK_HTML_PARSER_BUDGET_LESS_OFTEN = "CheckHTMLParserBudgetLessOften";

    // Enable `sec-ch-dpr` client hint.
    public static final String CLIENT_HINTS_DPR = "ClientHintsDPR";

    // Enable legacy `dpr` client hint.
    public static final String CLIENT_HINTS_DPR_DEPRECATED = "ClientHintsDPR_DEPRECATED";

    // Enable `sec-ch-device-memory` client hint.
    public static final String CLIENT_HINTS_DEVICE_MEMORY = "ClientHintsDeviceMemory";

    // Enable legacy `device-memory` client hint.
    public static final String CLIENT_HINTS_DEVICE_MEMORY_DEPRECATED = "ClientHintsDeviceMemory_DEPRECATED";

    // Enable `form-factor` client hint.
    public static final String CLIENT_HINTS_FORM_FACTOR = "ClientHintsFormFactor";

    // Enable `sec-ch-prefers-reduced-transparency` client hint.
    public static final String CLIENT_HINTS_PREFERS_REDUCED_TRANSPARENCY = "ClientHintsPrefersReducedTransparency";

    // Enable `sec-ch-width` client hint.
    public static final String CLIENT_HINTS_RESOURCE_WIDTH = "ClientHintsResourceWidth";

    // Enable legacy `width` client hint.
    public static final String CLIENT_HINTS_RESOURCE_WIDTH_DEPRECATED = "ClientHintsResourceWidth_DEPRECATED";

    // Enable `save-data` client hint.
    public static final String CLIENT_HINTS_SAVE_DATA = "ClientHintsSaveData";

    // Enable `sec-ch-viewport-width` client hint.
    public static final String CLIENT_HINTS_VIEWPORT_WIDTH = "ClientHintsViewportWidth";

    // Enable legacy `viewport-width` client hint.
    public static final String CLIENT_HINTS_VIEWPORT_WIDTH_DEPRECATED = "ClientHintsViewportWidth_DEPRECATED";


    public static final String CLIPBOARD_UNSANITIZED_CONTENT = "ClipboardUnsanitizedContent";

    // Disabling this will cause parkable strings to never be compressed.
    // This is useful for headless mode + virtual time. Since virtual time advances
    // quickly, strings may be parked too eagerly in that mode.
    public static final String COMPRESS_PARKABLE_STRINGS = "CompressParkableStrings";

    // Controls off-thread code cache consumption.
    public static final String CONSUME_CODE_CACHE_OFF_THREAD = "ConsumeCodeCacheOffThread";

    // Enables the constant streaming in the ContentCapture task.
    public static final String CONTENT_CAPTURE_CONSTANT_STREAMING = "ContentCaptureConstantStreaming";


    public static final String CORRECT_FLOAT_EXTENSION_TEST_FOR_WEB_GL = "CorrectFloatExtensionTestForWebGL";

    // When enabled, add a new option, {imageOrientation: 'none'}, to
    // createImageBitmap, which ignores the image orientation metadata of the source
    // and renders the image as encoded.
    public static final String CREATE_IMAGE_BITMAP_ORIENTATION_NONE = "CreateImageBitmapOrientationNone";


    public static final String DOM_CONTENT_LOADED_WAIT_FOR_ASYNC_SCRIPT = "DOMContentLoadedWaitForAsyncScript";


    public static final String DECODE_SCRIPT_SOURCE_OFF_THREAD = "DecodeScriptSourceOffThread";

    // When enabled, pages that don't specify a layout width will default to the
    // window width rather than the traditional mobile fallback width of 980px.
    // Has no effect unless viewport handling is enabled.
    public static final String DEFAULT_VIEWPORT_IS_DEVICE_WIDTH = "DefaultViewportIsDeviceWidth";


    public static final String DELAY_ASYNC_SCRIPT_EXECUTION = "DelayAsyncScriptExecution";


    public static final String DELAY_LOW_PRIORITY_REQUESTS_ACCORDING_TO_NETWORK_STATE = "DelayLowPriorityRequestsAccordingToNetworkState";


    public static final String DIRECT_COMPOSITOR_THREAD_IPC = "DirectCompositorThreadIpc";


    public static final String DISABLE_ARRAY_BUFFER_SIZE_LIMITS_FOR_TESTING = "DisableArrayBufferSizeLimitsForTesting";


    public static final String DISCARD_INPUT_EVENTS_TO_RECENTLY_MOVED_FRAMES = "DiscardInputEventsToRecentlyMovedFrames";


    public static final String DISABLE_THIRD_PARTY_STORAGE_PARTITIONING_DEPRECATION_TRIAL = "DisableThirdPartyStoragePartitioningDeprecationTrial";

    // When enabled, the beforeunload handler is dispatched when a frame is frozen.
    // This allows the browser to know whether discarding the frame could result in
    // lost user data, at the cost of extra CPU usage. The feature will be removed
    // once we have determine whether the CPU cost is acceptable.
    public static final String DISPATCH_BEFORE_UNLOAD_ON_FREEZE = "DispatchBeforeUnloadOnFreeze";

    // Enable Display Locking JavaScript APIs.
    public static final String DISPLAY_LOCKING = "DisplayLocking";

    // Drop input events before user sees first paint https://crbug.com/1255485
    public static final String DROP_INPUT_EVENTS_BEFORE_FIRST_PAINT = "DropInputEventsBeforeFirstPaint";

    // TODO(https://crbug.com/1417126): This is disabled because of a suspicious
    // flake in AR/XR tests.
    public static final String DROPPED_TOUCH_SEQUENCE_INCLUDES_TOUCH_END = "DroppedTouchSequenceIncludesTouchEnd";

    // Enable eagerly setting up a CacheStorage interface pointer and
    // passing it to service workers on startup as an optimization.
    public static final String EAGER_CACHE_STORAGE_SETUP_FOR_SERVICE_WORKERS = "EagerCacheStorageSetupForServiceWorkers";


    public static final String EARLY_EXIT_ON_NOOP_CLASS_OR_STYLE_CHANGE = "EarlyExitOnNoopClassOrStyleChange";


    public static final String ESTABLISH_GPU_CHANNEL_ASYNC = "EstablishGpuChannelAsync";

    // Enables reporting Event Timing with matching presentation promise index only.
    public static final String EVENT_TIMING_MATCH_PRESENTATION_INDEX = "EventTimingMatchPresentationIndex";

    // Enables reporting Event Timing entries with a smaller presentation index on
    // resolved painted presentation.
    public static final String EVENT_TIMING_REPORT_ALL_EARLY_ENTRIES_ON_PAINTED_PRESENTATION = "EventTimingReportAllEarlyEntriesOnPaintedPresentation";

    // Enables unload handler deprecation via Permissions-Policy.
    // https://crbug.com/1324111
    public static final String DEPRECATE_UNLOAD = "DeprecateUnload";

    // Controls whether LCP calculations should exclude low-entropy images. If
    // enabled, then the associated parameter sets the cutoff, expressed as the
    // minimum number of bits of encoded image data used to encode each rendered
    // pixel. Note that this is not just pixels of decoded image data; the rendered
    // size includes any scaling applied by the rendering engine to display the
    // content.
    public static final String EXCLUDE_LOW_ENTROPY_IMAGES_FROM_LCP = "ExcludeLowEntropyImagesFromLCP";

    // Enable the <fencedframe> element; see crbug.com/1123606. Note that enabling
    // this feature does not automatically expose this element to the web, it only
    // allows the element to be enabled by the runtime enabled feature, for origin
    // trials.
    public static final String FENCED_FRAMES = "FencedFrames";

    // Enable the new fenced frame-related features in M119. (These are
    // conditionally dependent on other fenced frame-related feature flags being
    // enabled.)
    // * Extra format for ad size macro substitution:
    //   ${AD_WIDTH} and ${AD_HEIGHT}, on top of the previous
    //   {%AD_WIDTH%} and {%AD_HEIGHT%}.
    // * Input validation (no disallowed URI component characters) in
    //   registerAdMacro keys and values.
    // * Send automatic beacons to all registered destinations without requiring
    //   event data to be in place.
    public static final String FENCED_FRAMES_M119_FEATURES = "FencedFramesM119Features";

    // File handling icons. https://crbug.com/1218213
    public static final String FILE_HANDLING_ICONS = "FileHandlingIcons";


    public static final String FILE_SYSTEM_URL_NAVIGATION = "FileSystemUrlNavigation";


    public static final String FILE_SYSTEM_URL_NAVIGATION_FOR_CHROME_APPS_ONLY = "FileSystemUrlNavigationForChromeAppsOnly";


    public static final String FILTERING_SCROLL_PREDICTION = "FilteringScrollPrediction";


    public static final String FIX_GESTURE_SCROLL_QUEUING_BUG = "FixGestureScrollQueuingBug";

    // See https://github.com/WICG/turtledove/blob/main/FLEDGE.md
    // Enables FLEDGE implementation. See https://crbug.com/1186444.
    public static final String FLEDGE = "Fledge";

    // See
    // https://github.com/WICG/turtledove/blob/main/FLEDGE_browser_bidding_and_auction_API.md
    public static final String FLEDGE_BIDDING_AND_AUCTION_SERVER = "FledgeBiddingAndAuctionServer";

    // See in the header.
    public static final String FLEDGE_CONSIDER_K_ANONYMITY = "FledgeConsiderKAnonymity";


    public static final String FLEDGE_ENFORCE_K_ANONYMITY = "FledgeEnforceKAnonymity";


    public static final String FLEDGE_PASS_K_ANON_STATUS_TO_REPORT_WIN = "FledgePassKAnonStatusToReportWin";


    public static final String FLEDGE_PASS_RECENCY_TO_GENERATE_BID = "FledgePassRecencyToGenerateBid";


    public static final String FORCE_DEFER_SCRIPT_INTERVENTION = "ForceDeferScriptIntervention";


    public static final String FORCE_HIGH_PERFORMANCE_GPU_FOR_WEB_GL = "ForceHighPerformanceGPUForWebGL";


    public static final String FORCE_IN_ORDER_SCRIPT = "ForceInOrderScript";


    public static final String FORCE_MAJOR_VERSION_IN_MINOR_POSITION_IN_USER_AGENT = "ForceMajorVersionInMinorPositionInUserAgent";

    // Automatically convert light-themed pages to use a Blink-generated dark theme
    public static final String FORCE_WEB_CONTENTS_DARK_MODE = "WebContentsForceDark";

    // Enables the frequency capping for detecting large sticky ads.
    // Large-sticky-ads are those ads that stick to the bottom of the page
    // regardless of a user’s efforts to scroll, and take up more than 30% of the
    // screen’s real estate.
    public static final String FREQUENCY_CAPPING_FOR_LARGE_STICKY_AD_DETECTION = "FrequencyCappingForLargeStickyAdDetection";

    // Enables the frequency capping for detecting overlay popups. Overlay-popups
    // are the interstitials that pop up and block the main content of the page.
    public static final String FREQUENCY_CAPPING_FOR_OVERLAY_POPUP_DETECTION = "FrequencyCappingForOverlayPopupDetection";


    public static final String GMS_CORE_EMOJI = "GMSCoreEmoji";


    public static final String GAINMAP_HDR_IMAGES = "GainmapHdrImages";


    public static final String HIDDEN_SELECTION_BOUNDS = "HiddenSelectionBounds";


    public static final String IMAGE_LOADING_PRIORITIZATION_FIX = "ImageLoadingPrioritizationFix";


    public static final String INDEXED_DB_COMPRESS_VALUES_WITH_SNAPPY = "IndexedDBCompressValuesWithSnappy";


    public static final String INPUT_PREDICTOR_TYPE_CHOICE = "InputPredictorTypeChoice";

    // The base::Feature is enabled by default on all platforms. However, on
    // Android, it has no effect because page freezing kicks in at the same time. It
    // would have an effect if the grace period ("grace_period_seconds" param) was
    // reduced.
    public static final String INTENSIVE_WAKE_UP_THROTTLING = "IntensiveWakeUpThrottling";

    // Kill switch for the Interest Group API, i.e. if disabled, the
    // API exposure will be disabled regardless of the OT config.
    public static final String INTEREST_GROUP_STORAGE = "InterestGroupStorage";

    // Allow process isolation of iframes with the 'sandbox' attribute set. Whether
    // or not such an iframe will be isolated may depend on options specified with
    // the attribute. Note: At present, only iframes with origin-restricted
    // sandboxes are isolated.
    public static final String ISOLATE_SANDBOXED_IFRAMES = "IsolateSandboxedIframes";


    public static final String KALMAN_DIRECTION_CUT_OFF = "KalmanDirectionCutOff";


    public static final String KALMAN_HEURISTICS = "KalmanHeuristics";


    public static final String KEEP_ALIVE_IN_BROWSER_MIGRATION = "KeepAliveInBrowserMigration";

    // Enables reporting as LCP of the time the first frame of an animated image was
    // painted.
    public static final String LCP_ANIMATED_IMAGES_REPORTING = "LCPAnimatedImagesReporting";


    public static final String LCP_CRITICAL_PATH_PREDICTOR = "LCPCriticalPathPredictor";


    public static final String LCP_SCRIPT_OBSERVER = "LCPScriptObserver";


    public static final String LCPP_FONT_URL_PREDICTOR = "LCPPFontURLPredictor";

    // Enables reporting as LCP of the time the first frame of a video was painted.
    public static final String LCP_VIDEO_FIRST_FRAME = "LCPVideoFirstFrame";

    // A feature to reduce the set of resources fetched by No-State Prefetch.
    public static final String LIGHTWEIGHT_NO_STATE_PREFETCH = "LightweightNoStatePrefetch";


    public static final String LINK_PREVIEW = "LinkPreview";


    public static final String LINK_PREVIEW_NAVIGATION = "LinkPreviewNavigation";

    // A feature to control whether the loading phase should be extended beyond
    // First Meaningful Paint by a configurable buffer.
    public static final String LOADING_PHASE_BUFFER_TIME_AFTER_FIRST_MEANINGFUL_PAINT = "LoadingPhaseBufferTimeAfterFirstMeaningfulPaint";

    // Makes network loading tasks unfreezable so that they can be processed while
    // the page is frozen.
    public static final String LOADING_TASKS_UNFREEZABLE = "LoadingTasksUnfreezable";


    public static final String LOG_UNEXPECTED_IPC_POSTED_TO_BACK_FORWARD_CACHED_DOCUMENTS = "LogUnexpectedIPCPostedToBackForwardCachedDocuments";

    // Enables the use of GpuMemoryBuffer images for low latency 2d canvas.
    // TODO(khushalsagar): Enable this if we're using SurfaceControl and GMBs allow
    // us to overlay these resources.
    public static final String LOW_LATENCY_CANVAS2D_IMAGE_CHROMIUM = "LowLatencyCanvas2dImageChromium";


    public static final String LOW_PRIORITY_ASYNC_SCRIPT_EXECUTION = "LowPriorityAsyncScriptExecution";


    public static final String LOW_PRIORITY_SCRIPT_LOADING = "LowPriorityScriptLoading";


    public static final String MAIN_THREAD_HIGH_PRIORITY_IMAGE_LOADING = "MainThreadHighPriorityImageLoading";

    // If enabled, the setTimeout(..., 0) will clamp to 4ms after a custom `nesting`
    // level.
    // Tracking bug: https://crbug.com/1108877.
    public static final String MAX_UNTHROTTLED_TIMEOUT_NESTING_LEVEL = "MaxUnthrottledTimeoutNestingLevel";


    public static final String MIXED_CONTENT_AUTOUPGRADE = "AutoupgradeMixedContent";


    public static final String MEMORY_CACHE_STRONG_REFERENCE_FILTER_IMAGES = "MemoryCacheStrongReferenceFilterImages";


    public static final String MEMORY_CACHE_STRONG_REFERENCE_FILTER_SCRIPTS = "MemoryCacheStrongReferenceFilterScripts";


    public static final String MEMORY_CACHE_STRONG_REFERENCE_FILTER_CROSS_ORIGIN_SCRIPTS = "MemoryCacheStrongReferenceFilterCrossOriginScripts";


    public static final String MEMORY_CACHE_STRONG_REFERENCE = "MemoryCacheStrongReference";


    public static final String MEMORY_CACHE_STRONG_REFERENCE_SINGLE_UNLOAD = "MemoryCacheStrongReferenceSingleUnload";

    // Used to control the collection of anchor element metrics (crbug.com/856683).
    // If kNavigationPredictor is enabled, then metrics of anchor elements
    // in the first viewport after the page load and the metrics of the clicked
    // anchor element will be extracted and recorded.
    public static final String NAVIGATION_PREDICTOR = "NavigationPredictor";


    public static final String NEW_BASE_URL_INHERITANCE_BEHAVIOR = "NewBaseUrlInheritanceBehavior";


    public static final String NO_FORCED_FRAME_UPDATES_FOR_WEB_TESTS = "NoForcedFrameUpdatesForWebTests";


    public static final String ORIGIN_AGENT_CLUSTER_DEFAULT_ENABLED = "OriginAgentClusterDefaultEnable";


    public static final String ORIGIN_AGENT_CLUSTER_DEFAULT_WARNING = "OriginAgentClusterDefaultWarning";


    public static final String ORIGIN_TRIAL_STATE_HOST_APPLY_FEATURE_DIFF = "OriginTrialStateHostApplyFeatureDiff";

    // Enable defer commits to avoid flash of unstyled content, for same origin
    // navigation only.
    public static final String PAINT_HOLDING = "PaintHolding";

    // Enable defer commits to avoid flash of unstyled content, for all navigation.
    public static final String PAINT_HOLDING_CROSS_ORIGIN = "PaintHoldingCrossOrigin";


    public static final String PARKABLE_IMAGES_TO_DISK = "ParkableImagesToDisk";

    // Enables the use of the PaintCache for Path2D objects that are rasterized
    // out of process.  Has no effect when kCanvasOopRasterization is disabled.
    public static final String PATH2D_PAINT_CACHE = "Path2DPaintCache";


    public static final String PENDING_BEACON_API = "PendingBeaconAPI";

    // Enable browser-initiated dedicated worker script loading
    // (PlzDedicatedWorker). https://crbug.com/906991
    public static final String PLZ_DEDICATED_WORKER = "PlzDedicatedWorker";

    // https://crbug.com/1013389
    public static final String PORTALS_CROSS_ORIGIN = "PortalsCrossOrigin";


    public static final String PRECOMPILE_INLINE_SCRIPTS = "PrecompileInlineScripts";

    // Whether we should composite a PLSA (paint layer scrollable area) even if it
    // means losing lcd text.
    public static final String PREFER_COMPOSITING_TO_LCD_TEXT = "PreferCompositingToLCDText";


    public static final String PREFETCH_FONT_LOOKUP_TABLES = "PrefetchFontLookupTables";

    // Prefetch request properties are updated to be privacy-preserving. See
    // crbug.com/988956.
    public static final String PREFETCH_PRIVACY_CHANGES = "PrefetchPrivacyChanges";


    public static final String PRELOADING_HEURISTICS_ML_MODEL = "PreloadingHeuristicsMLModel";


    public static final String PRERENDER2_IN_NEW_TAB = "Prerender2InNewTab";


    public static final String PRERENDER2_MAIN_FRAME_NAVIGATION = "Prerender2MainFrameNavigation";


    public static final String PRERENDER2_MEMORY_CONTROLS = "Prerender2MemoryControls";

    // Enable limiting previews loading hints to specific resource types.
    public static final String PREVIEWS_RESOURCE_LOADING_HINTS_SPECIFIC_RESOURCE_TYPES = "PreviewsResourceLoadingHintsSpecificResourceTypes";


    public static final String PREWARM_DEFAULT_FONT_FAMILIES = "PrewarmDefaultFontFamilies";


    public static final String PRIVACY_SANDBOX_ADS_AP_IS = "PrivacySandboxAdsAPIs";

    // Enables the Private Aggregation API. Note that this API also requires the
    // `kPrivacySandboxAggregationService` to be enabled to successfully send
    // reports.
    public static final String PRIVATE_AGGREGATION_API = "PrivateAggregationApi";


    public static final String PROCESS_HTML_DATA_IMMEDIATELY = "ProcessHtmlDataImmediately";


    public static final String PRODUCE_COMPILE_HINTS2 = "ProduceCompileHints2";


    public static final String FORCE_PRODUCE_COMPILE_HINTS = "ForceProduceCompileHints";


    public static final String CONSUME_COMPILE_HINTS = "ConsumeCompileHints";


    public static final String QUEUE_BLOCKING_GESTURE_SCROLLS = "QueueBlockingGestureScrolls";


    public static final String QUOTE_EMPTY_SEC_CH_UA_STRING_HEADERS_CONSISTENTLY = "QuoteEmptySecChUaStringHeadersConsistently";

    // Determines if the SDP attrbute extmap-allow-mixed should be offered by
    // default or not. The default value can be overridden by passing
    // {offerExtmapAllowMixed:false} as an argument to the RTCPeerConnection
    // constructor.
    public static final String RTC_OFFER_EXTMAP_ALLOW_MIXED = "RTCOfferExtmapAllowMixed";

    // Enables waiting for codec support status notification from GPU factory in RTC
    // codec factories.
    public static final String RTC_GPU_CODEC_SUPPORT_WAITER = "kRTCGpuCodecSupportWaiter";

    // Reduce the amount of information in the default 'referer' header for
    // cross-origin requests.
    public static final String REDUCED_REFERRER_GRANULARITY = "ReducedReferrerGranularity";

    // When enabled, Source Location blocking BFCache is captured
    // to send it to the browser.
    public static final String REGISTER_JS_SOURCE_LOCATION_BLOCKING_BF_CACHE = "RegisterJSSourceLocationBlockingBFCache";


    public static final String REMOTE_RESOURCE_CACHE = "RemoteResourceCache";


    public static final String REMOVE_AUTHROIZATION_ON_CROSS_ORIGIN_REDIRECT = "RemoveAutorizationOnCrossOriginRedirect";


    public static final String RENDER_BLOCKING_FONTS = "RenderBlockingFonts";


    public static final String REPORT_VISIBLE_LINE_BOUNDS = "ReportVisibleLineBounds";


    public static final String RESAMPLING_INPUT_EVENTS = "ResamplingInputEvents";


    public static final String RESAMPLING_SCROLL_EVENTS = "ResamplingScrollEvents";


    public static final String RETRIGGER_PRELOADING_ON_BF_CACHE_RESTORATION = "RetriggerPreloadingOnBFCacheRestoration";


    public static final String RUN_TEXT_INPUT_UPDATE_POST_LIFECYCLE = "RunTextInputUpdatePostLifecycle";

    // https://html.spec.whatwg.org/multipage/system-state.html#safelisted-scheme
    public static final String SAFELIST_FTP_TO_REGISTER_PROTOCOL_HANDLER = "SafelistFTPToRegisterProtocolHandler";


    public static final String SSV_TRAILER_ENFORCE_EXPOSURE_ASSERTION = "SSVTrailerEnforceExposureAssertion";


    public static final String SSV_TRAILER_WRITE_EXPOSURE_ASSERTION = "SSVTrailerWriteExposureAssertion";


    public static final String SSV_TRAILER_WRITE_NEW_VERSION = "SSVTrailerWriteNewVersion";

    // A feature to enable using the smallest image specified within image srcset
    // for users with Save Data enabled.
    public static final String SAVE_DATA_IMG_SRCSET = "SaveDataImgSrcset";

    // Scopes the memory cache to a fetcher i.e. document/frame. Any resource cached
    // in the blink cache will only be reused if the most recent fetcher that
    // fetched it was the same as the current document.
    public static final String SCOPE_MEMORY_CACHE_PER_CONTEXT = "ScopeMemoryCachePerContext";


    public static final String PAUSE_PAGES_PER_BROWSING_CONTEXT_GROUP = "PausePagesPerBrowsingContextGroup";

    // Controls script streaming.
    public static final String SCRIPT_STREAMING = "ScriptStreaming";


    public static final String SELECTIVE_IN_ORDER_SCRIPT = "SelectiveInOrderScript";


    public static final String SELECTIVE_IN_ORDER_SCRIPT_TARGET = "SelectiveInOrderScriptTarget";

    // When enabled, the SubresourceFilter receives calls from the ResourceLoader
    // to perform additional checks against any aliases found from DNS CNAME records
    // for the requested URL.
    public static final String SEND_CNAME_ALIASES_TO_SUBRESOURCE_FILTER_FROM_RENDERER = "SendCnameAliasesToSubresourceFilterFromRenderer";


    public static final String SERIALIZE_ACCESSIBILITY_POST_LIFECYCLE = "SerializeAccessibilityPostLifecycle";

    // Experiment of the delay from navigation to starting an update of a service
    // worker's script.
    public static final String SERVICE_WORKER_UPDATE_DELAY = "ServiceWorkerUpdateDelay";

    // When enabled, beacons (and friends) have ResourceLoadPriority::kLow,
    // not ResourceLoadPriority::kVeryLow.
    public static final String SET_LOW_PRIORITY_FOR_BEACON = "SetLowPriorityForBeacon";

    // If enabled, the setTimeout(..., 0) will not clamp to 1ms.
    // Tracking bug: https://crbug.com/402694.
    public static final String SET_TIMEOUT_WITHOUT_CLAMP = "SetTimeoutWithoutClamp";

    // Enable the shared storage API. Note that enabling this feature does not
    // automatically expose this API to the web, it only allows the element to be
    // enabled by the runtime enabled feature, for origin trials.
    // https://github.com/pythagoraskitty/shared-storage/blob/main/README.md
    public static final String SHARED_STORAGE_API = "SharedStorageAPI";


    public static final String SHARED_STORAGE_SELECT_URL_LIMIT = "SharedStorageSelectURLLimit";


    public static final String SHARED_STORAGE_APIM118 = "SharedStorageAPIM118";


    public static final String SIMULATE_CLICK_ON_AX_FOCUS = "SimulateClickOnAXFocus";

    // Allow streaming small (<30kB) scripts.
    public static final String SMALL_SCRIPT_STREAMING = "SmallScriptStreaming";


    public static final String SPECULATION_RULES_HEADER_ENABLE_THIRD_PARTY_ORIGIN_TRIAL = "SpeculationRulesHeaderEnableThirdPartyOriginTrial";


    public static final String SPECULATION_RULES_PREFETCH_FUTURE = "SpeculationRulesPrefetchFuture";

    // Enable service worker warming-up feature. (https://crbug.com/1431792)
    public static final String SPECULATIVE_SERVICE_WORKER_WARM_UP = "SpeculativeServiceWorkerWarmUp";


    public static final String SPLIT_USER_MEDIA_QUEUES = "SplitUserMediaQueues";


    public static final String START_MEDIA_STREAM_CAPTURE_INDICATOR_IN_BROWSER = "StartMediaStreamCaptureIndicatorInBrowser";

    // Freeze scheduler task queues in background after allowed grace time.
    // "stop" is a legacy name.
    public static final String STOP_IN_BACKGROUND = "stop-in-background";


    public static final String STYLUS_POINTER_ADJUSTMENT = "StylusPointerAdjustment";


    public static final String STYLUS_RICH_GESTURES = "StylusRichGestures";

    // TODO(mahesh.ma): Enable for supported Android versions once feature is ready.
    public static final String STYLUS_WRITING_TO_INPUT = "StylusWritingToInput";


    public static final String SYSTEM_COLOR_CHOOSER = "SystemColorChooser";


    public static final String TEXT_CODEC_CJK_ENABLED = "TextCodecCJKEnabled";


    public static final String GB18030_2022_ENABLED = "Gb18030_2022Enabled";


    public static final String THREADED_BODY_LOADER = "ThreadedBodyLoader";


    public static final String THREADED_PRELOAD_SCANNER = "ThreadedPreloadScanner";


    public static final String THROTTLE_DISPLAY_NONE_AND_VISIBILITY_HIDDEN_CROSS_ORIGIN_IFRAMES = "ThrottleDisplayNoneAndVisibilityHiddenCrossOriginIframes";

    // Throttles Javascript timer wake ups on foreground pages.
    public static final String THROTTLE_FOREGROUND_TIMERS = "ThrottleForegroundTimers";

    // Enable throttling of fetch() requests from service workers in the
    // installing state.  The limit of 3 was chosen to match the limit
    // in background main frames.  In addition, trials showed that this
    // did not cause excessive timeouts and resulted in a net improvement
    // in successful install rate on some platforms.
    public static final String THROTTLE_INSTALLING_SERVICE_WORKER = "ThrottleInstallingServiceWorker";


    public static final String TIMED_HTML_PARSER_BUDGET = "TimedHTMLParserBudget";

    // Changes behavior of User-Agent Client Hints to send blank headers when the
    // User-Agent string is overridden, instead of disabling the headers altogether.
    public static final String UACH_OVERRIDE_BLANK = "UACHOverrideBlank";


    public static final String URL_SET_PORT_CHECK_OVERFLOW = "URLSetPortCheckOverflow";


    public static final String USE_BLINK_SCHEDULER_TASK_RUNNER_WITH_CUSTOM_DELETER = "UseBlinkSchedulerTaskRunnerWithCustomDeleter";


    public static final String ENABLE_FILE_BACKED_BLOB_FACTORY = "EnableFileBackedBlobFactory";

    // Whether to use 'TexImage2D' instead of 'TexStorage2DEXT' when creating a
    // staging texture for |DrawingBuffer|. This is a killswitch; remove when
    // launched.
    public static final String USE_IMAGE_INSTEAD_OF_STORAGE_FOR_STAGING_BUFFER = "UseImageInsteadOfStorageForStagingBuffer";

    // Uses page viewport instead of frame viewport in the Largest Contentful Paint
    // heuristic where images occupying the full viewport are ignored.
    public static final String USE_PAGE_VIEWPORT_IN_LCP = "UsePageViewportInLCP";

    // Enabling this will cause parkable strings to use Snappy for compression iff
    // kCompressParkableStrings is enabled.
    public static final String USE_SNAPPY_FOR_PARKABLE_STRINGS = "UseSnappyForParkableStrings";


    public static final String USE_THREAD_POOL_FOR_MEDIA_STREAM_VIDEO_TASK_RUNNER = "UseThreadPoolForMediaStreamVideoTaskRunner";

    // Enables user level memory pressure signal generation on Android.
    public static final String USER_LEVEL_MEMORY_PRESSURE_SIGNAL = "UserLevelMemoryPressureSignal";


    public static final String V_SYNC_DECODING = "VSyncDecoding";

    // Enable borderless mode for desktop PWAs. go/borderless-mode
    public static final String WEB_APP_BORDERLESS = "WebAppBorderless";

    // Controls scope extensions feature in web apps. Controls parsing of
    // "scope_extensions" field in web app manifests. See explainer for more
    // information:
    // https://github.com/WICG/manifest-incubations/blob/gh-pages/scope_extensions-explainer.md
    public static final String WEB_APP_ENABLE_SCOPE_EXTENSIONS = "WebAppEnableScopeExtensions";

    // Controls URL handling feature in web apps. Controls parsing of "url_handlers"
    // field in web app manifests. See explainer for more information:
    // https://github.com/WICG/pwa-url-handler/blob/main/explainer.md
    public static final String WEB_APP_ENABLE_URL_HANDLERS = "WebAppEnableUrlHandlers";

    // Controls parsing of the "lock_screen" dictionary field and its "start_url"
    // entry in web app manifests.  See explainer for more information:
    // https://github.com/WICG/lock-screen/
    // Note: the lock screen API and OS integration is separately controlled by
    // the content feature `kWebLockScreenApi`.
    public static final String WEB_APP_MANIFEST_LOCK_SCREEN = "WebAppManifestLockScreen";

    // A server-side switch for the output device (sink) selection in Web Audio API.
    // This enables the selection via the AudioContext constructor and also via
    // AudioContext.setSinkId() method.
    public static final String WEB_AUDIO_SINK_SELECTION = "kWebAudioSinkSelection";

    // Enabling this flag bypasses additional buffering when using the Web Audio
    // API, which may reduce audio output latency but may also increase the
    // probability of an audio glitch.
    public static final String WEB_AUDIO_BYPASS_OUTPUT_BUFFERING = "WebAudioBypassOutputBuffering";

    // The feature is disabled on Android for WebView API issue discussed at
    // https://crbug.com/942440.
    public static final String WEB_FONTS_CACHE_AWARE_TIMEOUT_ADAPTION = "WebFontsCacheAwareTimeoutAdaption";

    // Controls whether the implementation of the performance.measureMemory
    // web API uses PerformanceManager or not.
    public static final String WEB_MEASURE_MEMORY_VIA_PERFORMANCE_MANAGER = "WebMeasureMemoryViaPerformanceManager";


    public static final String WEB_RTC_COMBINED_NETWORK_AND_WORKER_THREAD = "WebRtcCombinedNetworkAndWorkerThread";

    // Run-time feature for the |rtc_use_h264| encoder/decoder.
    public static final String WEB_RTC_H264_WITH_OPEN_H264F_FMPEG = "WebRTC-H264WithOpenH264FFmpeg";

    // Exposes non-standard stats in the WebRTC getStats() API.
    public static final String WEB_RTC_EXPOSE_NON_STANDARD_STATS = "WebRtc-ExposeNonStandardStats";

    // Causes WebRTC to replace host ICE candidate IP addresses with generated
    // names ending in ".local" and resolve them using mDNS.
    // http://crbug.com/878465
    public static final String WEB_RTC_HIDE_LOCAL_IPS_WITH_MDNS = "WebRtcHideLocalIpsWithMdns";

    // Causes WebRTC to not set the color space of video frames on the receive side
    // in case it's unspecified. Otherwise we will guess that the color space is
    // BT709. http://crbug.com/1129243
    public static final String WEB_RTC_IGNORE_UNSPECIFIED_COLOR_SPACE = "WebRtcIgnoreUnspecifiedColorSpace";


    public static final String WEB_RTC_INITIALIZE_ENCODER_ON_FIRST_FRAME = "WebRtcInitializeEncoderOnFirstFrame";


    public static final String WEB_RTC_METRONOME = "WebRtcMetronome";

    // Enables negotiation of experimental multiplex codec in SDP.
    public static final String WEB_RTC_MULTIPLEX_CODEC = "WebRTC-MultiplexCodec";


    public static final String WEB_RTC_SEND_PACKET_BATCH = "WebRtcSendPacketBatch";


    public static final String WEB_RTC_THREADS_USE_RESOURCE_EFFICIENT_TYPE = "WebRtcThreadsUseResourceEfficientType";

    // Instructs WebRTC to honor the Min/Max Video Encode Accelerator dimensions.
    public static final String WEB_RTC_USE_MIN_MAX_VEA_DIMENSIONS = "WebRtcUseMinMaxVEADimensions";

    // Allow access to WebSQL APIs.
    public static final String WEB_SQL_ACCESS = "kWebSQLAccess";

    // Enables small accelerated canvases for webview (crbug.com/1004304)
    public static final String WEBVIEW_ACCELERATE_SMALL_CANVASES = "WebviewAccelerateSmallCanvases";

    // Do not instantiate this class.
    private BlinkFeatures() {}
}
