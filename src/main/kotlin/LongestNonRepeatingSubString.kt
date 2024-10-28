package org.example

import kotlin.math.abs


/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
class LongestNonRepeatingSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstring = 0
        var maxSubstring = 0
        val charIntHashMap = hashMapOf<Char, Int>()

        var mutableInputString = s

        mutableInputString.forEachIndexed { index, char ->
            val previousCharIndex = charIntHashMap.put(char, index)
            // If no previous char found, iterate longest subString as clash not found
            if(previousCharIndex == null) {
                longestSubstring++
                maxSubstring = maxOf(maxSubstring, longestSubstring)
            } else {
                // Clash found, update mutableInput string to remove all chars, before the clash
                // Then remove them from the hashmap so they are allowed to be included again in longest substring.
                val charsToRemove: String = mutableInputString.substringBefore(char)
                charsToRemove.forEach {
                    charIntHashMap.remove(it)
                }

                // Then remove the first char after the clash.
                mutableInputString = mutableInputString.substringAfter(char)
                // Calc the new longestSubstring based on the difference of the two indexes
                longestSubstring = abs(index - previousCharIndex)
                maxSubstring = maxOf(maxSubstring, longestSubstring)
            }
        }

        return maxSubstring
    }
}