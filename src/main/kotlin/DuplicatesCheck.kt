package org.example

/**
 *
 * Contains Duplicate
 * Easy
 * Topics
 * Companies
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: true
 *
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: false
 *
 * Explanation:
 *
 * All elements are distinct.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
class DuplicatesCheck {
    // The hash set data structure provides O(1) time complexity for adding, removing,
    // and checking the presence of an element, making it very efficient for handling large sets of data.

    // TODO figure out if this is correct
    // O(1) for adding and checking, does that make the time complexity O(1) entirely. given O(1) * n
    // O(1) time complexity, and O(n) space.
    fun containsDuplicate(nums: IntArray): Boolean {
        val mutableHashSet = hashSetOf<Int>()
        nums.forEach {
            if(mutableHashSet.contains(it)) return true
            else mutableHashSet.add(it)
        }

        return false


    }
}