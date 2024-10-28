import org.example.SumOfThrees
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.test.assertEquals

class SumOfThreesTest{
    val sumOfThrees = SumOfThrees()

    @Test
    fun solveExampleOne() {
        val input = intArrayOf(-1,0,1,2,-1,-4)
        val expectedOutput = listOf(listOf(-1,-1,2), listOf(-1,0,1))


        assertEquals(expectedOutput, sumOfThrees.threeSum(input))

    }

    @Test
    fun solveExampleNoSolution() {
        val input = intArrayOf(0,1,1)
        val expectedOutput = emptyList<List<Int>>()
        assertEquals(expectedOutput, sumOfThrees.threeSum(input))
    }

    @Test
    fun solveExampleTwo() {
        val input = intArrayOf(0, 0 ,0)
        val expectedOutput = listOf(listOf(0,0,0))

        assertEquals(expectedOutput, sumOfThrees.threeSum(input))

    }
    @Test
    fun solveExampleThree() {
        val input = intArrayOf(3,0,-2,-1,1,2)
        val expectedOutput = listOf(listOf(-2,-1,3), listOf(-2,0,2), listOf(-1,0,1))

        assertEquals(expectedOutput, sumOfThrees.threeSum(input))

    }
}