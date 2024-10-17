package org.example

class IsAnagram {
    /**
     *
     * Given two strings s and t, return true if t is an
     * anagram
     *  of s, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     *
     * Output: false
     *
     *
     */
    // One option is to create two hashmaps of occurences and ensure they are the same.
    // Or even one hashmap, and add from one, remove from another, ensuring at the end of the day
    // it's an empty hashmap.
    fun isAnagram(word: String, otherWordToBeTested: String): Boolean {
        val wordHashmap = buildMap<Char, Int> {
            word.forEach {
                val existingValue = getOrDefault(it, 0)
                put(it, existingValue+1)
            }
            otherWordToBeTested.forEach {
                put(it, getOrDefault(it, 0)-1)
            }
        }
        return wordHashmap.values.all { it == 0 }
    }

    // Or neatly convert to charArray, sort and ensure they are equal
    fun isAnagramSorted(word: String, otherWordToBeTested: String): Boolean {
        return word.toCharArray().sorted() == otherWordToBeTested.toCharArray().sorted()
    }
}