import org.example.Solution
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BadVersionAPITest{

    @Test
    fun isBadVersionFive() {
        val badVersionAPI = Solution()

        assertEquals(4,badVersionAPI.firstBadVersion(5))
    }
    @Test
    fun isBadVersionOne() {
        val badVersionAPI = Solution().apply {
            setBadVersion(1)
        }

        assertEquals(1,badVersionAPI.firstBadVersion(1))
    }
    @Test
    fun isBadVersionTwo() {
        val badVersionAPI = Solution().apply {
            setBadVersion(2)
        }

        assertEquals(2,badVersionAPI.firstBadVersion(2))
    }
    @Test
    fun isBadVersionThree() {
        val badVersionAPI = Solution().apply {
            setBadVersion(3)
        }

        assertEquals(3,badVersionAPI.firstBadVersion(3))
    }
    @Test
    fun isBadInput() {
        val badVersionAPI = Solution().apply {
            setBadVersion(10)
        }

        assertEquals(-1,badVersionAPI.firstBadVersion(4))
    }
    @Test
    fun isBadVersionFour() {
        val badVersionAPI = Solution().apply {
            setBadVersion(1)
        }

        assertEquals(1,badVersionAPI.firstBadVersion(4))
    }

}