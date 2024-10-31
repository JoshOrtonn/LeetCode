package org.example

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]

Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]

Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.


 */
class NumberOfIslands {
    data class Coordinates(val x: Int, val y: Int)

    // But time limit exceeds for large grid, obviously..
    fun numIslands(grid: Array<CharArray>): Int {
        var numberOfIslands = 0
        val visitedSet = mutableSetOf<Coordinates>()
        val queueOfIslands = ArrayDeque<Coordinates>()


        // Time complexity is m x n x j where
        // m x n is grid size, and j is number of islands
        for (i in 0..grid.lastIndex) {
            for (j in 0..grid[0].lastIndex) {
                val coords = Coordinates(i, j)
                if (grid[coords.x][coords.y] == '1' && !visitedSet.contains(coords)) {
                    queueOfIslands.addLast(coords)
                    BFS(grid, visitedSet, queueOfIslands)
                    numberOfIslands++
                }
            }
        }

        return numberOfIslands

    }

    fun BFS(grid: Array<CharArray>, visitedSet: MutableSet<Coordinates>, queueOfIslands: ArrayDeque<Coordinates>) {
        // Queue is already filled with coordinates with value 1.
        // Visit all of them, and then visit it's neighbours,
        // if at least two adjacent neighbours is 0, or out of Bounds then increment Islands
        while (queueOfIslands.isNotEmpty()) {
            val currentCoord: Coordinates = queueOfIslands.removeFirst()

            // Mark current as visited,
            visitedSet.add(currentCoord)

            val neighbours = listOf(
                Coordinates(-1, 0),
                Coordinates(1, 0),
                Coordinates(0, 1),
                Coordinates(0, -1)
            )

            neighbours.forEach { neighbour ->
                val newX = neighbour.x + currentCoord.x
                val newY = neighbour.y + currentCoord.y

                // If newX and newY within grid, and contains a 1, not seen in the visited set, add it to the queue.
                if (newX in grid.indices && newY in grid[0].indices && grid[newX][newY] == '1' && !visitedSet.contains(Coordinates(newX, newY))){
                    queueOfIslands.addLast(Coordinates(newX, newY))
                }
            }
        }
    }
}