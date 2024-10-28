package org.example

/***
 *
 * 3Sum

 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 *
 */
class SumOfThrees {
    /**
     * Time limit exceeded obvs, as n^3
     */
    fun threeSumSlow(nums: IntArray): List<List<Int>> {
        return buildSet<List<Int>> {
            for (i in 0..nums.lastIndex - 2) {
                for (j in 1..nums.lastIndex - 1) {
                    for (k in 2..nums.lastIndex) {
                        if (nums[i] + nums[j] + nums[k] == 0 && i != j && i != k && j != k) {
                            add(listOf(nums[i], nums[j], nums[k]).sorted())
                        }
                    }
                }
            }
        }.toList()
    }

    //Instead, we can sort the set.
    // And use two pointers
    // for each element, take i+1 and lastIndex
    // And move either way if result is > 0 or <0
    // Otherwise if they equal add to set, and move both along to avoid duplicates and unecessary work
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort() // sorts in place
        return buildSet<List<Int>> {
            for (i in 0..nums.lastIndex) {
                var current = i+1
                var last = nums.lastIndex

                while(last > current) {
                    val threeSum = nums[i] + nums[current] + nums[last]
                    when {
                        threeSum == 0 -> {
                            add(listOf(nums[i],nums[current],nums[last]))
                            // Move both pointers, as to we know we don't want duplicates within the set
                            // And if nums[i]+nums[j] are equal, we know we'll need the same nums[k]
                            // So no point and may as well move both..
                            last--
                            current++
                        }
                        threeSum > 0 -> last--
                        threeSum < 0 -> current++
                    }
                }
            }
        }.toList()
    }
}