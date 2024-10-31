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
        var freshOranges = 0

        // Queue should contain pair of coordinates, and the value it was added to the queue, to find shortest path.
        // Such that take off queue and increment by 1 the neighbours that are added.
        val queue = ArrayDeque<Pair<Coordinates, Int>>()

        for (row in 0..grid.lastIndex) {
            for (column in 0..grid[0].lastIndex) {
                if (grid[row][column] == 2) {
                    queue.addLast(Coordinates(row, column) to 0)
                } else if(grid[row][column] == 1){
                    freshOranges += 1
                }
            }
        }

        // Clue was in the third use case for min 0 checking
        if(freshOranges == 0) return 0

        // Do BFS on all of these now, given it's all of the rotten oranges, keeping count of the min it was added to the queue.
         val (minutes, freshOrangesTurned) = doBFS(queue, visited, grid)

        if(freshOrangesTurned != freshOranges) return -1

        return minutes
    }

    // First attempt did not fully work as added too many minutes, visiting all the neighbours doing wasted time
    // Maybe instead after looking at hint, we could populate the rotten oranges first onto the grid,
    // then apply BFS for each of these, remembering to include within coordinates, the minute it was added to the queue
    // Given all rotten tomatoes added to this, the max value of the queue should be the min number of mins, I think
    private fun doBFS(queue: ArrayDeque<Pair<Coordinates, Int>>, visited: MutableSet<Coordinates>, grid: Array<IntArray>): Pair<Int, Int> {
        val adjacentCoordinates = listOf(
            Coordinates(-1, 0),
            Coordinates(1, 0),
            Coordinates(0, 1),
            Coordinates(0, -1)
        )

        var freshOrangesTurned = 0
        var minutes = 0

        while (queue.isNotEmpty()) {
            val (rottenOrangeCords, rottenOrangeAddedAtMin) = queue.removeFirst()
            // Add itself to visited queue
            visited.add(rottenOrangeCords)

            // For each neighbour coordinate
            // If neighbour is fresh tomato
            // And not already visited.
            // Convert it to a rotten tomato
            // Increment the minsTakenToTurnOrange
            // Count maxValue to turn as presumably this would be the last min to turn all oranges.
            // Add it to the queue
            adjacentCoordinates.forEach {
                val coordinate = Coordinates(rottenOrangeCords.row + it.row, rottenOrangeCords.column + it.column)
                if (isNeighbourFreshTomatoInGrid(coordinate, grid) && isNotAlreadyVisited(visited, coordinate)) {
                    // Rottenize the orange
                    grid[coordinate.row][coordinate.column] = 2

                    val minsTakenToTurnOrange = rottenOrangeAddedAtMin + 1
                    minutes = maxOf(minutes, minsTakenToTurnOrange)

                    queue.addLast(Coordinates(coordinate.row, coordinate.column) to minsTakenToTurnOrange)
                    freshOrangesTurned++
                }
            }
        }

        return minutes to freshOrangesTurned
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