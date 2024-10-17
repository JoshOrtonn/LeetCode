package org.example

/**
 * 121. Best Time to Buy and Sell Stock
 * Easy
 *
 * You are given an array `prices` where `prices[i]` is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 *
 * and then choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 *
 * If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Sliding window, looking for biggest difference from day x against rest of array
 * Start at 7, look at rest of array minusing 7 from rest of digits, 0 found
 * Then look at next element 1, minusing it against rest of digits, and store max profit.
 * Continue with next element 5, minusing it against rest of digits and compare to max profit, if larger overwrite.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 *
 *
 */
class MaxProfitSellingStock {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0

        // Create windowed list for each element showing rest of elements.
        // Then need to find max of two elements in list
        // So could sort them, take first and last and minus them
        val diffPrices: List<List<Int>> = prices.toList().windowed(prices.size, partialWindows = true)

        diffPrices.forEach { windowedList ->
            val firstElement = windowedList.first()
            windowedList.forEach {
                val diffInList = it - firstElement
                if(diffInList > maxProfit) {
                    maxProfit = diffInList
                }
            }
        }

        return maxProfit
        // Works but memory created is large!!
        // Given n^2
        // Whereby IntArray is turned into IntArray^2
    }

    // Time limit exceeded
    fun maxProfitMemoryOptimised(prices: IntArray): Int {
        var biggestDiff = 0
        for(i in 0..prices.lastIndex){
            for(j in i+1..prices.lastIndex){
               val diff = prices[j] - prices[i]
                if(diff > biggestDiff) biggestDiff = diff
            }
        }
        return biggestDiff
    }

    // Keep running track of min value two pointers essentially
    // Iterate through array, first determine if current value is min, then minus min from current value.
    fun maxProfitTimeOptimised(prices: IntArray): Int {
        var minPrice = prices[0]
        var profit = 0
        prices.forEach { currentPrice: Int ->
            if (minPrice > currentPrice) minPrice = currentPrice
            profit = maxOf(profit, currentPrice - minPrice)
        }
        return profit
    }
    /*
            Input: prices = [7,1,5,3,6,4]
            7 is min Price
            currentPrice is 7
            profit = maxOf(0, 7-7)
            1 is currentPrice
            minPrice > currentPrice so overwrite minPrice as new currentPrice
            profit = maxOf(0, 1-1)
            -
            5 is currentPrice
            1 is not bigger than 5 so 1 remains min price
            profit = maxOf(0, 5-1) hence 4
            minPrice remains as 1
            iterate to next input 3 but not maxProfit
            ...\
            iterate to next currentValue 6
            1 still min
            6-1 is new max profit
     */
}