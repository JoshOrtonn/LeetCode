package org.example

import kotlin.math.abs

class LongestNonRepeatingSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstring = 0
        var maxSubstring = 0
        val charIntHashMap = hashMapOf<Char, Int>()

        var movingGoalPosts = s

        movingGoalPosts.forEachIndexed { index, char ->
            val previousCharIndex = charIntHashMap.put(char, index+1)

            if(previousCharIndex == null) {
                longestSubstring++
                maxSubstring = maxOf(maxSubstring, longestSubstring)
            } else {
                // this doesn't work..
                val charsToRemove: String = movingGoalPosts.substringBefore(char)
                charsToRemove.forEach {
                    charIntHashMap.remove(it)
                }
                movingGoalPosts = movingGoalPosts.substringAfter(char)
                longestSubstring = abs(index+1 - previousCharIndex)
                maxSubstring = maxOf(maxSubstring, longestSubstring)
            }
        }

        return maxSubstring
    }
}