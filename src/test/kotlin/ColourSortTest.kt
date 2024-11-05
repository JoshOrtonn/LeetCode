import org.example.ColourSort
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ColourSortTest{
    val colourSort = ColourSort()

    @Test
    fun shouldInsertionSortColoursEx1() {
        val input = intArrayOf(2,0,2,1,1,0)
        val expectedOutput = intArrayOf(0,0,1,1,2,2)
        // Do the sorting in place
        colourSort.insertionSortColors(input)

        assertContentEquals(expectedOutput, input)
    }

    @Test
    fun shouldInsertionSortColoursEx2() {
        val input = intArrayOf(2,0,1)
        val expectedOutput = intArrayOf(0,1,2)
        // Do the sorting in place
        colourSort.insertionSortColors(input)

        assertContentEquals(expectedOutput, input)
    }

    @Test
    fun shouldInsertionSortColoursEx3() {
        val input = intArrayOf(5,2,4,6,1,3)
        val expectedOutput = intArrayOf(1,2,3,4,5,6)
        // Do the sorting in place
        colourSort.insertionSortColors(input)

        assertContentEquals(expectedOutput, input)
    }@Test
    fun shouldBubbleSortColoursEx1() {
        val input = intArrayOf(2,0,2,1,1,0)
        val expectedOutput = intArrayOf(0,0,1,1,2,2)
        // Do the sorting in place
        colourSort.bubbleSortColors(input)

        assertContentEquals(expectedOutput, input)
    }

    @Test
    fun shouldBubbleSortColoursEx2() {
        val input = intArrayOf(2,0,1)
        val expectedOutput = intArrayOf(0,1,2)
        // Do the sorting in place
        colourSort.bubbleSortColors(input)

        assertContentEquals(expectedOutput, input)
    }

    @Test
    fun shouldBubbleSortColoursEx3() {
        val input = intArrayOf(5,2,4,6,1,3)
        val expectedOutput = intArrayOf(1,2,3,4,5,6)
        // Do the sorting in place
        colourSort.bubbleSortColors(input)

        assertContentEquals(expectedOutput, input)
    }
}