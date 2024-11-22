package org.example.depthFirstSearch

/**
1. Keep track of starting pixel value
2. Perform DFS starting from starting pixel coordinates
1. Pop off stack, change value in place to colour
2. Then add adjacent coordinates to the stack who share same starting pixel value and not already visited.
 **/
class FloodFill {
    data class Coordinate(val row: Int, val column: Int)
    fun solve(input: List<MutableList<Int>>, sr: Int, sc: Int, colour: Int): List<List<Int>> {
        val startingPixelValue = input[sr][sc]
        val startingNode = Coordinate(sr, sc)

        val stack = ArrayDeque<Coordinate>()
        val visited = mutableSetOf<Coordinate>()
        stack.addFirst(startingNode)

        val directions = listOf(
            Coordinate(0, 1),
            Coordinate(0, -1),
            Coordinate(1, 0),
            Coordinate(-1, 0)
        )

        while(stack.isNotEmpty()) {
            val node = stack.removeFirst()
            visited.add(node)
            // Change popped off stack (as should be value to change) to colour in the list
            input[node.row][node.column] = colour

            //Then add adjacent coordinates to the stack who share same starting pixel value and not already visited.
            directions.forEach {
                val newCoordinate = Coordinate(it.row + node.row, it.column + node.column)
                if(newCoordinate.row in input.indices && newCoordinate.column in input[0].indices && newCoordinate !in visited && input[newCoordinate.row][newCoordinate.column] == startingPixelValue){
                    stack.add(newCoordinate)
                }
            }
        }



        // If it can be changed in place, otherwise create a mutable copy and act on that
        return input
    }
}
