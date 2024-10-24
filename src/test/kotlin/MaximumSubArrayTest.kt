import org.example.MaximumSubArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumSubArrayTest {
    val maximumSubArray = MaximumSubArray()

    @Test
    fun shouldEqual6ForWindowedEffort() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        assertEquals(6, maximumSubArray.maxSubArrayWindowed(nums))
    }

    @Test
    fun shouldEqual1ForEdgeCaseWindowedEffort() {
        val nums = intArrayOf(1)
        assertEquals(1, maximumSubArray.maxSubArrayWindowed(nums))
    }

    @Test
    fun shouldEqual23ForWindowedEffort() {
        val nums = intArrayOf(5,4,-1,7,8)
        assertEquals(23, maximumSubArray.maxSubArrayWindowed(nums))
    }

    @Test
    fun shouldEqualMinus1ForWindowedEffort() {
        val nums = intArrayOf(-2, -1)
        assertEquals(-1, maximumSubArray.maxSubArrayWindowed(nums))
    }

    @Test
    fun shouldEqual6ForRunningTotalValueResetAtNegative() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        assertEquals(6, maximumSubArray.maxSubArrayValue(nums))
    }

    @Test
    fun shouldEqual1ForEdgeCaseRunningTotalValueResetAtNegative() {
        val nums = intArrayOf(1)
        assertEquals(1, maximumSubArray.maxSubArrayValue(nums))
    }

    @Test
    fun shouldEqual23ForRunningTotalValueResetAtNegative() {
        val nums = intArrayOf(5,4,-1,7,8)
        assertEquals(23, maximumSubArray.maxSubArrayValue(nums))
    }

    @Test
    fun shouldEqualMinus1ForRunningTotalValueResetAtNegative() {
        val nums = intArrayOf(-2, -1)
        assertEquals(-1, maximumSubArray.maxSubArrayValue(nums))
    }

}