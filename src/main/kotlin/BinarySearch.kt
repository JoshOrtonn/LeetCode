package org.example

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * Write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 */

/***
 * // Write a binary search, which basically oscillates around the final number
 *         // Halving the set each time.
 *         // Set a mid point
 *         // if more than update mid point to be midway through right hand side
 *         // if less than update mid point to be midway through left
 *         // Sorta thing
 * **In this problem we want to find the first index of the array that is equal to the expected target.
 * If none found, then return -1**
 *
 * Naive algorithm is to loop through entire array checking for when value is 1.
 * This has a runtime of O(n) given worst case we're gonna have to loop through entire array.
 * But we can do better: Optimising with Binary Search
 *
 * We start with two pointers, called low and hi, which repesent the lowest and highest number that a possible answer could be.
 * In this case, lowest is index 0, and highest is index arraySize -1.
 * `lo = 0` and `hi = arraySize -1`
 *
 * We're gonna explicit-ally check if the first index in array is equal to the target, and return that.
 * Or if the last index is equal to 0 and return -1,
 *
 * Making it even more best case effiencent.
 * In each iteration of binary search, we'll try to halve our search space,
 *
 * Taking midpoint between lo and high `((lo+high)/2)` , and depending on whether the value is 0 or 1, update either lo or hi to the midpoint.
 */

class BinarySearch {
    fun binarySearch(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.lastIndex
        // Edge case for small arrays, whereby high <= low+1
        if(nums[low] == target) return low
        if(nums[high] == target) return high

        // While high is greater than low + 1
        // Essentially ensure that if it goes consecutively
        // Low, Mid, High indexes 1,1,2 we can come out of this as we've narrowed it down to as small a search space
        // And still not found our match.
        while (high > low + 1) {
            val mid = (high + low) / 2
            if(nums[mid] == target) {
                return mid
            } else if(nums[mid] > target) {
                high = mid
            } else {
                // nums[mid] < target
                low = mid
            }
        }

        return -1
    }

}