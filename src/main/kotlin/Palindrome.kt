package org.example

/**
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Generally use of stack is handy.
 * Pushing half the string to a stack.
 *
 */
class Palindrome {
    fun isPalindrome(s: String): Boolean {
        /*
        Want to get stack version working as use case of halfway doesn't quite cut it.
        Probably due to odd vs even number either missing or including the middle letter
        val sanitisedString: String = s.filter { it.isLetter() }.lowercase()

        val stack = ArrayDeque<Char>()

        for(i in 0 until sanitisedString.length /2) {
            stack.addFirst(sanitisedString[i])
        }
        for (i in sanitisedString.length/2 until sanitisedString.length) {
            if(sanitisedString[i] != stack.removeFirstOrNull()) return false
        }
         */

        return s.filter { it.isLetter() }.lowercase().let { it == it.reversed() }
    }
}