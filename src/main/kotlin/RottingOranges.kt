package org.example

/**
 * Rotting Oranges
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten,
 * because rotting only happens 4-directionally.
 * Example 3:
 *
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
class RottingOranges {
    // Start at top left, iterate for each row and column
    // If grid[r][c] is a rotten tomato and not visited, do BFS on it
    // BFS:
    // Add cell to visited,
    //
    // Find non-visited, fresh orange adjacent neighbours:
    //      Mark them as rotten on grid
    //      Add them to the queue,
    // Increment Mins only if fresh Orange changed
    //

    // If grid contains a fresh orange still, return -1
    //
    // else return incrementMins (Should cover both incremented)

    data class Coordinates(val row: Int, val column: Int)

    fun orangesRotting(grid: Array<IntArray>): Int {
        val visited = mutableSetOf<Coordinates>()
        var minutes = 0

        val queue = ArrayDeque<Coordinates>()

        for (row in 0..grid.lastIndex) {
            for (column in 0..grid[0].lastIndex) {
                if (grid[row][column] == 2 && !visited.contains(Coordinates(row, column))) {
                    queue.addLast(Coordinates(row, column))
                    minutes += doBFS(queue, visited, grid)
                }
            }
        }

        for (i in 0..grid.lastIndex) {
            for (j in 0..grid[0].lastIndex) {
                if (grid[i][j] == 1) return -1
            }
        }
        return minutes
    }

    // First attempt did
    private fun doBFS(queue: ArrayDeque<Coordinates>, visited: MutableSet<Coordinates>, grid: Array<IntArray>): Int {
        var minutes = 0
        val adjacentCoordinates = listOf(
            Coordinates(-1, 0),
            Coordinates(1, 0),
            Coordinates(0, 1),
            Coordinates(0, -1)
        )

        while (queue.isNotEmpty()) {
            val rottenOrange = queue.removeFirst()
            // Add itself to visited queue
            visited.add(rottenOrange)
            var hasTurnedFreshToRotten = false

            // For each neighbour coordinate
            // If neighbour is fresh tomato
            // And not already visited.
            // Convert it to a rotten tomato
            // Add it to the queue
            adjacentCoordinates.forEach {
                val coordinate = Coordinates(rottenOrange.row + it.row, rottenOrange.column + it.column)
                if (isNeighbourFreshTomatoInGrid(coordinate, grid) && isNotAlreadyVisited(visited, coordinate)) {
                    // Convert it to rotten tomato
                    grid[coordinate.row][coordinate.column] = 2
                    // Add to queue to visit it's neighbours
                    queue.addLast(Coordinates(coordinate.row, coordinate.column))
                    hasTurnedFreshToRotten = true
                }
            }
            // Increment after finding fresh tommy?
            // Surely this isn't right!! Solves for the base case, at minute 0, but..
            // Min path...

            if (hasTurnedFreshToRotten) {
                minutes++
            }
        }
        return minutes
    }

    private fun isNotAlreadyVisited(
        visited: MutableSet<Coordinates>,
        coordinate: Coordinates
    ) = !visited.contains(
        Coordinates(
            coordinate.row,
            coordinate.column
        )
    )

    private fun isNeighbourFreshTomatoInGrid(
        coordToCheck: Coordinates,
        grid: Array<IntArray>
    ) = coordToCheck.row in grid.indices && coordToCheck.column in grid[0].indices &&
            grid[coordToCheck.row][coordToCheck.column] == 1
}