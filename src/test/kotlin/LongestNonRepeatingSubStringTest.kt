import org.example.LongestNonRepeatingSubString
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestNonRepeatingSubStringTest{
    val longestNonRepeatingSubString = LongestNonRepeatingSubString()
    @Test
    fun solveForExample1(){

        val input = "abcabcbb"
        val expectedOutput = 3
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))
        //Explanation: The answer is "abc", with the length of 3.
    }

    @Test
    fun solveForExample2(){

        val input = "bbbbb"
        val expectedOutput = 1
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))
        //Explanation: The answer is "b", with the length of 1.
    }

    @Test
    fun solveForExample3(){

        val input = "pwwkew"
        val expectedOutput = 3
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))
        /*Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        */
    }

    @Test
    fun solveForExample4(){

        val input = "dvdf"
        val expectedOutput = 3
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))
        /*Input: s = "dvdf"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        */
    }

    @Test
    fun solveForExample5(){

        val input = "abcabcbb"
        val expectedOutput = 3
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))
        /*Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        */
    }
    @Test
    fun solveForExample6(){

        val input = "cabbyaa"
        val expectedOutput = 3
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))

    }

    @Test
    fun solveForExample7(){
        val input = "wobgrovw"
        val expectedOutput = 6
        assertEquals(expectedOutput, longestNonRepeatingSubString.lengthOfLongestSubstring(input))

    }


}