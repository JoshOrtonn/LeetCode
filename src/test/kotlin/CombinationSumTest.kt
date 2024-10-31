import org.example.CombinationSum
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class CombinationSumTest {
    val combinationSum = CombinationSum()

    @Test
    fun shouldSolvePossibleCombinationsCase1() {
        val candiates = intArrayOf(2, 3, 6, 7)
        val target = 7

        val expectedOutput = listOf(listOf(2, 2, 3), listOf(7))

        assertContentEquals(expectedOutput, combinationSum.combinationSum(candiates, target))
    }

    @Test
    fun shouldSolvePossibleCombinationsCase2() {
        val candiates = intArrayOf(2, 3, 5)
        val target = 8

        val expectedOutput = listOf(listOf(3, 5), listOf(2, 3, 3), listOf(2, 2, 2, 2))

        assertContentEquals(expectedOutput, combinationSum.combinationSum(candiates, target))
    }

    @Test
    fun shouldReturnEmptyListIfUnableToSolve() {
        val candiates = intArrayOf(2)
        val target = 1

        val expectedOutput = emptyList<List<Int>>()

        assertContentEquals(expectedOutput, combinationSum.combinationSum(candiates, target))
    }

    @Test
    fun shouldReturn11ForExample4() {
        val candiates = intArrayOf(8,7,4,3)

        val target = 11
        val expectedOutput = listOf(listOf(4, 7), listOf(3, 4, 4), listOf(3, 8))

        assertContentEquals(expectedOutput, combinationSum.combinationSum(candiates, target))
    }

}