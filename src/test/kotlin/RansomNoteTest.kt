import org.example.RansomNote
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/*
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
class RansomNoteTest{
    val ransomeSolver = RansomNote()

    @Test
    fun shouldFailForIncorrectLetters() {
        val ransomNote = "a"
        val magazine = "b"
        assertFalse(ransomeSolver.solve(ransomNote, magazine))
    }
    @Test
    fun shouldPassForSameNumberOfLettersReuse() {
        val ransomNote = "aa"
        val magazine = "aab"
        assertTrue(ransomeSolver.solve(ransomNote, magazine))
    }
    @Test
    fun shouldFailForMultipleUseReuse() {
        val ransomNote = "a"
        val magazine = "b"
        assertFalse(ransomeSolver.solve(ransomNote, magazine))
    }

}