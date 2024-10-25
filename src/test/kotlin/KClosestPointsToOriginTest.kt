import org.example.KClosestPointsToOrigin
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class KClosestPointsToOriginTest {
    val kClosestPointsToOrigin = KClosestPointsToOrigin()

    /**
     * Explanation:
     *  * The distance between (1, 3) and the origin is sqrt(10).
     *  * The distance between (-2, 2) and the origin is sqrt(8).
     *  * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     *  * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
     *  *
     */
    @Test
    fun shouldReturnExpectedClosestPointsEx1List() {

        val input = arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2))
        val k = 1

        val expectedOutcome = arrayOf(intArrayOf(-2, 2))

        val result = kClosestPointsToOrigin.kClosest(input, k)

        assertContentEquals(expectedOutcome[0], result[0])
    }

    //        Example 2:
//
//        * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//        * Output: [[3,3],[-2,4]]
//        * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
//        *
    @Test
    fun shouldReturnExpectedClosestPointsEx2List() {
        val input = arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4))
        val k = 2

        val expectedOutcome = arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4))
        val result = kClosestPointsToOrigin.kClosest(input, k)

        assertContentEquals(expectedOutcome[0], result[0])
        assertContentEquals(expectedOutcome[1], result[1])
    }

    @Test
    fun shouldReturnExpectedClosestPointsEx1PriorityQueue() {

        val input = arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2))
        val k = 1

        val expectedOutcome = arrayOf(intArrayOf(-2, 2))

        val result = kClosestPointsToOrigin.kClosestPriorityQueue(input, k)

        assertContentEquals(expectedOutcome[0], result[0])
    }

    @Test
    fun shouldReturnExpectedClosestPointsEx2PriorityQueue() {
        val input = arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4))
        val k = 2

        val expectedOutcome = arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4))
        val result = kClosestPointsToOrigin.kClosestPriorityQueue(input, k)

        assertContentEquals(expectedOutcome[0], result[0])
        assertContentEquals(expectedOutcome[1], result[1])
    }
    @Test
    fun shouldReturnExpectedClosestPointsEx1OneLiner() {

        val input = arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2))
        val k = 1

        val expectedOutcome = arrayOf(intArrayOf(-2, 2))

        val result = kClosestPointsToOrigin.kClosestOneLiner(input, k)

        assertContentEquals(expectedOutcome[0], result[0])
    }

    @Test
    fun shouldReturnExpectedClosestPointsEx2OneLiner() {
        val input = arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4))
        val k = 2

        val expectedOutcome = arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4))
        val result = kClosestPointsToOrigin.kClosestOneLiner(input, k)

        assertContentEquals(expectedOutcome[0], result[0])
        assertContentEquals(expectedOutcome[1], result[1])
    }

}