import intervals.Intervals
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntervalsTest {
    val intervals = Intervals()

    @Test
    fun shouldBeAbleToAttendIntervalsEx1() {
        val input = listOf(listOf(10, 12), listOf(6, 9), listOf(13, 15))

        assertEquals(true, intervals.canAttendAllMeetings(input))

    }

    @Test
    fun shouldNotBeAbleToAttendIntervalsEx1() {
        val input = listOf(listOf(1, 5), listOf(3, 9), listOf(6, 8))

        assertEquals(false, intervals.canAttendAllMeetings(input))

    }
    @Test
    fun shouldInsertInterval(){
        val intervalList = listOf(listOf(1,3), listOf(6,9))
        val newInterval = mutableListOf(2,5)

        val expectedOutput = listOf(listOf(1,5), listOf(6,9))

        assertEquals(expectedOutput, intervals.insertInterval(intervalList, newInterval))
    }
}