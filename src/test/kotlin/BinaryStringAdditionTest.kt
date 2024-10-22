import org.example.BinaryStringAddition
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryStringAdditionTest {
    val binaryStringAddition = BinaryStringAddition()

    @Test
    fun shouldAddBinary() {
        val binaryString1 = "1"
        val binaryString2 = "11"

        assertEquals("100",binaryStringAddition.addBinary(binaryString1, binaryString2))
    }

    @Test
    fun shouldAddBinaryV2() {
        val binaryString1 = "1010"
        val binaryString2 = "1011"

        assertEquals("10101",binaryStringAddition.addBinary(binaryString1, binaryString2))
    }
    @Test
    fun shouldAddBinaryV3() {
        val binaryString1 = "10"
        val binaryString2 = "101111"

        assertEquals("110001",binaryStringAddition.addBinary(binaryString1, binaryString2))
    }
}