package org.example

import java.util.PriorityQueue
import java.util.SortedMap

/***
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is
 * the Euclidean distance i.e., √((x1 - x2)^2 + (y1 - y2)^2)
 *
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 *
 * Constraints:
 *
 * 1 <= k <= points.length <= 104
 * -104 <= xi, yi <= 104
 *
 *
 *
 */

class KClosestPointsToOrigin {
    // Fast runtime, but slow memory as essentially creates a List of n points
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        return buildList {
            points.forEach {
                // We can skip out the square root as essentially all relative given ints only provided
                // If it was between 0 and 1, then the square root would be needed.
                val distance = (it[0] * it[0]) + (it[1] * it[1])
                add(Pair(it[0] to it[1], distance))
            }
        }.sortedBy { it.second }.take(k).map { intArrayOf(it.first.first, it.first.second) }.toTypedArray()
    }

    // Slightly faster, still slow on memory
    // But interesting data structure to use.
    fun kClosestPriorityQueue(points: Array<IntArray>, k: Int): Array<IntArray> {
        val priorityQueue = PriorityQueue<Pair<Pair<Int, Int>, Int>>(compareBy { it.second })

        points.forEach {
            // We can skip out the square root as essentially all relative given ints only provided
            // If it was between 0 and 1, then the square root would be needed.
            val distance = (it[0] * it[0]) + (it[1] * it[1])
            priorityQueue.offer(Pair(it[0] to it[1], distance))
        }

        // Remmeber the priorityQueue isn't sorted, until it's asked for the first item from the queue
        // At that point the butcher counter is asking, who is ticket number one, and the first person stands up.

        val otherSortedOutput = priorityQueue.take(2)
        val sortedOutput = buildList<IntArray> {
            repeat(k){
                val item = priorityQueue.poll()
                add(intArrayOf(item.first.first, item.first.second))
            }
        }


        return sortedOutput.toTypedArray()
    }

    // Best for both, actually. lol
    fun kClosestOneLiner(points: Array<IntArray>, k: Int): Array<IntArray> {
        return points.sortedBy { (it[0] * it[0] + it[1] * it[1]) }.take(k).toTypedArray()
    }
}