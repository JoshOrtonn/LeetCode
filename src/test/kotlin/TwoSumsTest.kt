import org.example.TwoSums
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class TwoSumsTest{
    private val twoSums = TwoSums()

    @Test
    fun assertSolveIsCorrectForExample1() {
        val nums = intArrayOf(2,7,11,15)
        val target = 9

        val expectedOutcome = intArrayOf(0, 1)
        assertContentEquals(twoSums.solve(nums, target), expectedOutcome)
    }

    @Test
    fun assertSolveIsCorrectForExample2() {
        val nums = intArrayOf(3,2,4)
        val target = 6

        val expectedOutcome = intArrayOf(1, 2)
        assertContentEquals(twoSums.solve(nums, target), expectedOutcome)
    }

    @Test
    fun assertSolveIsCorrectForExample3() {
        val nums = intArrayOf(3, 3)
        val target = 6

        val expectedOutcome = intArrayOf(0, 1)
        assertContentEquals(twoSums.solve(nums, target), expectedOutcome)
    }

    @Test
    fun assertSolveIsCorrectForExample4() {
        val nums = intArrayOf(0, 4, 3, 0)
        val target = 0

        val expectedOutcome = intArrayOf(0, 3)
        assertContentEquals(twoSums.solve(nums, target), expectedOutcome)
    }
}