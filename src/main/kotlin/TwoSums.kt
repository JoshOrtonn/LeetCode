package org.example

/*
1. Two Sum Easy
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Indices (placement in array) of TWO numbers such that they add to target
One solution, so can go in order from 0...n (but may be best to optimise based on sorting, and then only looking from when values is less than target)

 */
class TwoSums {
    fun solve(nums: IntArray, target: Int): IntArray {
        // Input [2, 7] Target 9
        // Input [3, 2, 4] Target 6
        // Input [3, 3] Target 6

        // 2.. 2+7
        // 3.. 3+2, 3+4.. 2.. 2+4
        // 3.. 3+3
        for(i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return intArrayOf()
    }
}