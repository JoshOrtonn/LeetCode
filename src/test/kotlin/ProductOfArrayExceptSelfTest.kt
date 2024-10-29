import org.example.ProductOfArrayExceptSelf
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ProductOfArrayExceptSelfTest {
    val productOfArrayExceptSelf = ProductOfArrayExceptSelf()

    @Test
    fun shouldSolveProductForEx1() {
        val nums = intArrayOf(1, 2, 3, 4)

        val expectedOutput = intArrayOf(24, 12, 8, 6)
        assertContentEquals(expectedOutput, productOfArrayExceptSelf.solve(nums))
    }

    @Test
    fun shouldSolveProductForEx2() {
        val nums = intArrayOf(-1, 1, 0, -3, 3)

        val expectedOutput = intArrayOf(0, 0, 9, 0, 0)
        assertContentEquals(expectedOutput, productOfArrayExceptSelf.solve(nums))
    }
}