package org.example.depthFirstSearch

/**
 * DFS on a matrix is similar to DFS on an adjacency list. We still have to keep track of visited nodes,
 * and we recursively call DFS on each neighbor of the current node.
 *
 * The main difference is that each cell can have at most 4 neighbors (up, down, left, right),
 * and that we need to check if the neighbor is within the bounds of the grid before visiting it.
 *
 * DESCRIPTION (credit Leetcode.com)
 * Given a m x n integer grid image and integers sr, sc, and newColor, write a function to perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * In a 'flood fill', start by changing the color of image[sr][sc] to newColor. Then, change the color of all pixels connected to image[sr][sc] from either the top, bottom, left or right that have the same color as image[sr][sc], along with all the connected pixels of those pixels, and so on.
 *
 * EXAMPLES
 * Input: image = [[1,0,1],[1,0,0],[0,0,1]], sr = 1, sc = 1, color = 2
 *
 * Output: [[1,2,1],[1,2,2],[2,2,1]]
 *
 * The zeroes connected to the starting pixel (1, 1) are colored with the new color (2).
 */
class DepthFirstSearchMatrix {
    data class Coordinate(val row: Int, val column: Int)
    fun DFS(): Boolean {
        val input = listOf(listOf(1,0,1), listOf(1,0,0), listOf(0,0,1))
        val stack = ArrayDeque<Coordinate>()
        val visited = mutableSetOf<Coordinate>()
        // Row, Coordinates

        val directions = listOf(
            Coordinate(0, 1),
            Coordinate(0, -1),
            Coordinate(1, 0),
            Coordinate(-1, 0)
        )

        // Start at some starting index, call it 0,0.
        stack.addFirst(Coordinate(0,0))
        while(stack.isNotEmpty()) {
            val node = stack.removeFirst()
            visited.add(node)

            directions.forEach {
                val coordinateToExplore = Coordinate(node.row + it.row, node.column + it.column)
                // Works if its' a square 2D matrix.
                if(coordinateToExplore.row in input.indices && coordinateToExplore.column in input[0].indices){
                    if(coordinateToExplore !in visited){
                        stack.addFirst(coordinateToExplore)
                    }
                }
            }
        }


        // Should have visited all nodes in 3x3 grid.
        return visited.size == 9

    }
}