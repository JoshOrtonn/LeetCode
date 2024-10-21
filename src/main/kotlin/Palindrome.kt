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
    //Generally use of stack is handy.
    // * Pushing half the string to a stack.
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

    // Beats runtime, but not memory obvs.
    fun isPalindromeStack(s: String): Boolean {
        /*
        Want to get stack version working as use case of halfway doesn't quite cut it.
        Probably due to odd vs even number either missing or including the middle letter
        val sanitisedString: String = s.filter { it.isLetter() }.lowercase()
         */
        val stack = ArrayDeque<Char>()
        val sanitisedString = s.filter { it.isLetterOrDigit() }.lowercase()

        // If even, it adds the middle character:
        // raceecar it adds the first e
        // For racecar it doesn't add the first e.
        for(i in 0 until sanitisedString.length /2) {
                stack.addFirst(sanitisedString[i])
        }

        // Hence we can ensure we specify the correct midPoint
        // for raceecar it's length is 8 hence midPoint is 4
        // Which for sanitisedString[4] would be second e, which works given first e works.
        val midPoint = if(sanitisedString.length % 2 == 0) {
            sanitisedString.length / 2
        } else {
            (sanitisedString.length + 1) /2
            // For racecar the length is 7, but given it's odd
            // We can ensure the midpoint is (sanitisedString+1)/ 2
            // Which means 8 / 2, so [4] as well.
            // Which given [4] is index based 0, it will be
            // r = 0 a = 1 c = 2 e = 3 c = 4
            // So essentially skipping the mid character which is perfect
            //
        }

        for (i in midPoint until sanitisedString.length) {
            if(sanitisedString[i] != stack.removeFirstOrNull()) return false
        }
        // If no violations found, return true
        return true
    }
}