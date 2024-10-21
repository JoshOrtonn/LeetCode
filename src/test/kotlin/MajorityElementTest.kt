import org.example.MajorityElement
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MajorityElementTest{
    val majorityElement = MajorityElement()

    //Input: nums = [3,2,3]
    //Output: 3
    //Example 2:
    //
    //Input: nums = [2,2,1,1,1,2,2]
    //Output: 2
    //
    @Test
    fun shouldSolveForSimpleCase() {
        val nums = intArrayOf(3,2,3)
        assertEquals(3, majorityElement.solve(nums))

    }

    @Test
    fun shouldSolveForComplexCase(){
        val nums = intArrayOf(2,2,1,1,1,2,2)
        assertEquals(2, majorityElement.solve(nums))

    }

    @Test
    fun shouldSolveForMemorySimpleCase() {
        val nums = intArrayOf(3,2,3)
        assertEquals(3, majorityElement.solveForMemory(nums))

    }

    @Test
    fun shouldSolveForMemoryComplexCase(){
        val nums = intArrayOf(2,2,1,1,1,2,2)
        assertEquals(2, majorityElement.solveForMemory(nums))

    }

    @Test
    fun shouldSolveForMemorySimpleCaseV2() {
        val nums = intArrayOf(3,2,3)
        assertEquals(3, majorityElement.solveForMemoryV2(nums))

    }

    @Test
    fun shouldSolveForMemoryComplexCaseV2(){
        val nums = intArrayOf(2,2,1,1,1,2,2)
        assertEquals(2, majorityElement.solveForMemoryV2(nums))

    }

}