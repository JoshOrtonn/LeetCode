import org.example.BinarySearch
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinarySearchTest{
    val binarySearch = BinarySearch()

    @Test
    fun isTargetWithinNums() {
        val nums = intArrayOf(-1,0,3,5,9,12)
        val target = 9
        assertEquals(4, binarySearch.binarySearch(nums, target))
    }
    @Test
    fun isTargetNotWithinNums() {
        val nums = intArrayOf(-1,0,3,5,9,12)
        val target = 2
        assertEquals(-1, binarySearch.binarySearch(nums, target))
    }

    @Test
    fun isTargetWithinNumsAdapted3() {
        val nums = intArrayOf(5)
        val target = 5
        assertEquals(0, binarySearch.binarySearch(nums, target))
    }
    @Test
    fun isTargetWithinNumsAdapted4() {
        val nums = intArrayOf(-1,0,3,5,9,12)
        val target = 5
        assertEquals(0, binarySearch.binarySearch(nums, target))
    }
}