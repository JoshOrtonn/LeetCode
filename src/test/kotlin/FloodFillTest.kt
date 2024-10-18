import org.example.FloodFill
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class FloodFillTest {
    @Test
    fun isFloodFillCorrectEx1() {
        val input = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
        val expectedOutput = arrayOf(intArrayOf(2, 2, 2), intArrayOf(2, 2, 0), intArrayOf(2, 0, 1))

        val floodFilledImage = FloodFill().floodFill(input, 1, 1, 2)
        assertContentEquals(expectedOutput[0], floodFilledImage[0])
        assertContentEquals(expectedOutput[1], floodFilledImage[1])
        assertContentEquals(expectedOutput[2], floodFilledImage[2])
    }

    @Test
    fun isFloodFillEdgeCase() {
        val input = arrayOf(intArrayOf(0, 0 ,0), intArrayOf(0, 0, 0))

        val floodFill = FloodFill()
        assertContentEquals(input, floodFill.floodFill(input, 0, 0, 0))
    }
}