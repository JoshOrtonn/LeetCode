import org.example.MergeIntervals
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MergeIntervalsTest {
    val mergeIntervals = MergeIntervals()

    @Test
    fun mergeShouldSolveForCase1() {
        val inputIntervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))

        val expectedOutcome = arrayOf(intArrayOf(1,6), intArrayOf(8,10), intArrayOf(15, 18))

        assertContentEquals(expectedOutcome[0], mergeIntervals.merge(inputIntervals)[0])
        assertContentEquals(expectedOutcome[1], mergeIntervals.merge(inputIntervals)[1])
        assertContentEquals(expectedOutcome[1], mergeIntervals.merge(inputIntervals)[1])
    }
    @Test
    fun mergeShouldSolveForCase2() {
        val inputIntervals = arrayOf(intArrayOf(1, 4))

        val expectedOutcome = arrayOf(intArrayOf(1,4))

        assertContentEquals(expectedOutcome[0], mergeIntervals.merge(inputIntervals)[0])
    }
    @Test
    fun mergeShouldSolveForCase3() {
        val inputIntervals = arrayOf(intArrayOf(1, 4), intArrayOf(0, 4))

        val expectedOutcome = arrayOf(intArrayOf(0,4))

        assertContentEquals(expectedOutcome[0], mergeIntervals.merge(inputIntervals)[0])
    }

    @Test
    fun mergeShouldSolveForCase4() {
        val inputIntervals = arrayOf(intArrayOf(1, 4), intArrayOf(0, 2), intArrayOf(3, 5))
        val expectedOutcome = arrayOf(intArrayOf(0, 5))

        assertContentEquals(expectedOutcome[0], mergeIntervals.merge(inputIntervals)[0])
    }

    @Test
    fun mergeShouldSolveForCase5() {
        val inputIntervals = arrayOf(intArrayOf(2, 3), intArrayOf(2, 2), intArrayOf(3,3), intArrayOf(1,3), intArrayOf(5,7), intArrayOf(2,2), intArrayOf(4,6))
        val expectedOutcome = arrayOf(intArrayOf(1,3), intArrayOf(4,7))

        assertContentEquals(expectedOutcome[0], mergeIntervals.merge(inputIntervals)[0])
        assertContentEquals(expectedOutcome[1], mergeIntervals.merge(inputIntervals)[1])
    }

}