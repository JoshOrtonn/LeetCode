import org.example.InsertInterval
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class InsertIntervalTest {
    val insertInterval = InsertInterval()

    //1.
    @Test
    fun shouldSolveForBothBefore() {
        val intervals = arrayOf(intArrayOf(3, 7), intArrayOf(10, 15))
        val newInterval = intArrayOf(1, 2)
        val expectedOutput = arrayOf(intArrayOf(1, 2), intArrayOf(3, 7), intArrayOf(10, 15))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }

    //2.
    @Test
    fun shouldSolveForStartBeforeEndWithin() {
        val intervals = arrayOf(intArrayOf(3, 7), intArrayOf(10, 15))
        val newInterval = intArrayOf(1, 4)
        val expectedOutput = arrayOf(intArrayOf(1, 7), intArrayOf(10, 15))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }

    //3.
    @Test
    fun shouldSolveForBothWithin() {
        val intervals = arrayOf(intArrayOf(1, 5))
        val newInterval = intArrayOf(2, 3)
        val expectedOutput = arrayOf(intArrayOf(1, 5))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }

    //3. single use case
    @Test
    fun shouldSolveForSingleWithinBoth() {
        val intervals = arrayOf(intArrayOf(1, 5))
        val newInterval = intArrayOf(2, 3)
        val expectedOutput = arrayOf(intArrayOf(1, 5))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }

    // 4.
    @Test
    fun shouldSolveForCaseStartWithinEndBetween() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(6, 9))
        val newInterval = intArrayOf(2, 5)
        val expectedOutput = arrayOf(intArrayOf(1, 5), intArrayOf(6, 9))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])

    }

    //    5.
    @Test
    fun shouldSolveForStartBetweenEndBetween() {
        val intervals =
            arrayOf(intArrayOf(1, 3), intArrayOf(6, 9))
        val newInterval = intArrayOf(4, 5)
        val expectedOutput = arrayOf(intArrayOf(1, 3), intArrayOf(4, 5), intArrayOf(6, 9))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
        assertContentEquals(expectedOutput[2], result[2])
    }

    //6.
    @Test
    fun shouldSolveForStartWithinEndWithinLatter() {
        val intervals =
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
        val newInterval = intArrayOf(4, 8)

        val expectedOutput = arrayOf(intArrayOf(1, 2), intArrayOf(3, 10), intArrayOf(12, 16))

        val result = insertInterval.insert(intervals, newInterval)
        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
        assertContentEquals(expectedOutput[2], result[2])
    }

    //7.
    @Test
    fun shouldSolveForStartBetweenEndWithin() {
        val intervals =
            arrayOf(intArrayOf(1, 3), intArrayOf(4, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
        val newInterval = intArrayOf(2, 8)

        val expectedOutput = arrayOf(intArrayOf(1, 10), intArrayOf(12, 16))

        val result = insertInterval.insert(intervals, newInterval)
        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
    }

    //7.
    @Test
    fun shouldSolveForStartBetweenEndOutside() {
        val intervals =
            arrayOf(intArrayOf(1, 3), intArrayOf(4, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
        val newInterval = intArrayOf(2, 17)

        val expectedOutput = arrayOf(intArrayOf(1, 17))

        val result = insertInterval.insert(intervals, newInterval)
        assertContentEquals(expectedOutput[0], result[0])
    }


    //9.
    @Test
    fun shouldSolveForStartWithinEndOutside() {
        val intervals = arrayOf(intArrayOf(1, 5))
        val newInterval = intArrayOf(2, 7)
        val expectedOutput = arrayOf(intArrayOf(1, 7))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }


    //10.
    @Test
    fun shouldSolveForBothAfter() {
        val intervals = arrayOf(intArrayOf(1, 5))
        val newInterval = intArrayOf(6, 8)
        val expectedOutput = arrayOf(intArrayOf(1, 5), intArrayOf(6, 8))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }

    //11
    @Test
    fun shouldSolveForStartOutsideBeforeEndOutsideAfter() {
        val intervals = arrayOf(intArrayOf(2, 5))
        val newInterval = intArrayOf(1, 7)
        val expectedOutput = arrayOf(intArrayOf(1, 7))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])
    }


    // Edge cases:

    @Test
    fun shouldSolveForEmptyStartInterval() {
        val intervals = arrayOf(intArrayOf())
        val newInterval = intArrayOf(5, 7)
        val expectedOutput = arrayOf(intArrayOf(5, 7))

        val result = insertInterval.insert(intervals, newInterval)

        assertContentEquals(expectedOutput[0], result[0])

    }
}