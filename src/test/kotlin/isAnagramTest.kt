import org.example.IsAnagram
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class isAnagramTest{
    val isAnagram = IsAnagram()

    @Test
    fun isAnagramEx1(){
        val word = "anagram"
        val otherWordToBeTested = "nagaram"

        assertTrue(isAnagram.isAnagram(word, otherWordToBeTested))
    }
    @Test
    fun isAnagramEx2(){
        val word = "rat"
        val otherWordToBeTested = "car"

        assertFalse(isAnagram.isAnagram(word, otherWordToBeTested))
    }

    @Test
    fun isAnagramEx3(){
        val word = "aacc"
        val otherWordToBeTested = "ccac"

        assertFalse(isAnagram.isAnagram(word, otherWordToBeTested))
    }

    @Test
    fun isAnagramSortedEx1(){
        val word = "anagram"
        val otherWordToBeTested = "nagaram"

        assertTrue(isAnagram.isAnagramSorted(word, otherWordToBeTested))
    }
    @Test
    fun isAnagramSortedEx2(){
        val word = "rat"
        val otherWordToBeTested = "car"

        assertFalse(isAnagram.isAnagramSorted(word, otherWordToBeTested))
    }

    @Test
    fun isAnagramSortedEx3(){
        val word = "aacc"
        val otherWordToBeTested = "ccac"

        assertFalse(isAnagram.isAnagramSorted(word, otherWordToBeTested))
    }
}