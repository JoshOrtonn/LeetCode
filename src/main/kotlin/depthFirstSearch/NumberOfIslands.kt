package org.example.depthFirstSearch

/**
DESCRIPTION (credit Leetcode.com)
You are given binary matrix grid of size m x n, where '1' denotes land and '0' signifies water.
Determine the count of islands present in this grid.
An island is defined as a region of contiguous land cells connected either vertically or horizontally,
and it is completely encircled by water. Assume that the grid is bordered by water on all sides.

 */

class NumberOfIslands {
    data class Coordinate(val row: Int, val column: Int)
    fun solve(input: List<MutableList<Int>>): Int {
        var islandCount = 0
        // Iterate across every coordinate on the grid
        // If it's a 1, do DFS on it, add to visited, add adjacent neighbours
        // Who are in bounds
        // Not already visited
        // And their value is equal to 1
        // Change value to 2, denoting already visited, for the nested for loop to pick off and action only those non-visited ones..
        // Maybe this is overkill but....

        // Could be better to iterate over the unvisitedSet, and update as we go, but concurrent updates, not sure how they vibe.
        // as in, add
        for (i in 0..input.lastIndex) {
            for (j in 0..input[0].lastIndex) {
                if (input[i][j] == 1) {
                    // DO DFS
                    depthFirstSearch(Coordinate(i, j), input)
                    // Maybe we can increment here
                    islandCount++
                    // Given it will esentially count the number of DFS's and if we change them in place, we can ensure it's the number of times we do it.
                }
                // Value with either be, 0 or 2 to denote if already visited.
                // Could raise the visited Set to be at this level and introduce it as an additional check, but for now lets leave it.

            }
        }

        return islandCount
        // Time complexity is: O(i * j) + time spent during Depth First Search, which is essentially linear, given in worst case iterates 4 times.
        // So can be shortened to O(i*j) where i is row in input, and j is column in input.
        // Space Complexity, again in its worst case is O(i*j) where each node is added to the stack,
        // similarly for a visited set which can hold all of the items in the array.
    }

    private fun depthFirstSearch(startingNode: Coordinate, input: List<MutableList<Int>>) {
        val stack = ArrayDeque<Coordinate>()
        stack.addFirst(startingNode)
        val visited = mutableSetOf<Coordinate>()
        val directions = listOf(Coordinate(0, 1), Coordinate(0, -1), Coordinate(1, 0), Coordinate(-1, 0))

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            visited.add(node)
            // Update node to be 2, essentially same as marking as visited.
            // But could be helpful for debugging flow of it.
            input[node.row][node.column] = 2

            directions.forEach {
                val newCoordinate = Coordinate(node.row + it.row, node.column + it.column)
                // add adjacent neighbours
                // Who are in bounds
                // Not already visited
                if (newCoordinate.row in input.indices && newCoordinate.column in input[0].indices && newCoordinate !in visited && input[newCoordinate.row][newCoordinate.column] == 1) {
                    stack.addFirst(newCoordinate)
                }
            }
        }
    }
}

