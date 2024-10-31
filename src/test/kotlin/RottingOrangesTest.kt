import org.example.RottingOranges
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RottingOrangesTest {
    val rottingOranges = RottingOranges()

    @Test
    fun shouldReturn4ForCase1() {
        val grid = arrayOf(intArrayOf(2,1,1), intArrayOf(1,1,0), intArrayOf(0,1,1))

        assertEquals(4, rottingOranges.orangesRotting(grid))
    }

    @Test
    fun shouldReturnMinus1ForNotPossibleCase() {
        val grid = arrayOf(intArrayOf(2,1,1), intArrayOf(0,1,1), intArrayOf(1,0,1))

        assertEquals(-1, rottingOranges.orangesRotting(grid))
    }

    @Test
    fun shouldReturn0ForNoFreshOrangesAtMinute0() {
        val grid = arrayOf(intArrayOf(0,2))

        assertEquals(0, rottingOranges.orangesRotting(grid))
    }

}