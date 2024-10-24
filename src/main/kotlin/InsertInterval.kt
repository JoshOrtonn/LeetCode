package org.example

/**
 * Insert Interval
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
 * the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 *
 *
 *
 */
class InsertInterval {
    // Fast runtime, horribly written...
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var newStartValue = -1
        var newEndValue = -1
        var shouldInsertIntervalBefore = false
        if (intervals.isEmpty() || intervals[0].isEmpty()) {
            return arrayOf(newInterval)
        }

        val newList = mutableListOf<IntArray>()
        // Is newInterval before?
        // [3,5]
        // new interval [1,2]
        // if both start and end less than existing add it.
        // If intervals list contains emptyIntArray, just return newInterval

        // If both start and end of new intervals occurs before intervals, we can prepend it.
        if (intervals[0].first() > newInterval.first() && intervals[0].first() > newInterval.last()) {
            newList.add(newInterval)
            newList.addAll(intervals)
            // Found the new interval we can return the rest.
            return newList.toTypedArray()
        } else if (intervals[0].first() > newInterval.first()) {
            // Start before, end after x
            newStartValue = newInterval.first()
        }


        intervals.forEachIndexed { index, existingInterval ->
            val existingIntervalRange = IntRange(existingInterval.first(), existingInterval.last())

            val previousInterval = if (index - 1 >= 0) {
                intervals[index-1]
            } else null
            if (newInterval.first() in existingIntervalRange && isNotUpdated(newStartValue)) {
                // If new start within
                newStartValue = existingInterval.first()
                // Want to obtain next one.
            } else if (isNotUpdated(newStartValue) && isNewIntervalBetweenIntervals(
                    newInterval.first(),
                    existingInterval,
                    previousInterval
                )
            ) {
                newStartValue = newInterval.first()
            }


            if (newInterval.last() in existingIntervalRange && isNotUpdated(newEndValue)) {
                newEndValue = existingInterval.last()
            } else if (isNotUpdated(newEndValue) && isNewIntervalBetweenIntervals(
                    newInterval.last(),
                    existingInterval,
                    previousInterval
                )
            ) {
                newEndValue = newInterval.last()
                shouldInsertIntervalBefore = true
            }


                 // Append, if both updated and return
                if (isUpdated(newStartValue) && isUpdated(newEndValue)) {
                    newList.add(intArrayOf(newStartValue, newEndValue))
                    // Add rest of intervals here
                    // If we updated the end value just before this, we want to ensure we also
                    // add the current interval too.
                    if(shouldInsertIntervalBefore) {
                        newList.addAll(intervals.filterIndexed { indexOfArray, _ -> indexOfArray >= index  })
                    } else {
                        // if not then we can skip adding this one again as we probably just calculated it.
                        newList.addAll(intervals.filterIndexed { indexOfArray, _ -> indexOfArray > index  })
                    }

                    // can return here? probably
                    return newList.toTypedArray()

                } else if (isNotUpdated(newStartValue) && isNotUpdated(newEndValue)) {
                    // if both not updated, and reached end of iteration,
                    // we can safely put this on the list I think..
                    // AS in start not found
                    newList.add(existingInterval)
                }
        }


        // Start been found within, but end has not.
        if (isUpdated(newStartValue) && isNotUpdated(newEndValue)) {
            newList.add(intArrayOf(newStartValue, newInterval.last()))
            //Both not found, add both of them
        } else if (isNotUpdated(newStartValue) && isNotUpdated(newEndValue)) {
            newList.add(newInterval)
        }

        return newList.toTypedArray()
    }

    private fun isUpdated(interval: Int) = interval != -1
    private fun isNotUpdated(interval: Int) = interval == -1
    private fun isNewIntervalBetweenIntervals(
        newIntToIntersect: Int,
        existingInterval: IntArray,
        previousInterval: IntArray?
    ) = existingInterval.first() > newIntToIntersect && previousInterval != null && previousInterval.last() < newIntToIntersect
}