import org.example.MaxProfitSellingStock
import org.junit.jupiter.api.Test

class maxProfitSellingStockTest{
    val maxProfitSellingStock = MaxProfitSellingStock()

    @Test
    fun isMaxProfitExample1() {
        val input = intArrayOf(7,1,5,3,6,4)
        kotlin.test.assertEquals(5, maxProfitSellingStock.maxProfit(input))
    }

    @Test
    fun isMaxProfitExample2() {
        val input = intArrayOf(7,6,4,3,1)
        kotlin.test.assertEquals(0, maxProfitSellingStock.maxProfit(input))
    }

    @Test
    fun isMaxProfitMemoryOptimisedExample1() {
        val input = intArrayOf(7,1,5,3,6,4)
        kotlin.test.assertEquals(5, maxProfitSellingStock.maxProfitMemoryOptimised(input))
    }

    @Test
    fun isMaxProfitMemoryOptimisedExample2() {
        val input = intArrayOf(7,6,4,3,1)
        kotlin.test.assertEquals(0, maxProfitSellingStock.maxProfitMemoryOptimised(input))
    }
    @Test
    fun isMaxProfitTimeAndMemoryOptimisedExample1() {
        val input = intArrayOf(7,1,5,3,6,4)
        kotlin.test.assertEquals(5, maxProfitSellingStock.maxProfitTimeOptimised(input))
    }

    @Test
    fun isMaxProfitTimeAndMemoryOptimisedExample2() {
        val input = intArrayOf(7,6,4,3,1)
        kotlin.test.assertEquals(0, maxProfitSellingStock.maxProfitTimeOptimised(input))
    }
    @Test
    fun isMaxProfitTimeAndMemoryOptimisedExample3() {
        val input = intArrayOf(7,2,9,1,7,1)
        kotlin.test.assertEquals(7, maxProfitSellingStock.maxProfitTimeOptimised(input))
    }
}