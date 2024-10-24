package org.example

import java.math.BigInteger

/**
 *  Maximum Subarray
 * Medium
 * Topics
 * Companies
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *
 */
class MaximumSubArray {

    //Time Limit Exceeded
    //200 / 210 testcases passed
    // Fair given it's O(n^3)
    fun maxSubArrayWindowed(nums: IntArray): Int {
        var largestSum = Int.MIN_VALUE
        if(nums.size == 1) return nums[0]

        for(i in 1..nums.size) {
            // Creating window sizes starting from 1, across the array, until a window size of the entire
            val windowedLists: List<List<Int>> = nums.toList().windowed(i)

            // For each of the windowedLists, calculate the sum, and store max of those in largest sum.
            windowedLists.forEach {
                largestSum = maxOf(largestSum, it.sum())
            }
        }

        return largestSum

    }
    // Aim is to iterate through entire array, keeping currentValue and largestSum
    // add each number to current value, to keep a running total.
    // If we ever reach below zero, we may as well reset the window looking and abadon that subarray
    // And instead restart at 0, at the next window.
    // Whilst keeping the largest ever sum starting at index = 0, until we hit a current value less than 0.
    // Then we reset continuing to add and looking for newest largest sum.
    fun maxSubArrayValue(nums: IntArray): Int {
        var largestSum = Int.MIN_VALUE
        var current = 0

        nums.forEach {
            current += it

            largestSum = maxOf(current, largestSum)

            if(current < 0){
                current = 0
            }
        }

        return largestSum

    }
}