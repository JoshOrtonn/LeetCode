import org.example.LongestPalindrome
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestPalindromeTest {
    val longestPalindrome = LongestPalindrome()

    @Test
    fun emptyStringShouldEqual0() {
        assertEquals(0, longestPalindrome.solve(""))
    }

    @Test
    fun exampleStringShouldEqual7() {
        assertEquals(7, longestPalindrome.solve("abccccdd"))
    }

    @Test
    fun exampleRaceCarShouldEqual7() {
        assertEquals(7, longestPalindrome.solve("racecar"))
    }
    @Test
    fun exampleShouldBeCaseSensitive() {
        assertEquals(1, longestPalindrome.solve("Aa"))
    }

    @Test
    fun exampleShouldFactorOddsBetter() {
        assertEquals(3, longestPalindrome.solve("ccc"))
    }

    @Test
    fun exampleShouldFactorOddsBetterV2() {
        assertEquals(5, longestPalindrome.solve("cccddd"))
        // cdcdc
    }
}