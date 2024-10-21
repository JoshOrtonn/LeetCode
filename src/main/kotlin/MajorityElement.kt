package org.example

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 */

// First instinct is to create hashmap of occurences, take max.
// Given we can always assume it's present no need to calc if it's greater than n/2
// Good runtime, O(n) but not good for memory optimisation.
class MajorityElement {
    fun solve(nums: IntArray): Int {
        val intOccurencesMap = buildMap<Int, Int> {
            nums.forEach {
                put(it, getOrDefault(it, 0) + 1)
            }
        }
        return intOccurencesMap.maxByOrNull { it.value }!!.key
    }
    // The majority element is the element that appears more than ⌊n / 2⌋ times.
    // Should mean that the middle number would be the one to return as it always is present
    // Still sorting entire nums array
    fun solveForMemory(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size/2]
    }

    //O(N) time, with o(1) space
    fun solveForMemoryV2(nums: IntArray): Int {
        var majorityNumber = 0
        var majorityOccurrences = 0

        // Should add to new number occurrences if present
        // Reset to different number if along the array we hit a point where no majority found
        // The next will become the majority.
        // And reduce the majority difference if another number found
        nums.forEach {
            when {
                majorityOccurrences == 0 -> {
                    majorityNumber = it
                    majorityOccurrences +=1
                }
                it == majorityNumber -> {
                    majorityOccurrences += 1
                }
                else -> {
                    majorityOccurrences -=1
                }
            }
        }

        return majorityNumber
    }
}