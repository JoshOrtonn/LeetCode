package org.example

/***
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true




 */
class RansomNote {
    fun solve(ransomNote: String, magazine: String): Boolean {
        val hashMapMag = buildMap<Char, Int> {
            magazine.forEach {
                put(it, this.getOrDefault(it, 0) + 1)
            }
        }.toMutableMap()

        ransomNote.forEach {
            val previousValue = hashMapMag[it]
            if (previousValue == null || previousValue == 0) {
                return false
            } else {
                hashMapMag[it] = previousValue - 1
            }
        }
        return true
    }
}