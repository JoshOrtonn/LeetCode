package org.example


/**
 * Product of Array Except Self

 * Given an integer array nums, return an array answer such that answer[i] is equal
 * to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 *  Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */


// Given we can't use division, we need to try and find some way of doing this
// n^2 approach would be nums[i] = nums[0] * nums[1]...nums[m] ignoring
// perhaps through subtracting the array which has the product of everything else by itself x times
// What's x tho idiot.!
// Or Using some hashmap to calc nums[4] == nums[2] * nums[2]
// But tricky to do so..

// Some hints needed but seems like we can create two more arrays
// One for postfix product and one for prefix of current number i.
// Whereby postfix product is the running product starting at n multiplied continously down to 0
// And prefix product is the running product of all numbers starting at 0, up to n.
// Which would be O(n) + O(n) which is just O(n) linear
// Then we would iterate through nums, and at i, we do the product of prefix i-1 * postfix i+1
// for the product except self.
// But also is O(n) memory too.
class ProductOfArrayExceptSelf {
    fun solve(nums: IntArray): IntArray {
        val prefix: List<Int> = nums.runningReduce { acc, i -> acc * i }
        val postFix = nums.reversed().runningReduce { acc, i -> acc * i }.reversed()

        return buildList {
            nums.forEachIndexed { index, _ ->
                val prefixValue = when (index) {
                    0 -> 1
                    else -> prefix[index - 1]
                }

                val postFixValue = when {
                    index < postFix.lastIndex -> postFix[index + 1]
                    else -> 1
                }

                add(index, prefixValue * postFixValue)
            }
        }.toIntArray()
    }
}