package org.example

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
class MergeIntervals {
    // Insert first to array
    // Keep a min and Max interval of the first
    // Compare max interval to next interval's first, if it's bigger
    // Then we kinda swallow up the next interval within the already created one
    // Meaning min remains, but new max as next interval
    // Continue this process until we find one that's not in the interval
    // Then we just add itself to the list, and update new min and max
    // And continue to check next interval against previous max values
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // Should sort first.
       val sortedIntervals = intervals.sortedBy { it.first() }

        val outputIntervals = buildList<IntArray> {
            var minInterval = sortedIntervals[0].first()
            var maxInterval = sortedIntervals[0].last()
            sortedIntervals.forEachIndexed { index, interval ->
                if(interval.first() <= maxInterval && index !=0) {
                    maxInterval = maxOf(interval.last(), maxInterval)

                    //Remove previous interval, maybe it should be insert
                    removeAt(size-1)
                    add(intArrayOf(minInterval, maxInterval))
                } else {
                    add(interval)
                    // Update min and max interval values as previous no longer has potential overlap
                    // And needs to be compared against most recent interval
                    minInterval = maxOf(minInterval, interval.first())
                    maxInterval = maxOf(maxInterval, interval.last())
                }
            }
        }
        return outputIntervals.toTypedArray()
    }
}
