import org.example.RunningSums
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.test.assertContentEquals

class RunningSumsTest {
    private val runningSums = RunningSums()

    @Test
    fun shouldCalcRunningSumsExample1() {
        val inputIntArray = intArrayOf(1,2,3,4)
        val expectedIntArray = intArrayOf(1,3,6,10)
        assertContentEquals(runningSums.calculateRunningSums(inputIntArray), expectedIntArray)
    }

    @Test
    fun shouldCalcRunningSumsExample2() {
        val inputIntArray = intArrayOf(1,1,1,1,1)
        val expectedIntArray = intArrayOf(1,2,3,4,5)
        assertContentEquals(runningSums.calculateRunningSums(inputIntArray), expectedIntArray)
    }

    @Test
    fun shouldCalcRunningSumsExample3() {
        val inputIntArray = intArrayOf(3,1,2,10,1)
        val expectedIntArray = intArrayOf(3,4,6,16,17)
        assertContentEquals(runningSums.calculateRunningSums(inputIntArray), expectedIntArray)
    }

}
