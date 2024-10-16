import org.example.Palindrome
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

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
 */

class PalindromeTest {
    val palindrome = Palindrome()

    @Test
    fun assertExpectedOutcome() {
        assertTrue(palindrome.isPalindrome( "A man, a plan, a canal: Panama"))
    }

    @Test
    fun assertExpectedFalse() {
        assertFalse(palindrome.isPalindrome( "race a car"))
    }

    @Test
    fun assertExpectedEdgeCase() {
        assertTrue(palindrome.isPalindrome( " "))
    }
    @Test
    fun assertExpectedABCase() {
        assertFalse(palindrome.isPalindrome( "ab"))
    }

    @Test
    fun assertExpectedAACase() {
        assertTrue(palindrome.isPalindrome( "aa"))
    }
}