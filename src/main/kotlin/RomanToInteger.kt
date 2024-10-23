package org.example

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 *
 */
class RomanToInteger {
    private val romanToIntMap = mapOf(
        "I" to 1,
        "IV" to 4,
        "V" to 5,
        "IX" to 9,
        "X" to 10,
        "XL" to 40,
        "L" to 50,
        "XC" to 90,
        "C" to 100,
        "CD" to 400,
        "D" to 500,
        "CM" to 900,
        "M" to 1000
    )


    // Two pointer for current and next
    // Map lookup for two letter numeral, if not fallback to single letter numeral
    // If two letters ensure we move along the numeral twice on that loop.
    fun romanToInt(s: String): Int {
        var runningTotal = 0
        var current = 0
        var next = 1

        while (current <= s.lastIndex) {
            val currentLetter = s[current]
            if (next <= s.lastIndex) {
                val nextLetter = s[next]

                val twoCharNumeral: Int = numeralStringToInt(buildString {
                    append(currentLetter)
                    append(nextLetter)
                })

                if (twoCharNumeral != 0) {
                    runningTotal += twoCharNumeral
                    // Shimme along the roman numeral once more, as we've found two letter numeral
                    current++
                    next++
                } else {
                    // constraint being that c will be a roman numeral
                    runningTotal += numeralStringToInt(currentLetter.toString())
                }
            } else {
                // constraints being that last c will be a roman numeral
                runningTotal += numeralStringToInt(currentLetter.toString())
            }
            current++
            next++
        }
        return runningTotal
    }

    // Ever so slightly better than a map, but code readability I prefer the map.
    private fun numeralStringToInt(numeral: String): Int {
        return when (numeral) {
            "I" -> 1
            "IV" -> 4
            "V" -> 5
            "IX" -> 9
            "X" -> 10
            "XL" -> 40
            "L" -> 50
            "XC" -> 90
            "C" -> 100
            "CD" -> 400
            "D" -> 500
            "CM" -> 900
            "M" -> 1000
            else -> 0 // For the case whereby two char string doesn't match.
        }
    }
}