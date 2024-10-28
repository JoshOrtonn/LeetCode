package org.example

import kotlin.math.abs

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