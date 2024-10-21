package org.example

/*****
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 * 1 <= n <= 45
 *
 *
 *                      4
 *                   3      2
 *                2    1  1   0
 *               1 0  0  0
 *              0
 * n-1 down left fully hand side
 * going right on the n-2 essentially
 * n = 4, output is 5 leaf nodes
 * So by returning 1 as base case when n < 2, we've reached point of only one or no more steps left
 * so return that.
 * like n-2 all the way down is right hand side
 *
 */
class ClimbStairs {
//    However time exceeds this solution so we need to use DP
    // Dynamic Programming / memoization.
    // Given we could down from certain number, so after one
    fun climbStairs(n: Int): Int {
        // How many distinct ways can you climb stairs.

        // either climb 1 stair or two stairs
        // Drew it out like a graph, which could be considered like a call stack.
        // Each choice we can climb 1 or 2.
        // And can see this recursively.
        // Climb (1) or (2)
        // Maybe counting down rather than up, but still
        // (n-1) or (n-2)

        if(n < 2) return 1 // Base case so we know only one step down when less than 2

        // Should count the number of steps from 5 down to zero, if we just minus one.
        // so really this should be 5
        // But we want to care about number of times we hit zero essentially
        // Which means climbStairs minues one down left hand side graph basically
        return climbStairs(n-1) + climbStairs(n-2)
    }

    fun climbStairsMemoized(n: Int): Int {
        val hashMap = mutableMapOf<Int, Int>()
        return climbStairsHelper(n, hashMap)
    }

    // Add helper function so we can pass hashmap through, but still use recursion
    fun climbStairsHelper(n: Int, hashMap: MutableMap<Int, Int>): Int {
        // Same base case as above
        if(n < 2) return 1

        // Try to obtain hashMap of n, and return it if present
        // otherwise populate it using same recursion method
        // And memoization, once it hits the first left hand side, it will be valueable.
        if(hashMap[n] == null){
            hashMap[n] = (climbStairsHelper(n-1, hashMap)
                    + climbStairsHelper(n-2, hashMap))
        }


        return hashMap[n]!!
    }
}