// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui.accessibility;

/**
* Contains features that are specific to accessibility.
*/
public final class AccessibilityFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../ui/accessibility/accessibility_features.cc
    // Into
    //     ../../ui/accessibility/android/java_templates/AccessibilityFeatures.java.tmpl

    // Enable recognizing "aria-virtualcontent" as a valid aria property.
    public static final String ENABLE_ACCESSIBILITY_ARIA_VIRTUAL_CONTENT = "AccessibilityAriaVirtualContent";

    // Enable exposing the <html> element to the browser process AXTree
    // (as an ignored node).
    public static final String ENABLE_ACCESSIBILITY_EXPOSE_HTML_ELEMENT = "AccessibilityExposeHTMLElement";

    // Enable exposing ignored nodes from Blink to the browser process AXTree.
    // This will allow us to simplify logic by eliminating the distiction between
    // "ignored and included in the tree" from "ignored and not included in the
    // tree".
    public static final String ENABLE_ACCESSIBILITY_EXPOSE_IGNORED_NODES = "AccessibilityExposeIgnoredNodes";

    // Enable language detection to determine language used in page text, exposed
    // on the browser process AXTree.
    public static final String ENABLE_ACCESSIBILITY_LANGUAGE_DETECTION = "AccessibilityLanguageDetection";

    // Serializes accessibility information from the Views tree and deserializes it
    // into an AXTree in the browser process.
    public static final String ENABLE_ACCESSIBILITY_TREE_FOR_VIEWS = "AccessibilityTreeForViews";


    public static final String ENABLE_ACCESSIBILITY_RESTRICTIVE_IA2AX_MODES = "AccessibilityRestrictiveIA2AXModes";


    public static final String ACCESSIBILITY_FOCUS_HIGHLIGHT = "AccessibilityFocusHighlight";


    public static final String AUTO_DISABLE_ACCESSIBILITY = "AutoDisableAccessibility";


    public static final String TEXT_BASED_AUDIO_DESCRIPTION = "TextBasedAudioDescription";


    public static final String I_CHROME_ACCESSIBLE = "IChromeAccessible";


    public static final String SELECTIVE_UIA_ENABLEMENT = "SelectiveUIAEnablement";


    public static final String UIA_PROVIDER = "UiaProvider";


    public static final String EXPERIMENTAL_ACCESSIBILITY_DICTATION_CONTEXT_CHECKING = "ExperimentalAccessibilityDictationContextChecking";


    public static final String EXPERIMENTAL_ACCESSIBILITY_GOOGLE_TTS_LANGUAGE_PACKS = "ExperimentalAccessibilityGoogleTtsLanguagePacks";


    public static final String EXPERIMENTAL_ACCESSIBILITY_GOOGLE_TTS_HIGH_QUALITY_VOICES = "ExperimentalAccessibilityGoogleTtsHighQualityVoices";


    public static final String ACCESSIBILITY_DICTATION_KEYBOARD_IMPROVEMENTS = "AccessibilityDictationKeyboardImprovements";


    public static final String ACCESSIBILITY_SELECT_TO_SPEAK_HOVER_TEXT_IMPROVEMENTS = "AccessibilitySelectToSpeakHoverTextImprovements";


    public static final String ACCESSIBILITY_ACCELERATOR_NOTIFICATIONS_TIMEOUT = "AccessibilityAcceleratorNotificationsTimeout";


    public static final String ACCESSIBILITY_GAME_FACE_INTEGRATION = "AccessibilityGameFaceIntegration";


    public static final String BACKLIGHT_OCR = "BacklightOcr";


    public static final String AUGMENT_EXISTING_IMAGE_LABELS = "AugmentExistingImageLabels";


    public static final String USE_AX_POSITION_FOR_DOCUMENT_MARKERS = "UseAXPositionForDocumentMarkers";


    public static final String ENABLE_ARIA_ELEMENT_REFLECTION = "EnableAriaElementReflection";


    public static final String ABLATE_SEND_PENDING_ACCESSIBILITY_EVENTS = "AblateSendPendingAccessibilityEvents";


    public static final String ACCESSIBILITY_PERFORMANCE_FILTERING = "AccessibilityPerformanceFiltering";


    public static final String READ_ANYTHING = "ReadAnything";


    public static final String READ_ANYTHING_WITH_SCREEN2X = "ReadAnythingWithScreen2x";

    // This feature can be used as an emergency kill switch to disable Screen AI
    // main content extraction service in case of security or other issues.
    // Please talk to components/services/screen_ai/OWNERS if any changes to this
    // feature or its functionality is needed.
    public static final String EMERGENCY_DISABLE_SCREEN_AI_MAIN_CONTENT_EXTRACTION = "EmergencyDisableScreenAIMainContentExtraction";

    // This feature is only used for generating training data for Screen2x and should
    // never be used in any other circumstance, and should not be enabled by default.
    public static final String DATA_COLLECTION_MODE_FOR_SCREEN2X = "DataCollectionModeForScreen2x";

    // This feature is only for debug purposes and for security/privacy reasons,
    // should be never enabled by default .
    public static final String SCREEN_AI_DEBUG_MODE = "ScreenAIDebugMode";

    // This feature can be used as an emergency kill switch to disable Screen AI
    // OCR service in case of security or other issues.
    // Please talk to components/services/screen_ai/OWNERS if any changes to this
    // feature or its functionality is needed.
    public static final String EMERGENCY_DISABLE_SCREEN_AIOCR = "EmergencyDisableScreenAIOCR";


    public static final String READ_ANYTHING_WEB_UI_TOOLBAR = "ReadAnythingWebUIToolbar";


    public static final String READ_ANYTHING_READ_ALOUD = "ReadAnythingReadAloud";


    public static final String PDF_OCR = "PdfOcr";


    public static final String LAYOUT_EXTRACTION = "LayoutExtraction";


    public static final String ACCESSIBILITY_SERVICE = "AccessibilityService";


    public static final String ACCESSIBILITY_REMOTE_UI_APP = "AccessibilityRemoteUIApp";

 // Prevents instantiation.
 private AccessibilityFeatures() {}
}
