import org.example.ColourSort
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ColourSortTest{
    val colourSort = ColourSort()

    @Test
    fun shouldSortColoursEx1() {
        val input = intArrayOf(2,0,2,1,1,0)
        val expectedOutput = intArrayOf(0,0,1,1,2,2)

        assertContentEquals(expectedOutput, colourSort.sortColors(input))
    }

    @Test
    fun shouldSortColoursEx2() {
        val input = intArrayOf(2,0,1)
        val expectedOutput = intArrayOf(0,1,2)

        assertContentEquals(expectedOutput, colourSort.sortColors(input))
    }

    @Test
    fun shouldSortColoursEx3() {
        val input = intArrayOf(5,2,4,6,1,3)
        val expectedOutput = intArrayOf(1,2,3,4,5,6)

        assertContentEquals(expectedOutput, colourSort.sortColors(input))
    }
}