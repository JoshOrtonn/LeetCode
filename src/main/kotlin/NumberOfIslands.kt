package org.example

class NumberOfIslands {
    data class Coordinates(val x: Int, val y: Int)

    // But time limit exceeds for large grid, obviously..
    fun numIslands(grid: Array<CharArray>): Int {
        var numberOfIslands = 0
        val visitedSet = mutableSetOf<Coordinates>()


        // Time complexity is m x n x j where
        // m x n is grid size, and j is number of islands
        for (i in 0..grid.lastIndex) {
            for (j in 0..grid[0].lastIndex) {
                val coords = Coordinates(i, j)
                if (grid[coords.x][coords.y] == '1' && coords !in visitedSet) {
                    BFS(grid, coords, visitedSet)
                    // TO add all 1's to visited.
                    numberOfIslands += 1
                }
            }
        }

        return numberOfIslands
    }

    fun BFS(grid: Array<CharArray>, startingCoords: Coordinates, visitedSet: MutableSet<Coordinates>) {
        // Assume queue is only filled with coordinates with value 1.
        val queue = ArrayDeque<Coordinates>()
        queue.addLast(startingCoords)

        while (queue.isNotEmpty()) {
            val currentCoord: Coordinates = queue.removeFirst()
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
                if (newX in grid.indices && newY in grid[0].indices && grid[newX][newY] == '1' && !visitedSet.contains(
                        Coordinates(newX, newY)
                    )
                ) {
                    queue.addLast(Coordinates(newX, newY))
                }
            }
            visitedSet.add(currentCoord)
        }
    }
}