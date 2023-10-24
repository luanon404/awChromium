// Copyright 2021 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.autofill;

/**
 * Contains features that are specific to the autofill component.
 */
public final class AutofillFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../components/autofill/core/common/autofill_features.cc,
    //     ../../components/autofill/core/common/autofill_payments_features.cc
    // Into
    //     ../../components/autofill/android/java_templates/AutofillFeatures.java.tmpl

    // Controls whether to flatten and fill cross-iframe forms on iOS.
    // TODO(crbug.com/1441921) Remove once launched.
    public static final String AUTOFILL_ACROSS_IFRAMES_IOS = "AutofillAcrossIframesIos";

    // When enabled, address data will be verified and autocorrected in the
    // save/update prompt before saving an address profile. Relevant only if the
    // AutofillAddressProfileSavePrompt feature is enabled.
    public static final String AUTOFILL_ADDRESS_PROFILE_SAVE_PROMPT_ADDRESS_VERIFICATION_SUPPORT = "AutofillAddressProfileSavePromptAddressVerificationSupport";

    // Use the heuristic parser to detect unfillable numeric types in field labels
    // and grant the heuristic precedence over non-override server predictions.
    public static final String AUTOFILL_GIVE_PRECEDENCE_TO_NUMERIC_QUANTITIES = "AutofillGivePrecedenceToNumericQuantities";

    // When enabled, creating new kAccount profiles becomes possible for eligible
    // users. Moreover, users are prompted to migrate existing kLocalOrSyncable
    // profiles to the kAccount storage.
    // TODO(crbug.com/1423319): Remove once launched.
    public static final String AUTOFILL_ACCOUNT_PROFILE_STORAGE = "AutofillAccountProfileStorage";

    // TODO(crbug.com/1135188): Remove this feature flag after the explicit save
    // prompts for address profiles is complete.
    // When enabled, address profile save problem will contain a dropdown for
    // assigning a nickname to the address profile. Relevant only if the
    // AutofillAddressProfileSavePrompt feature is enabled.
    public static final String AUTOFILL_ADDRESS_PROFILE_SAVE_PROMPT_NICKNAME_SUPPORT = "AutofillAddressProfileSavePromptNicknameSupport";

    // By default, AutofillAgent and, if |kAutofillProbableFormSubmissionInBrowser|
    // is enabled, also ContentAutofillDriver omit duplicate form submissions, even
    // though the form's data may have changed substantially. If enabled, the
    // below feature allows duplicate form submissions.
    // TODO(crbug/1117451): Remove once the form-submission experiment is over.
    public static final String AUTOFILL_ALLOW_DUPLICATE_FORM_SUBMISSIONS = "AutofillAllowDuplicateFormSubmissions";

    // If enabled, the two most recent address forms and the most recent credit card
    // forms, which were submitted on the same origin, are associated with each
    // other. The association only happens if at most `kAutofillAssociateFormsTTL`
    // time passes between all submissions.
    public static final String AUTOFILL_ASSOCIATE_FORMS = "AutofillAssociateForms";

    // If enabled, the country calling code for nationally formatted phone numbers
    // is inferred from the profile's country, if available.
    // TODO(crbug.com/1311937): Cleanup when launched.
    public static final String AUTOFILL_INFER_COUNTRY_CALLING_CODE = "AutofillInferCountryCallingCode";

    // If enabled, label inference considers strings entirely made up of  '(', ')'
    // and '-' as valid labels.
    // TODO(crbug.com/1311937): Cleanup when launched.
    public static final String AUTOFILL_CONSIDER_PHONE_NUMBER_SEPARATORS_VALID_LABELS = "AutofillConsiderPhoneNumberSeparatorsValidLabels";

    // If enabled, contenteditables are extracted and filled.
    // TODO(crbug.com/1490372): Cleanup when launched.
    public static final String AUTOFILL_CONTENT_EDITABLES = "AutofillContentEditables";

    // Crowdsourcing already prefers PHONE_HOME_CITY_AND_NUMBER over
    // PHONE_HOME_WHOLE_NUMBER. With this feature, local heuristics do the same.
    public static final String AUTOFILL_DEFAULT_TO_CITY_AND_NUMBER = "AutofillDefaultToCityAndNumber";

    // FormStructure::RetrieveFromCache used to preserve an AutofillField's
    // is_autofilled from the cache of previously parsed forms. This makes little
    // sense because the renderer sends us the autofill state and has the most
    // recent information. Dropping the old behavior should not make any difference
    // but to be sure, this is gated by a finch experiment.
    // TODO(crbug.com/1373362) Cleanup when launched.
    public static final String AUTOFILL_DONT_PRESERVE_AUTOFILL_STATE = "AutofillDontPreserveAutofillState";

    // If enabled, checking whether a form has disappeared after an Ajax response is
    // delayed because subsequent Ajax responses may restore the form. If disabled,
    // the check happens right after a successful Ajax response.
    public static final String AUTOFILL_DEFER_SUBMISSION_CLASSIFICATION_AFTER_AJAX = "AutofillDeferSubmissionClassificationAfterAjax";

    // If enabled, server/heuristic predictions take precedence over an unrecognized
    // autocomplete attribute. Suggestions are suppressed for such fields and they
    // won't be considered for filling or importing. The fields do however affect
    // rationalization and sectioning, and non-(key and quality) metrics.
    // When `kAutofillFillAndImportFromMoreFields` is enabled, fields with
    // unrecognized autocomplete attribute are considered for import.
    // TODO(crbug.com/1446318): Remove the feature when the experiment is completed.
    public static final String AUTOFILL_PREDICTIONS_FOR_AUTOCOMPLETE_UNRECOGNIZED = "AutofillPredictionsForAutocompleteUnrecognized";

    // When enabled, an entry is added to the context menu of ac=unrecognized fields
    // which allows triggering Autofill suggestions. Selecting such a suggestion
    // fills all address fields in the field's section, independently of the
    // autocomplete attribute.
    // TODO(crbug.com/1446318): Remove when launched.
    public static final String AUTOFILL_FALLBACK_FOR_AUTOCOMPLETE_UNRECOGNIZED = "AutofillFallbackForAutocompleteUnrecognized";

    // Kill switch for Autofill filling.
    public static final String AUTOFILL_DISABLE_FILLING = "AutofillDisableFilling";

    // Kill switch for Autofill address import.
    public static final String AUTOFILL_DISABLE_ADDRESS_IMPORT = "AutofillDisableAddressImport";

    // Kill switch for computing heuristics other than the active ones
    // (GetActivePatternSource()).
    public static final String AUTOFILL_DISABLE_SHADOW_HEURISTICS = "AutofillDisableShadowHeuristics";

    // When enabled, autofill will use the new ranking algorithm for address profile
    // autofill suggestions.
    public static final String AUTOFILL_ENABLE_RANKING_FORMULA_ADDRESS_PROFILES = "AutofillEnableRankingFormulaAddressProfiles";

    // When enabled, autofill will use the new ranking algorithm for credit card
    // autofill suggestions.
    public static final String AUTOFILL_ENABLE_RANKING_FORMULA_CREDIT_CARDS = "AutofillEnableRankingFormulaCreditCards";

    // When enabled, autofill will fill <selectlist> elements.
    // TODO(crbug.com/1427153) Remove once autofilling <selectlist> is launched.
    public static final String AUTOFILL_ENABLE_SELECT_LIST = "AutofillEnableSelectList";

    // Controls if Chrome support filling and importing between streets.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_BETWEEN_STREETS = "AutofillEnableSupportForBetweenStreets";

    // Controls if Chrome supports filling and importing administrative area
    // level 2. A sub-division of a state, e.g. a Municipio in Brazil or Mexico.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_ADMIN_LEVEL2 = "AutofillEnableSupportForAdminLevel2";

    // Controls if Chrome support filling and importing address overflow fields.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_ADDRESS_OVERFLOW = "AutofillEnableSupportForAddressOverflow";

    // Controls if Chrome support filling and importing address overflow and
    // landmark fields.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_ADDRESS_OVERFLOW_AND_LANDMARK = "AutofillEnableSupportForAddressOverflowAndLandmark";

    // Controls if Chrome support filling and importing address overflow and
    // landmark fields.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_BETWEEN_STREETS_OR_LANDMARK = "AutofillEnableSupportForBetweenStreetsOrLandmark";

    // Controls if Chrome support filling and importing landmarks.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_LANDMARK = "AutofillEnableSupportForLandmark";

    // Controls if the heuristic field parsing utilizes shared labels.
    // TODO(crbug.com/1165780): Remove once shared labels are launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_PARSING_WITH_SHARED_LABELS = "AutofillEnableSupportForParsingWithSharedLabels";

    // Controls if heuristic field parsing should be performed on email-only forms.
    // TODO(crbug.com/1493145): Remove when/if launched.
    public static final String AUTOFILL_ENABLE_EMAIL_HEURISTIC_ONLY_ADDRESS_FORMS = "AutofillEnableEmailHeuristicOnlyAddressForms";

    // Controls if Chrome support filling and importing apartment numbers.
    // TODO(crbug.com/1153715): Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_APARTMENT_NUMBERS = "AutofillEnableSupportForApartmentNumbers";

    // Enables parsing for birthdate fields. Filling is not supported and parsing
    // is meant to prevent false positive credit card expiration dates.
    // TODO(crbug.com/1306654): Remove once launched.
    public static final String AUTOFILL_ENABLE_BIRTHDATE_PARSING = "AutofillEnableBirthdateParsing";

    // Controls if Autofill parses ADDRESS_HOME_DEPENDENT_LOCALITY.
    // TODO(crbug.com/1157405): Remove once launched.
    public static final String AUTOFILL_ENABLE_DEPENDENT_LOCALITY_PARSING = "AutofillEnableDependentLocalityParsing";

    // Controls if Autofill emits form issues to devtools.
    public static final String AUTOFILL_ENABLE_DEVTOOLS_ISSUES = "AutofillEnableDevtoolsIssues";

    // Enables a couple of improvements to credit card expiration date handling:
    // - The autocomplete attribute values are rationalized with format strings
    //   like MM/YY from placeholders and labels in mind.
    // - more fill follow.
    // TODO(crbug.com/1441057): Remove once launched.
    public static final String AUTOFILL_ENABLE_EXPIRATION_DATE_IMPROVEMENTS = "AutofillEnableExpirationDateImprovements";

    // Controls whether to save the first number in a form with multiple phone
    // numbers instead of aborting the import.
    // TODO(crbug.com/1167484) Remove once launched.
    public static final String AUTOFILL_ENABLE_IMPORT_WHEN_MULTIPLE_PHONE_NUMBERS = "AutofillEnableImportWhenMultiplePhoneNumbers";

    // When enabled, phone number local heuristics match empty labels when looking
    // for composite phone number inputs. E.g. Phone number <input><input>.
    public static final String AUTOFILL_ENABLE_PARSING_EMPTY_PHONE_NUMBER_LABELS = "AutofillEnableParsingEmptyPhoneNumberLabels";

    // When enabled, the precedence is given to the field label over the name when
    // they match different types. Applied only for parsing of address forms in
    // Turkish.
    // TODO(crbug.com/1156315): Remove once launched.
    public static final String AUTOFILL_ENABLE_LABEL_PRECEDENCE_FOR_TURKISH_ADDRESSES = "AutofillEnableLabelPrecedenceForTurkishAddresses";

    // Controls whether honorific prefix is shown and editable in Autofill Settings
    // on Android, iOS and Desktop.
    // TODO(crbug.com/1141460): Remove once launched.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_HONORIFIC_PREFIXES = "AutofillEnableSupportForHonorificPrefixes";

    // Some countries like BR and MX have address forms with only a zip code.
    // If this feature is enabled, those fields may be classified as zip code fields
    // for users who are located in BR/MX, even though our typical policy is to
    // disable local heuristics for forms with <3 fields.
    public static final String AUTOFILL_ENABLE_ZIP_ONLY_ADDRESS_FORMS = "AutofillEnableZipOnlyAddressForms";

    // If enabled, trunk prefix-related phone number types are added to the
    // supported and matching types of |PhoneNumber|. Local heuristics for these
    // types are enabled as well.
    public static final String AUTOFILL_ENABLE_SUPPORT_FOR_PHONE_NUMBER_TRUNK_TYPES = "AutofillEnableSupportForPhoneNumberTrunkTypes";

    // Controls whether or not all datalist shall be extracted into FormFieldData.
    // This feature is enabled in both WebView and WebLayer where all datalists
    // instead of only the focused one shall be extracted and sent to Android
    // autofill service when the autofill session created.
    public static final String AUTOFILL_EXTRACT_ALL_DATALISTS = "AutofillExtractAllDatalists";

    // Enables support to submit feedback on Autofill. Used only in Desktop.
    public static final String AUTOFILL_FEEDBACK = "AutofillFeedback";

    // Makes AutofillProfile::IsSubsetOfForFieldSet stop ignoring street address
    // types during comparison, and instead compares them using address rewriter
    // normalization.
    public static final String AUTOFILL_USE_ADDRESS_REWRITER_IN_PROFILE_SUBSET_COMPARISON = "AutofillUseAddressRewriterInProfileSubsetComparison";

    // Enables using the newer i18n address model, overriding the legacy one.
    // This includes:
    // - Using newer i18n address format strings.
    public static final String AUTOFILL_USE_I18N_ADDRESS_MODEL = "AutofillUseI18nAddressModel";

    // Changes Autofill Clear Form into Undo Autofill.
    public static final String AUTOFILL_UNDO = "AutofillUndo";

    // Makes is_autofilled = true cached only after filling and not previewing.
    public static final String AUTOFILL_ONLY_CACHE_IS_AUTOFILLED_ON_FILL = "AutofillOnlyCacheIsAutofilledOnFill";

    // Enables converging towards the longer or shorter street address in profile
    // merging.
    public static final String AUTOFILL_CONVERGE_TO_EXTREME_LENGTH_STREET_ADDRESS = "AutofillConvergeToExtremeLengthStreetAddress";


    public static final String AUTOFILL_STREET_NAME_OR_HOUSE_NUMBER_PRECEDENCE_OVER_AUTOCOMPLETE = "AutofillStreetNameOrHouseNumberPrecedenceOverAutocomplete";

    // When enabled, HTML autocomplete values that do not map to any known type, but
    // look reasonable (e.g. contain "address") are simply ignored. Without the
    // feature, Autofill is disabled on such fields.
    public static final String AUTOFILL_IGNORE_UNMAPPABLE_AUTOCOMPLETE_VALUES = "AutofillIgnoreUnmappableAutocompleteValues";

    // When enabled, some local heuristic predictions will take precedence over the
    // autocomplete attribute and server predictions, when determining a field's
    // overall type.
    public static final String AUTOFILL_LOCAL_HEURISTICS_OVERRIDES = "AutofillLocalHeuristicsOverrides";

    // When enabled, only changed values are highlighted in preview mode.
    // TODO(crbug/1248585): Remove when launched.
    public static final String AUTOFILL_HIGHLIGHT_ONLY_CHANGED_VALUES_IN_PREVIEW_MODE = "AutofillHighlightOnlyChangedValuesInPreviewMode";

    // When enabled, Autofill will use new logic to strip both prefixes
    // and suffixes when setting FormStructure::parseable_name_
    public static final String AUTOFILL_LABEL_AFFIX_REMOVAL = "AutofillLabelAffixRemoval";

    // When enabled, all behaviours related to the on-device machine learning
    // model for field type predictions will be guarded.
    // TODO(crbug.com/1465926): Remove when launched.
    public static final String AUTOFILL_MODEL_PREDICTIONS = "AutofillModelPredictions";

    // See components/autofill/core/browser/server_prediction_overrides.h for more
    // examples and details on how to specify overrides.
    public static final String AUTOFILL_OVERRIDE_PREDICTIONS = "AutofillOverridePredictions";

    // If enabled, Autofill will first look at field labels and then at field
    // attributes when classifying address fields in Mexico.
    public static final String AUTOFILL_PREFER_LABELS_IN_SOME_COUNTRIES = "AutofillPreferLabelsInSomeCountries";

    // When enabled, Autofill would not override the field values that were either
    // filled by Autofill or on page load.
    // TODO(crbug/1275649): Remove once experiment is finished.
    public static final String AUTOFILL_PREVENT_OVERRIDING_PREFILLED_VALUES = "AutofillPreventOverridingPrefilledValues";

    // Enabling this feature is also a prerequisite for emitting shadow metrics.
    // TODO(crbug/1121990): Remove once launched.
    public static final String AUTOFILL_PARSING_PATTERN_PROVIDER = "AutofillParsingPatternProvider";

    // Enables detection of language from Translate.
    // TODO(crbug/1150895): Cleanup when launched.
    public static final String AUTOFILL_PAGE_LANGUAGE_DETECTION = "AutofillPageLanguageDetection";

    // If enabled, AutofillManager::ParseForm() isn't called synchronously.
    // Instead, all incoming events parse the form asynchronously and proceed
    // afterwards.
    // TODO(crbug.com/1309848) Remove once launched.
    public static final String AUTOFILL_PARSE_ASYNC = "AutofillParseAsync";

    // If enabled, local heuristics fall back to interpreting the fields' name as an
    // autocomplete type.
    // TODO(crbug.com/1345879) Remove once launched.
    public static final String AUTOFILL_PARSE_NAME_AS_AUTOCOMPLETE_TYPE = "AutofillParseNameAsAutocompleteType";

    // If enabled, the placeholder is not used as a fallback during label inference.
    // Instead, local heuristics treat it as a separate source in addition to the
    // label. The placeholder is matched against the same regex as the label.
    // Since placeholders are often used as example values, this should allow us to
    // extract a more appropriate label instead.
    // TODO(crbug.com/1317961): Remove once launched.
    public static final String AUTOFILL_ALWAYS_PARSE_PLACEHOLDERS = "AutofillAlwaysParsePlaceholders";

    // If the feature is enabled, paint checks over individual `PopupCellView`s (to
    // verify that a user's cursor has been outside the cell before accepting it)
    // are disabled.
    public static final String AUTOFILL_POPUP_DISABLE_PAINT_CHECKS = "AutofillPopupDisablePaintChecks";

    // Controls whether the autofill popup is hidden when the context menu is open.
    public static final String AUTOFILL_POPUP_DOES_NOT_OVERLAP_WITH_CONTEXT_MENU = "AutofillPopupDoesNotOverlapWithContextMenu";


    public static final String AUTOFILL_POPUP_MULTI_WINDOW_CURSOR_SUPPRESSION = "AutofillPopupMultiWindowCursorSuppression";

    // Controls whether the threshold for accepting Autofill popup suggestions
    // should take into account latency information of the user event.
    public static final String AUTOFILL_POPUP_USE_LATENCY_INFORMATION_FOR_ACCEPT_THRESHOLD = "AutofillPopupUseLatencyInformationForAcceptThreshold";

    // If the feature is enabled, FormTracker's probable-form-submission detection
    // is disabled and replaced with browser-side detection.
    // TODO(crbug/1117451): Remove once it works.
    public static final String AUTOFILL_PROBABLE_FORM_SUBMISSION_IN_BROWSER = "AutofillProbableFormSubmissionInBrowser";

    // Removes setting-inaccessible field types from existing profiles on startup.
    // TODO(crbug.com/1300548): Cleanup when launched.
    public static final String AUTOFILL_REMOVE_INACCESSIBLE_PROFILE_VALUES_ON_STARTUP = "AutofillRemoveInaccessibleProfileValuesOnStartup";

    // Requires a profile to have non-empty full name to import it from a form.
    // TODO(crbug.com/1413205): Cleanup when launched.
    public static final String AUTOFILL_REQUIRE_NAME_FOR_PROFILE_IMPORT = "AutofillRequireNameForProfileImport";

    // Controls non-default Autofill API predictions. See crbug.com/1331322.
    public static final String AUTOFILL_SERVER_BEHAVIORS = "AutofillServerBehaviors";

    // Controls whether Autofill may fill across origins.
    // In payment forms, the cardholder name field is often on the merchant's origin
    // while the credit card number and CVC are in iframes hosted by a payment
    // service provider. By enabling the policy-controlled feature "shared-autofill"
    // in those iframes, the merchant's website enable Autofill to fill the credit
    // card number and CVC fields from the cardholder name field, even though this
    // autofill operation crosses origins.
    // TODO(crbug.com/1304721): Enable this feature.
    public static final String AUTOFILL_SHARED_AUTOFILL = "AutofillSharedAutofill";

    // If this feature is enabled, the AddressFieldParser does NOT try to parse
    // address lines once it has found a street name and house number or other
    // combinations of fields that indicate that an address form uses structured
    // addresses. This should be the default in all countries with fully supported
    // structured addresses. However, if a country is not sufficiently modeled,
    // autofill may still do the right thing if it recognizes "Street name, house
    // number, address line 2" as a sequence.
    // TODO(crbug.com/1441904) Remove once launched.
    public static final String AUTOFILL_STRUCTURED_FIELDS_DISABLE_ADDRESS_LINES = "AutofillStructuredFieldsDisableAddressLines";

    // Controls whether to offer a delete button for Autocomplete entries in the
    // Autofill popup.
    public static final String AUTOFILL_SHOW_AUTOCOMPLETE_DELETE_BUTTON = "AutofillShowAutocompleteDeleteButton";

    // Controls whether granular filling will be available in the autofill popup.
    // TODO(crbug.com/1459990): Clean up when launched.
    public static final String AUTOFILL_GRANULAR_FILLING_AVAILABLE = "AutofillGranularFillingAvailable";

    // Controls whether testing forms using devtools will be available.
    // TODO(crbug.com/1459990): Clean up when launched.
    public static final String AUTOFILL_TEST_FORM_WITH_DEVTOOLS = "AutofillTestFormWithDevtools";

    // Allows silent profile updates even when the profile import requirements are
    // not met.
    public static final String AUTOFILL_SILENT_PROFILE_UPDATE_FOR_INSUFFICIENT_IMPORT = "AutofillSilentProfileUpdateForInsufficientImport";

    // When enabled, on form submit, observations for every used profile are
    // collected into the profile's `token_quality()`.
    // TODO(crbug.com/1453650): Remove when launched.
    public static final String AUTOFILL_TRACK_PROFILE_TOKEN_QUALITY = "AutofillTrackProfileTokenQuality";

    // Controls whether suggestions' labels use the improved label disambiguation
    // format.
    public static final String AUTOFILL_USE_IMPROVED_LABEL_DISAMBIGUATION = "AutofillUseImprovedLabelDisambiguation";

    // Controls whether to use the combined heuristic and the autocomplete section
    // implementation for section splitting or not. See https://crbug.com/1076175.
    public static final String AUTOFILL_USE_NEW_SECTIONING_METHOD = "AutofillUseNewSectioningMethod";

    // Controls whether to use the newest, parameterized sectioning algorithm.
    // TODO(crbug.com/1153539): Remove the feature when the experiment is completed.
    public static final String AUTOFILL_USE_PARAMETERIZED_SECTIONING = "AutofillUseParameterizedSectioning";

    // Controls an ablation study in which autofill for addresses and payment data
    // can be suppressed.
    public static final String AUTOFILL_ENABLE_ABLATION_STUDY = "AutofillEnableAblationStudy";

    // If enabled, crowdsourcing considers not just the value V but also the human
    // readable text HRT of an <option value="V">HRT</option> for voting.
    // TODO(crbug.com/1395740). This is a kill switch, remove once the feature has
    // settled.
    public static final String AUTOFILL_VOTE_FOR_SELECT_OPTION_VALUES = "AutofillVoteForSelectOptionValues";

    // Controls autofill popup style, if enabled it becomes more prominent,
    // i.e. its shadow becomes more emphasized, position is also updated.
    // TODO(crbug.com/1354136): Remove once the experiment is over.
    public static final String AUTOFILL_MORE_PROMINENT_POPUP = "AutofillMoreProminentPopup";

    // If enabled, we will log information of field types and autofill and forms
    // with sample rates according to Autofill FormSummary/FieldInfo UKM schema:
    // https://docs.google.com/document/d/1ZH0JbL6bES3cD4KqZWsGR6n8I-rhnkx6no6nQOgYq5w/.
    public static final String AUTOFILL_LOG_UKM_EVENTS_WITH_SAMPLE_RATE = "AutofillLogUKMEventsWithSampleRate";

    // Autofill is experimenting with an updated set of country specific rules.
    // Controls whether we use the current country-specific address import field
    // requirements or the updated ones.
    public static final String AUTOFILL_USE_UPDATED_REQUIRED_FIELDS_FOR_ADDRESS_IMPORT = "AutofillUseUpdatedRequiredFieldsForAddressImport";

    // Controls whether virtual card suggestions are shown on the touch to fill
    // surface for credit cards on Android.
    public static final String AUTOFILL_VIRTUAL_CARDS_ON_TOUCH_TO_FILL_ANDROID = "AutofillVirtualCardsOnTouchToFillAndroid";

    // When enabled, Autofill suggestions are displayed in the keyboard accessory
    // instead of the regular popup.
    public static final String AUTOFILL_KEYBOARD_ACCESSORY = "AutofillKeyboardAccessory_LAUNCHED";

    // Controls whether the touch to fill surface is shown for credit cards on
    // Android.
    public static final String AUTOFILL_TOUCH_TO_FILL_FOR_CREDIT_CARDS_ANDROID = "AutofillTouchToFillForCreditCardsAndroid";

    // Controls the whether the Chrome may provide a virtual view structure for
    // Android Autofill.
    public static final String AUTOFILL_VIRTUAL_VIEW_STRUCTURE_ANDROID = "AutofillVirtualViewStructureAndroid";


    public static final String AUTOFILL_USE_MOBILE_LABEL_DISAMBIGUATION = "AutofillUseMobileLabelDisambiguation";

    // When enabled, the keyboard accessory is shown for autocomplete=unrecognized
    // fields. Selecting a keyboard accessory suggestion will fill the triggering
    // field (independently of the autocomplete attribute) and all
    // autocomplete != unrecognized fields in the triggering field's section.
    // Note that this only affects address fields, since credit cards already ignore
    // autocomplete=unrecognized.
    // TODO(crbug.com/1446318): Remove when launched.
    public static final String AUTOFILL_SUGGESTIONS_FOR_AUTOCOMPLETE_UNRECOGNIZED_FIELDS_ON_MOBILE = "AutofillSuggestionsForAutocompleteUnrecognizedFieldsOnMobile";

    // Controls whether autofill activates on non-HTTP(S) pages. Useful for
    // automated tests with data URLS in cases where it's too difficult to use the
    // embedded test server. Generally avoid using.
    public static final String AUTOFILL_ALLOW_NON_HTTP_ACTIVATION = "AutofillAllowNonHttpActivation";

    // Testing tool that collects metrics during a run of the captured site tests
    // and dumps the collected metrics into a specified output directory.
    // For each test, a file named {test-name}.txt is created. It contains all the
    // collected metrics in the following format.
    // histogram-name-1
    // bucket value
    // ...
    // histogram-name-2
    // ...
    // The set of metrics can be restricted using
    // `kAutofillCapturedSiteTestsMetricsScraperMetricNames`.
    // It is helpful in conjunction with `tools/captured_sites/metrics-scraper.py`.
    public static final String AUTOFILL_CAPTURED_SITE_TESTS_METRICS_SCRAPER = "AutofillCapturedSiteTestsMetricsScraper";

    // If enabled, Autofill will not apply updates to address profiles based on data
    // extracted from submitted forms. This feature is mostly for debugging and
    // testing purposes and is not supposed to be launched.
    public static final String AUTOFILL_DISABLE_PROFILE_UPDATES = "AutofillDisableProfileUpdates";

    // If enabled, Autofill will not apply silent updates to the structure of
    // addresses and names. This feature is mostly for debugging and testing
    // purposes and is not supposed to be launched.
    public static final String AUTOFILL_DISABLE_SILENT_PROFILE_UPDATES = "AutofillDisableSilentProfileUpdates";

    // Enables logging the content of chrome://autofill-internals to the terminal.
    public static final String AUTOFILL_LOG_TO_TERMINAL = "AutofillLogToTerminal";

    // Enables or Disables (mostly for hermetic testing) autofill server
    // communication. The URL of the autofill server can further be controlled via
    // the autofill-server-url param. The given URL should specify the complete
    // autofill server API url up to the parent "directory" of the "query" and
    // "upload" resources.
    // i.e., https://other.autofill.server:port/tbproxy/af/
    public static final String AUTOFILL_SERVER_COMMUNICATION = "AutofillServerCommunication";

    // Controls attaching the autofill type predictions to their respective
    // element in the DOM.
    public static final String AUTOFILL_SHOW_TYPE_PREDICTIONS = "AutofillShowTypePredictions";

    // Autofill upload throttling is used for testing.
    public static final String AUTOFILL_UPLOAD_THROTTLING = "AutofillUploadThrottling";

    // When enabled, Android N+ devices will be supported for FIDO authentication.
    public static final String AUTOFILL_ENABLE_ANDROID_N_KEY_FOR_FIDO_AUTHENTICATION = "AutofillEnableAndroidNKeyForFidoAuthentication";

    // When enabled, card art images (instead of network icons) will be shown in
    // Payments Autofill UI.
    public static final String AUTOFILL_ENABLE_CARD_ART_IMAGE = "AutofillEnableCardArtImage";

    // When enabled, server will return card art images of the exact required
    // dimension.
    public static final String AUTOFILL_ENABLE_CARD_ART_SERVER_SIDE_STRETCHING = "AutofillEnableCardArtServerSideStretching";

    // When enabled, card product name (instead of issuer network) will be shown in
    // Payments Autofill UI.
    public static final String AUTOFILL_ENABLE_CARD_PRODUCT_NAME = "AutofillEnableCardProductName";

    // When enabled, we will store CVC for both local and server credit cards. This
    // will also allow the users to autofill their CVCs on checkout pages.
    public static final String AUTOFILL_ENABLE_CVC_STORAGE_AND_FILLING = "AutofillEnableCvcStorageAndFilling";

    // When enabled, if the user encounters the yellow path (challenge path) in the
    // VCN retrieval flow and the server denotes that the card is eligible for email
    // OTP authentication, email OTP authentication will be offered as one of the
    // challenge options.
    public static final String AUTOFILL_ENABLE_EMAIL_OTP_FOR_VCN_YELLOW_PATH = "AutofillEnableEmailOtpForVcnYellowPath";

    // When enabled, user's will see network card art images and network icons which
    // are larger, having a white border, and don't have the standard grey overlay
    // applied to them.
    public static final String AUTOFILL_ENABLE_NEW_CARD_ART_AND_NETWORK_IMAGES = "AutofillEnableNewCardArtAndNetworkImages";

    // When enabled, a progress dialog will display while authenticating with FIDO.
    // TODO(crbug.com/1337380): Clean up kAutofillEnableFIDOProgressDialog when it's
    // fully rolled out.
    public static final String AUTOFILL_ENABLE_FIDO_PROGRESS_DIALOG = "AutofillEnableFIDOProgressDialog";

    // When enabled, server card retrieval will begin with a risk-based check
    // instead of jumping straight to CVC or biometric auth.
    public static final String AUTOFILL_ENABLE_FPAN_RISK_BASED_AUTHENTICATION = "AutofillEnableFpanRiskBasedAuthentication";

    // When enabled, enable manual falling component for virtual cards on Android.
    public static final String AUTOFILL_ENABLE_MANUAL_FALLBACK_FOR_VIRTUAL_CARDS = "AutofillEnableManualFallbackForVirtualCards";

    // When enabled, the merchant_domain field is included in requests to unmask a
    // card.
    public static final String AUTOFILL_ENABLE_MERCHANT_DOMAIN_IN_UNMASK_CARD_REQUEST = "AutofillEnableMerchantDomainInUnmaskCardRequest";

    // When enabled, client side URL filtering will be triggered for the merchant
    // opt-out use-case, so that virtual card suggestions are not shown on websites
    // that are opted-out of virtual cards.
    public static final String AUTOFILL_ENABLE_MERCHANT_OPT_OUT_CLIENT_SIDE_URL_FILTERING = "AutofillEnableMerchantOptOutClientSideUrlFiltering";

    // When enabled, the GPay logo will be moved to the right side in payments
    // autofill dialogs and bubbles on desktop.
    public static final String AUTOFILL_ENABLE_MOVING_G_PAY_LOGO_TO_THE_RIGHT_ON_DESKTOP = "AutofillEnableMovingGPayLogoToTheRightOnDesktop";

    // When enabled, the GPay logo will be moved to the right side in payments
    // autofill dialogs and bubbles on clank.
    public static final String AUTOFILL_ENABLE_MOVING_G_PAY_LOGO_TO_THE_RIGHT_ON_CLANK = "AutofillEnableMovingGPayLogoToTheRightOnClank";

    // When enabled, the user will see a new banner logo and text in the bubble
    // offering to Upstream their cards onto Google Pay.
    public static final String AUTOFILL_ENABLE_NEW_SAVE_CARD_BUBBLE_UI = "AutofillEnableNewSaveCardBubbleUi";

    // When enabled, offers will be displayed in the Clank keyboard accessory during
    // downstream.
    public static final String AUTOFILL_ENABLE_OFFERS_IN_CLANK_KEYBOARD_ACCESSORY = "AutofillEnableOffersInClankKeyboardAccessory";

    // When enabled, the bottom sheet for save card and VCN enrollment will be
    // displayed instead of the info bar on Android.
    public static final String AUTOFILL_ENABLE_PAYMENTS_ANDROID_BOTTOM_SHEET = "AutofillEnablePaymentsAndroidBottomSheet";

    // When enabled, in use-cases where we would not have triggered any user-visible
    // authentication to autofill payment methods, we will trigger a device
    // authentication.
    public static final String AUTOFILL_ENABLE_PAYMENTS_MANDATORY_REAUTH = "AutofillEnablePaymentsMandatoryReauth";

    // When enabled, some extra metrics logging for Autofill Downstream will start.
    public static final String AUTOFILL_ENABLE_REMADE_DOWNSTREAM_METRICS = "AutofillEnableRemadeDownstreamMetrics";

    // When enabled, Autofill will attempt to offer upload save for IBANs
    // (International Bank Account Numbers) and autofill server-based IBANs.
    public static final String AUTOFILL_ENABLE_SERVER_IBAN = "AutofillEnableServerIban";

    // When enabled, if the user interacts with the manual fallback bottom sheet
    // on Android, it'll remain sticky until the user dismisses it.
    public static final String AUTOFILL_ENABLE_STICKY_MANUAL_FALLBACK_FOR_CARDS = "AutofillEnableStickyManualFallbackForCards";

    // When enabled, the user will have the ability to update the virtual card
    // enrollment of a credit card through their chrome browser after certain
    // autofill flows (for example, downstream and upstream), and from the settings
    // page.
    public static final String AUTOFILL_ENABLE_UPDATE_VIRTUAL_CARD_ENROLLMENT = "AutofillEnableUpdateVirtualCardEnrollment";

    // When enabled, after a successful authentication to autofill a virtual card,
    // the user will be prompted to opt-in to FIDO if the user is not currently
    // opted-in, and if the user is opted-in already and the virtual card is FIDO
    // eligible the user will be prompted to register the virtual card into FIDO.
    public static final String AUTOFILL_ENABLE_VIRTUAL_CARD_FIDO_ENROLLMENT = "AutofillEnableVirtualCardFidoEnrollment";

    // When enabled, Chrome will show metadata along with other card information
    // when the virtual card is presented to users.
    public static final String AUTOFILL_ENABLE_VIRTUAL_CARD_METADATA = "AutofillEnableVirtualCardMetadata";

    // When enabled, legal term of save card view and virtual card enroll view will
    // be moved before action buttons and icon will be moved after titles in those
    // views.
    public static final String AUTOFILL_MOVE_LEGAL_TERMS_AND_ICON_FOR_NEW_CARD_ENROLLMENT = "AutofillMoveLegalTermsAndIconForNewCardEnrollment";

    // When enabled, Autofill will attempt to find standalone CVC fields for VCN
    // card on file when parsing forms.
    public static final String AUTOFILL_PARSE_VCN_CARD_ON_FILE_STANDALONE_CVC_FIELDS = "AutofillParseVcnCardOnFileStandaloneCvcFields";

    // When enabled, Autofill suggestions that consist of a local and server
    // version of the same card will attempt to fill the server card upon selection
    // instead of the local card.
    public static final String AUTOFILL_SUGGEST_SERVER_CARD_INSTEAD_OF_LOCAL_CARD = "AutofillSuggestServerCardInsteadOfLocalCard";

    // When enabled, GPay-related links direct to the newer GPay Web site instead of
    // the legacy Payments Center.
    public static final String AUTOFILL_UPDATE_CHROME_SETTINGS_LINK_TO_G_PAY_WEB = "AutofillUpdateChromeSettingsLinkToGPayWeb";

    // Controls offering credit card upload to Google Payments. Cannot ever be
    // ENABLED_BY_DEFAULT because the feature state depends on the user's country.
    // The set of launched countries is listed in autofill_experiments.cc, and this
    // flag remains as a way to easily enable upload credit card save for testers,
    // as well as enable non-fully-launched countries on a trial basis.
    public static final String AUTOFILL_UPSTREAM = "AutofillUpstream";

    // When enabled, Chrome allows credit card upload to Google Payments if the
    // user's email domain is from a common email provider (thus unlikely to be an
    // enterprise or education user).
    public static final String AUTOFILL_UPSTREAM_ALLOW_ADDITIONAL_EMAIL_DOMAINS = "AutofillUpstreamAllowAdditionalEmailDomains";

    // When enabled, Chrome allows credit card upload to Google Payments, no matter
    // the user's email domain.
    public static final String AUTOFILL_UPSTREAM_ALLOW_ALL_EMAIL_DOMAINS = "AutofillUpstreamAllowAllEmailDomains";

    // When enabled, use two '•' when displaying the last four digits of a credit
    // card number. (E.g., '•• 8888' rather than '•••• 8888').
    public static final String AUTOFILL_USE_TWO_DOTS_FOR_LAST_FOUR_DIGITS = "AutofillUseTwoDotsForLastFourDigits";

    // When this and the above `kAutofillEnablePaymentsMandatoryReauth` are both
    // enabled, in use-cases where we would not have triggered any user-visible
    // authentication to autofill payment methods, we will trigger a device
    // authentication on Bling.
    public static final String AUTOFILL_ENABLE_PAYMENTS_MANDATORY_REAUTH_ON_BLING = "AutofillEnablePaymentsMandatoryReauthOnBling";

    // When this is enabled, virtual card enrollment and retrieval will be enabled
    // on Bling.
    public static final String AUTOFILL_ENABLE_VIRTUAL_CARDS = "AutofillEnableVirtualCards";

    // When enabled, Chrome will offer to pay with accounts supporting Pix.
    public static final String ENABLE_PIX_PAYMENTS = "EnablePixPayments";

    // Prevents instantiation.
    private AutofillFeatures() {
    }
}
