package org.example

/**
 * Take nums = [1, 2, 3] as example:
 *
 * at index 0, nums[0] = 1
 * [1] <- add a permute contains 1
 *
 * at index 1, nums[1] = 2
 * [1, 2] <- add 2 to existing permutes
 * [2, 1] <- created by rotating exiting permutes by 1
 *
 * at index = 2, nums[2] = 3
 * [1, 2, 3], [2, 1, 3] <- add 3 to existing permutes  - runningList
 * [3, 1, 2], [3, 2, 1] <- created by rotating exiting permutes by 1 - Created
 * [2, 3, 1], [1, 3, 2] <- created by rotating exiting permutes by 2
 *
 * At index, add that many times, to previous
 * Or rather just add to all previous
 * Then create new ones, by replacing / rotating the newly added number with each previous position
 *
 *         // Expected :[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
 *         // Actual   :[[1, 2, 3], [2, 1, 3], [3, 1, 2], [3, 2, 1], [2, 3, 1], [1, 3, 2]]
 */
// TODO Figure this out.
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val numberOfLists = (nums.size * nums.size) - nums.size

        // Init first list.
        val outputList = buildList<List<Int>> {
            addAll(listOf(nums.toMutableList()))
        }

        // For each of the num array [1,2,3], change position of each.
        // So index[0] should add two more arrays starting from index 0..outPutList.lastIndex
        for (index in 0..nums.lastIndex) {
            // Add 2 to each position
            // Add 3 to each position
            val copyOfOutputsToPermute2 = buildList<MutableList<Int>> {
                outputList.forEach {
                    add(it.toMutableList())
                }
            }


            val permutatedList = buildList<List<Int>> {
                for (permuteIndex in index..nums.lastIndex) {
                    copyOfOutputsToPermute2.forEach {
                        // But do it without copying
                        val copy = it.toList()
                        copy.toMutableList()
                        it.removeAt(index)
                        it.add(permuteIndex, nums[index])
                    }
                }
            }


        }
        return outputList
    }

    private fun addNumberToLists(number: Int, permutes: MutableList<MutableList<Int>>) {
        for (permute in permutes) {
            permute.add(number)
        }
    }
}