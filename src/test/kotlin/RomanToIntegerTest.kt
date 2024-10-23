import org.example.RomanToInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class RomanToIntegerTest{
    val romanToInteger = RomanToInteger()

    @Test
    fun shouldResolveRomanNumeralTo1994(){
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"))
    }
    @Test
    fun shouldResolveRomanNumeralTo3(){
        assertEquals(3, romanToInteger.romanToInt("III"))
    }
    @Test
    fun shouldResolveRomanNumeralTo58(){
        assertEquals(58, romanToInteger.romanToInt("LVIII"))
    }
}