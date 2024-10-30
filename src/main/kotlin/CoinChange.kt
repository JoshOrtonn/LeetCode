package org.example

/**
 * Coin Change
 * Medium
 * Topics
 * Companies
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *  Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 *
 */


class CoinChange {

    fun fewestNumberOfCoinsTimeExceeded(coins: IntArray, amount: Int): Int {
        if(amount == 0) return 0

        var fewestCoins = Int.MAX_VALUE
        // From currentAmount to number of steps
        val queue = ArrayDeque<Pair<Int, Int>>()
        // Add last, the first total amount, and starting count of steps to 0
        queue.addLast(amount to 0)

        val amountToSteps = hashMapOf<Int, Int>()

        while (queue.isNotEmpty()) {
            val (value, prevSteps) = queue.removeFirst()
            // Calculate nextValues, and add them to the queue:
            coins.forEach {
                val nextValue = value - it
                val stepCount = prevSteps + 1
                if (nextValue > 0) {
                    // if we have already counted the value, we know how many more it is.
                    if(amountToSteps.get(nextValue) == null) {
                        queue.addLast(nextValue to stepCount)
                    }
                } else if (nextValue == 0) {
                    fewestCoins = minOf(stepCount, fewestCoins)
                }
            }
        }


        return when (fewestCoins) {
            Int.MAX_VALUE -> {
                -1
            }

            else -> {
                fewestCoins
            }
        }
    }

    // DP From Bottom UP:
    fun fewestNumberOfCoins(coins: IntArray, amount: Int): Int {
        val amountValueToSteps = hashMapOf<Int, Int>()
        amountValueToSteps[0] = 0
        // Only if a coin of 1 exists, otherwise, not possible..
        for(value in 1..amount){
            var minSteps = Int.MAX_VALUE
            coins.forEach {
                // If there exists a way to get to a previous step
                val stepsToPreviousAmount: Int? = amountValueToSteps[value - it]
                stepsToPreviousAmount?.let {
                    // check if this is a new min way of getting from value to value+coin
                    minSteps = minOf(minSteps, it)
                }
            }

            // Maybe it's not possible to go from every value in 1..amount so only update if possible.
            if(minSteps != Int.MAX_VALUE){
                amountValueToSteps[value] = 1 + minSteps
            }
        }
        return when {
            amountValueToSteps[amount] == null -> {
                -1
            }
            else -> {
                amountValueToSteps[amount]!!
            }
        }
    }
}