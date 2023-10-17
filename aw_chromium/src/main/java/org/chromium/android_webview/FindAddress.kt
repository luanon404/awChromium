// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import androidx.annotation.VisibleForTesting
import java.util.Locale
import java.util.regex.MatchResult
import java.util.regex.Pattern

/**
 * Java implementation of legacy WebView.findAddress algorithm.
 */
@VisibleForTesting
object FindAddress {
    // Addresses consist of at least this many words, not including state and zip code.
    private const val MIN_ADDRESS_WORDS = 4

    // Adddresses consist of at most this many words, not including state and zip code.
    private const val MAX_ADDRESS_WORDS = 14

    // Addresses consist of at most this many lines.
    private const val MAX_ADDRESS_LINES = 5

    // No words in an address are longer than this many characters.
    private const val kMaxAddressNameWordLength = 25

    // Location name should be in the first MAX_LOCATION_NAME_DISTANCE words
    private const val MAX_LOCATION_NAME_DISTANCE = 5
    private val sStateZipCodeRanges = arrayOf(
        ZipRange(99, 99, -1),  // AK Alaska.
        ZipRange(35, 36, -1),  // AL Alabama.
        ZipRange(71, 72, -1),  // AR Arkansas.
        ZipRange(96, 96, -1),  // AS American Samoa.
        ZipRange(85, 86, -1),  // AZ Arizona.
        ZipRange(90, 96, -1),  // CA California.
        ZipRange(80, 81, -1),  // CO Colorado.
        ZipRange(6, 6, -1),  // CT Connecticut.
        ZipRange(20, 20, -1),  // DC District of Columbia.
        ZipRange(19, 19, -1),  // DE Delaware.
        ZipRange(32, 34, -1),  // FL Florida.
        ZipRange(96, 96, -1),  // FM Federated States of Micronesia.
        ZipRange(30, 31, -1),  // GA Georgia.
        ZipRange(96, 96, -1),  // GU Guam.
        ZipRange(96, 96, -1),  // HI Hawaii.
        ZipRange(50, 52, -1),  // IA Iowa.
        ZipRange(83, 83, -1),  // ID Idaho.
        ZipRange(60, 62, -1),  // IL Illinois.
        ZipRange(46, 47, -1),  // IN Indiana.
        ZipRange(66, 67, 73),  // KS Kansas.
        ZipRange(40, 42, -1),  // KY Kentucky.
        ZipRange(70, 71, -1),  // LA Louisiana.
        ZipRange(1, 2, -1),  // MA Massachusetts.
        ZipRange(20, 21, -1),  // MD Maryland.
        ZipRange(3, 4, -1),  // ME Maine.
        ZipRange(96, 96, -1),  // MH Marshall Islands.
        ZipRange(48, 49, -1),  // MI Michigan.
        ZipRange(55, 56, -1),  // MN Minnesota.
        ZipRange(63, 65, -1),  // MO Missouri.
        ZipRange(96, 96, -1),  // MP Northern Mariana Islands.
        ZipRange(38, 39, -1),  // MS Mississippi.
        ZipRange(55, 56, -1),  // MT Montana.
        ZipRange(27, 28, -1),  // NC North Carolina.
        ZipRange(58, 58, -1),  // ND North Dakota.
        ZipRange(68, 69, -1),  // NE Nebraska.
        ZipRange(3, 4, -1),  // NH New Hampshire.
        ZipRange(7, 8, -1),  // NJ New Jersey.
        ZipRange(87, 88, 86),  // NM New Mexico.
        ZipRange(88, 89, 96),  // NV Nevada.
        ZipRange(10, 14, 0),  // NY New York.
        ZipRange(43, 45, -1),  // OH Ohio.
        ZipRange(73, 74, -1),  // OK Oklahoma.
        ZipRange(97, 97, -1),  // OR Oregon.
        ZipRange(15, 19, -1),  // PA Pennsylvania.
        ZipRange(6, 6, 0),  // PR Puerto Rico.
        ZipRange(96, 96, -1),  // PW Palau.
        ZipRange(2, 2, -1),  // RI Rhode Island.
        ZipRange(29, 29, -1),  // SC South Carolina.
        ZipRange(57, 57, -1),  // SD South Dakota.
        ZipRange(37, 38, -1),  // TN Tennessee.
        ZipRange(75, 79, 87),  // TX Texas.
        ZipRange(84, 84, -1),  // UT Utah.
        ZipRange(22, 24, 20),  // VA Virginia.
        ZipRange(6, 9, -1),  // VI Virgin Islands.
        ZipRange(5, 5, -1),  // VT Vermont.
        ZipRange(98, 99, -1),  // WA Washington.
        ZipRange(53, 54, -1),  // WI Wisconsin.
        ZipRange(24, 26, -1),  // WV West Virginia.
        ZipRange(82, 83, -1) // WY Wyoming.
    )

    // Newlines
    private const val NL = "\n\u000B\u000C\r\u0085\u2028\u2029"

    // Space characters
    private const val SP = ("\u0009\u0020\u00A0\u1680\u2000\u2001"
            + "\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F"
            + "\u205F\u3000")

    // Whitespace
    private const val WS = SP + NL

    // Characters that are considered word delimiters.
    private const val WORD_DELIM = ",*\u2022$WS"

    // Lookahead for word end.
    private const val WORD_END = "(?=[$WORD_DELIM]|$)"

    // Address words are a sequence of non-delimiter characters.
    private val sWordRe =
        Pattern.compile("[^$WORD_DELIM]+$WORD_END", Pattern.CASE_INSENSITIVE)

    // Characters that are considered suffix delimiters for house numbers.
    private const val HOUSE_POST_DELIM = ",\"'$WS"

    // Lookahead for house end.
    private const val HOUSE_END = "(?=[$HOUSE_POST_DELIM]|$)"

    // Characters that are considered prefix delimiters for house numbers.
    private const val HOUSE_PRE_DELIM = ":$HOUSE_POST_DELIM"

    // A house number component is "one" or a number, optionally
    // followed by a single alphabetic character, or
    private const val HOUSE_COMPONENT = "(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)"

    // House numbers are a repetition of |HOUSE_COMPONENT|, separated by -, and followed by
    // a delimiter character.
    private val sHouseNumberRe = Pattern.compile(
        "$HOUSE_COMPONENT(?:-$HOUSE_COMPONENT)*$HOUSE_END",
        Pattern.CASE_INSENSITIVE
    )

    // XXX: do we want to accept whitespace other than 0x20 in state names?
    private val sStateRe = Pattern.compile(
        "(?:"
                + "(ak|alaska)|"
                + "(al|alabama)|"
                + "(ar|arkansas)|"
                + "(as|american[" + SP + "]+samoa)|"
                + "(az|arizona)|"
                + "(ca|california)|"
                + "(co|colorado)|"
                + "(ct|connecticut)|"
                + "(dc|district[" + SP + "]+of[" + SP + "]+columbia)|"
                + "(de|delaware)|"
                + "(fl|florida)|"
                + "(fm|federated[" + SP + "]+states[" + SP + "]+of[" + SP + "]+micronesia)|"
                + "(ga|georgia)|"
                + "(gu|guam)|"
                + "(hi|hawaii)|"
                + "(ia|iowa)|"
                + "(id|idaho)|"
                + "(il|illinois)|"
                + "(in|indiana)|"
                + "(ks|kansas)|"
                + "(ky|kentucky)|"
                + "(la|louisiana)|"
                + "(ma|massachusetts)|"
                + "(md|maryland)|"
                + "(me|maine)|"
                + "(mh|marshall[" + SP + "]+islands)|"
                + "(mi|michigan)|"
                + "(mn|minnesota)|"
                + "(mo|missouri)|"
                + "(mp|northern[" + SP + "]+mariana[" + SP + "]+islands)|"
                + "(ms|mississippi)|"
                + "(mt|montana)|"
                + "(nc|north[" + SP + "]+carolina)|"
                + "(nd|north[" + SP + "]+dakota)|"
                + "(ne|nebraska)|"
                + "(nh|new[" + SP + "]+hampshire)|"
                + "(nj|new[" + SP + "]+jersey)|"
                + "(nm|new[" + SP + "]+mexico)|"
                + "(nv|nevada)|"
                + "(ny|new[" + SP + "]+york)|"
                + "(oh|ohio)|"
                + "(ok|oklahoma)|"
                + "(or|oregon)|"
                + "(pa|pennsylvania)|"
                + "(pr|puerto[" + SP + "]+rico)|"
                + "(pw|palau)|"
                + "(ri|rhode[" + SP + "]+island)|"
                + "(sc|south[" + SP + "]+carolina)|"
                + "(sd|south[" + SP + "]+dakota)|"
                + "(tn|tennessee)|"
                + "(tx|texas)|"
                + "(ut|utah)|"
                + "(va|virginia)|"
                + "(vi|virgin[" + SP + "]+islands)|"
                + "(vt|vermont)|"
                + "(wa|washington)|"
                + "(wi|wisconsin)|"
                + "(wv|west[" + SP + "]+virginia)|"
                + "(wy|wyoming)"
                + ")" + WORD_END,
        Pattern.CASE_INSENSITIVE
    )
    private val sLocationNameRe = Pattern.compile(
        "(?:"
                + "alley|annex|arcade|ave[.]?|avenue|alameda|bayou|"
                + "beach|bend|bluffs?|bottom|boulevard|branch|bridge|"
                + "brooks?|burgs?|bypass|broadway|camino|camp|canyon|"
                + "cape|causeway|centers?|circles?|cliffs?|club|common|"
                + "corners?|course|courts?|coves?|creek|crescent|crest|"
                + "crossing|crossroad|curve|circulo|dale|dam|divide|"
                + "drives?|estates?|expressway|extensions?|falls?|ferry|"
                + "fields?|flats?|fords?|forest|forges?|forks?|fort|"
                + "freeway|gardens?|gateway|glens?|greens?|groves?|"
                + "harbors?|haven|heights|highway|hills?|hollow|inlet|"
                + "islands?|isle|junctions?|keys?|knolls?|lakes?|land|"
                + "landing|lane|lights?|loaf|locks?|lodge|loop|mall|"
                + "manors?|meadows?|mews|mills?|mission|motorway|mount|"
                + "mountains?|neck|orchard|oval|overpass|parks?|"
                + "parkways?|pass|passage|path|pike|pines?|plains?|"
                + "plaza|points?|ports?|prairie|privada|radial|ramp|"
                + "ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|"
                + "row|rue|run|shoals?|shores?|skyway|springs?|spurs?|"
                + "squares?|station|stravenue|stream|st[.]?|streets?|"
                + "summit|speedway|terrace|throughway|trace|track|"
                + "trafficway|trail|tunnel|turnpike|underpass|unions?|"
                + "valleys?|viaduct|views?|villages?|ville|vista|walks?|"
                + "wall|ways?|wells?|xing|xrd)" + WORD_END,
        Pattern.CASE_INSENSITIVE
    )
    private val sSuffixedNumberRe = Pattern.compile("(\\d+)(st|nd|rd|th)", Pattern.CASE_INSENSITIVE)
    private val sZipCodeRe =
        Pattern.compile("\\d{5}(?:-\\d{4})?$WORD_END", Pattern.CASE_INSENSITIVE)

    private fun checkHouseNumber(houseNumber: String): Boolean {
        // Make sure that there are at most 5 digits.
        var digitCount = 0
        for (element in houseNumber) {
            if (Character.isDigit(element)) ++digitCount
        }
        if (digitCount > 5) return false

        // Make sure that any ordinals are valid.
        val suffixMatcher = sSuffixedNumberRe.matcher(houseNumber)
        while (suffixMatcher.find()) {
            val num = suffixMatcher.group(1)!!.toInt()
            if (num == 0) {
                return false // 0th is invalid.
            }
            val suffix = suffixMatcher.group(2)!!.lowercase(Locale.getDefault())
            return when (num % 10) {
                1 -> suffix == if (num % 100 == 11) "th" else "st"
                2 -> suffix == if (num % 100 == 12) "th" else "nd"
                3 -> suffix == if (num % 100 == 13) "th" else "rd"
                else -> suffix == "th"
            }
        }
        return true
    }

    /**
     * Attempt to match a house number beginnning at position offset
     * in content.  The house number must be followed by a word
     * delimiter or the end of the string, and if offset is non-zero,
     * then it must also be preceded by a word delimiter.
     *
     * @return a MatchResult if a valid house number was found.
     */
    @VisibleForTesting
    fun matchHouseNumber(content: String, offset: Int): MatchResult? {
        if (offset > 0 && HOUSE_PRE_DELIM.indexOf(content[offset - 1]) == -1) return null
        val matcher = sHouseNumberRe.matcher(content).region(offset, content.length)
        if (matcher.lookingAt()) {
            val matchResult = matcher.toMatchResult()
            if (checkHouseNumber(matchResult.group(0))) return matchResult
        }
        return null
    }

    /**
     * Attempt to match a US state beginnning at position offset in
     * content.  The matching state must be followed by a word
     * delimiter or the end of the string, and if offset is non-zero,
     * then it must also be preceded by a word delimiter.
     *
     * @return a MatchResult if a valid US state (or two letter code)
     * was found.
     */
    @VisibleForTesting
    fun matchState(content: String, offset: Int): MatchResult? {
        if (offset > 0 && WORD_DELIM.indexOf(content[offset - 1]) == -1) return null
        val stateMatcher = sStateRe.matcher(content).region(offset, content.length)
        return if (stateMatcher.lookingAt()) stateMatcher.toMatchResult() else null
    }

    /**
     * Test whether zipCode matches the U.S. zip code format (ddddd or
     * ddddd-dddd) and is within the expected range, given that
     * stateMatch is a match of sStateRe.
     *
     * @return true if zipCode is a valid zip code, is legal for the
     * matched state, and is followed by a word delimiter or the end
     * of the string.
     */
    private fun isValidZipCode(zipCode: String, stateMatch: MatchResult?): Boolean {
        if (stateMatch == null) return false
        // Work out the index of the state, based on which group matched.
        var stateIndex = stateMatch.groupCount()
        while (stateIndex > 0) {
            if (stateMatch.group(stateIndex--) != null) break
        }
        return (sZipCodeRe.matcher(zipCode).matches()
                && sStateZipCodeRanges[stateIndex].matches(zipCode))
    }

    /**
     * Test whether location is one of the valid locations.
     *
     * @return true if location starts with a valid location name
     * followed by a word delimiter or the end of the string.
     */
    @VisibleForTesting
    fun isValidLocationName(location: String?): Boolean {
        return sLocationNameRe.matcher(location!!).matches()
    }

    /**
     * Attempt to match a complete address in content, starting with
     * houseNumberMatch.
     *
     * @param content The string to search.
     * @param houseNumberMatch A matching house number to start extending.
     * @return +ve: the end of the match
     * +ve: the position to restart searching for house numbers, negated.
     */
    private fun attemptMatch(content: String, houseNumberMatch: MatchResult): Int {
        var restartPos = -1
        var nonZipMatch = -1
        var it = houseNumberMatch.end()
        var numLines = 1
        var consecutiveHouseNumbers = true
        var foundLocationName = false
        var wordCount = 1
        var lastWord = ""
        val matcher = sWordRe.matcher(content)
        while (it < content.length) {
            if (!matcher.find(it)) {
                // No more words in the input sequence.
                return -content.length
            }
            if (matcher.end() - matcher.start() > kMaxAddressNameWordLength) {
                // Word is too long to be part of an address. Fail.
                return -matcher.end()
            }

            // Count the number of newlines we just consumed.
            while (it < matcher.start()) {
                if (NL.indexOf(content[it++]) != -1) ++numLines
            }

            // Consumed too many lines. Fail.
            if (numLines > MAX_ADDRESS_LINES) break

            // Consumed too many words. Fail.
            if (++wordCount > MAX_ADDRESS_WORDS) break
            if (matchHouseNumber(content, it) != null) {
                if (consecutiveHouseNumbers && numLines > 1) {
                    // Last line ended with a number, and this this line starts with one.
                    // Restart at this number.
                    return -it
                }
                // Remember the position of this match as the restart position.
                if (restartPos == -1) restartPos = it
                lastWord = matcher.group(0)!!
                it = matcher.end()
                continue
            }
            consecutiveHouseNumbers = false
            if (isValidLocationName(matcher.group(0))) {
                foundLocationName = true
                lastWord = matcher.group(0)!!
                it = matcher.end()
                continue
            }
            if (wordCount == MAX_LOCATION_NAME_DISTANCE && !foundLocationName) {
                // Didn't find a location name in time. Fail.
                it = matcher.end()
                break
            }
            if (foundLocationName && wordCount > MIN_ADDRESS_WORDS) {
                // We can now attempt to match a state.
                val stateMatch = matchState(content, it)
                if (stateMatch != null) {
                    if (lastWord == "et" && stateMatch.group(0) == "al") {
                        // Reject "et al" as a false postitive.
                        it = stateMatch.end()
                        break
                    }

                    // At this point we've matched a state; try to match a zip code after it.
                    val zipMatcher = sWordRe.matcher(content)
                    if (zipMatcher.find(stateMatch.end())) {
                        if (isValidZipCode(zipMatcher.group(0)!!, stateMatch)) {
                            return zipMatcher.end()
                        }
                    } else {
                        // The content ends with a state but no zip
                        // code. This is a legal match according to the
                        // documentation. N.B. This is equivalent to the
                        // original c++ implementation, which only allowed
                        // the zip code to be optional at the end of the
                        // string, which presumably is a bug.  We tried
                        // relaxing this to work in other places but it
                        // caused too many false positives.
                        nonZipMatch = stateMatch.end()
                    }
                }
            }
            lastWord = matcher.group(0)!!
            it = matcher.end()
        }
        return if (nonZipMatch > 0) nonZipMatch else -if (restartPos > 0) restartPos else it
    }

    /**
     * Return the first matching address in content.
     *
     * @param content The string to search.
     * @return The first valid address, or null if no address was matched.
     */
    @JvmStatic
    @VisibleForTesting
    fun findAddress(content: String): String? {
        val houseNumberMatcher = sHouseNumberRe.matcher(content)
        var start = 0
        while (houseNumberMatcher.find(start)) {
            if (checkHouseNumber(houseNumberMatcher.group(0)!!)) {
                start = houseNumberMatcher.start()
                val end = attemptMatch(content, houseNumberMatcher)
                if (end > 0) {
                    return content.substring(start, end)
                }
                start = -end
            } else {
                start = houseNumberMatcher.end()
            }
        }
        return null
    }

    internal class ZipRange(private var mLow: Int, private var mHigh: Int, private var mException1: Int) {
        private var mException2: Int = mException1

        fun matches(zipCode: String): Boolean {
            val prefix = zipCode.substring(0, 2).toInt()
            return prefix in mLow..mHigh || prefix == mException1 || prefix == mException2
        }
    }
}