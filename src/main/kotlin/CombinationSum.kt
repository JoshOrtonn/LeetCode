package org.example

/***
 * Combination Sum
 * Medium
 * Topics
 * Companies
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 *  Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */

// TODO Clean this up. Improve runtime, perhaps BFS backtracking.
// But really relying on sorting a fair bit increases that time.
class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        // Contains bottom up generated list of Value to possible combinations
        val dynamicProgramming = mutableMapOf<Int, List<List<Int>>>()

        // Hopefully already sorted..
        candidates.sort()
        val startingValue = candidates.first()
        val lastValue = target

        if (lastValue !in candidates) {
            dynamicProgramming.safePut(lastValue, listOf(listOf(lastValue)))
        }

        for (currentDPValue in startingValue..lastValue) {
            // Add itself to the currentDP value
            if (currentDPValue in candidates) {
                dynamicProgramming.safePut(currentDPValue, listOf(listOf(currentDPValue)))
            }
        }

        val keys = dynamicProgramming.keys.toSet()
        for (currentDPValue in startingValue..lastValue) {
            // we are iterating though these keys, yet updating them at teh same time, perhaps we can do this better
            for (preCalculatedValues in keys) {
                // If we can divide it, add the multiples
                if (currentDPValue % preCalculatedValues == 0 && currentDPValue != preCalculatedValues) {
                    val numberOfTimes = currentDPValue / preCalculatedValues

                    val list = mutableListOf<Int>()
                    repeat(numberOfTimes) { list.add(preCalculatedValues) }
                    val divisibleNumber = listOf(buildList<Int> {
                        repeat(numberOfTimes) {
                            add(preCalculatedValues)
                        }
                    })

                    dynamicProgramming.safePut(currentDPValue, divisibleNumber)
                }

                // Else add the combos if currentDPValue =  DP[value-index] +  DP[index]
                for (value in 1..target) {
                    val possSolution1 = dynamicProgramming[currentDPValue - value]
                    val possSolution2 = dynamicProgramming[value]
                    if (!possSolution1.isNullOrEmpty() && !possSolution2.isNullOrEmpty()) {
                        val valueToAdd = buildList<List<Int>> {
                            possSolution1.forEach { poss1 ->
                                possSolution2.forEach { poss2 ->
                                    add(poss2 + poss1)
                                }
                            }
                        }

                        dynamicProgramming.safePut(currentDPValue, valueToAdd)
                    }
                }
            }
        }


        // Hack for now, to remove the incorrectly added 8 for prepopulation
        if (target !in candidates) {
            dynamicProgramming.safeRemove(target)
        }

        return dynamicProgramming.getOrDefault(target, emptyList())
    }

    private fun MutableMap<Int, List<List<Int>>>.safePut(
        currentDPValue: Int,
        valueToAdd: List<List<Int>>
    ) {
        val previousValues = this.getOrDefault(currentDPValue, emptyList<List<Int>>())
        val nextValues: List<List<Int>> = buildList<List<Int>> {
            valueToAdd.forEach {
                val sortedList = it.sorted()
                if (!previousValues.contains(sortedList)) {
                    add(sortedList)
                }
            }
        } + previousValues

        this[currentDPValue] = nextValues

    }

    private fun MutableMap<Int, List<List<Int>>>.safeRemove(
        target: Int
    ) {
        val previousValues = this.getOrDefault(target, emptyList<List<Int>>())
        this[target] = previousValues.filter { !it.contains(target) }

    }
}