package org.example.depthFirstSearch
/**
### Implementation Ideas

- Iterate through entire array
- Find first ‘O’,  do DFS looking for boundary adjacent nodes.
- Creating a list of connected O’s
- If boundary found, do not change them
- If boundary not found, update the original map with those positions as X and continue looking for Os.

 **/

class SurroundedRegions{
    data class Coordinate(val row: Int, val column: Int)

    fun solve(input: List<MutableList<String>>): List<List<String>> {
        for(i in 0..input.lastIndex) {
            for(j in 0..input[0].lastIndex) {
                if(input[i][j] == "O"){
                    // DO DFS
                    // Pass in setOfCoordinates for us to then update the input with if DFS finds it does not touch a boundary
                    val path = mutableSetOf<Coordinate>()
                    val startingNode = Coordinate(i,j)
                    if(!depthFirstSearch(path, startingNode, input)){
                        path.forEach {
                            input[it.row][it.column] = "X"
                        }
                    }
                }
            }
        }
        return input
    }

    fun depthFirstSearch(path: MutableSet<Coordinate>, startingNode: Coordinate, input: List<MutableList<String>>): Boolean {
        val stack = ArrayDeque<Coordinate>()
        val visited = mutableSetOf<Coordinate>()
        var boundaryTouched = false
        val directions = listOf(
            Coordinate(0, 1),
            Coordinate(0, -1),
            Coordinate(1, 0),
            Coordinate(-1, 0)
        )

        stack.addFirst(startingNode)

        while(stack.isNotEmpty()){
            val node = stack.removeFirst()
            path.add(node)
            visited.add(node)
            directions.forEach {
                val newCoord = Coordinate(node.row + it.row, node.column + it.column)
                // If new Coord is boundary, mark as true
                // Only add to the stack values with "0"
                if(newCoord.row !in input.indices || newCoord.column !in input[0].indices){
                    boundaryTouched = true
                }
                if(newCoord.row in input.indices && newCoord.column in input[0].indices && input[newCoord.row][newCoord.column] == "O" && newCoord !in visited) {
                    stack.addFirst(newCoord) // Add new "0" to explore
                    println("newCoord has been added to the stack: " + newCoord)
                }
            }
        }
        return boundaryTouched

        // Time complexity: O(n*m) where n and m are rows and columns of a grid + time doing DFS (which in worst case is searching the entire grid, so O(n*m)
        // but given it's then O(n*m) + O(n*m) it reduces down to given only small scale factor to O(n*m)
        // Space complexity: O(n*m) for the grid + O(n*m) worst case path + O(n*m) visited + stack size
        // But ultimately again it scales down to O(n*m) given O(3*n*m) is not a massively bigger factor.
    }
}