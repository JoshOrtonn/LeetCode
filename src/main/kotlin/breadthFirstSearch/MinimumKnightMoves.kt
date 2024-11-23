package org.example.breadthFirstSearch


/**
# Algorithm

define directions as:

(1,2)

(1,-2)

(-1,2)

(-1,-2)


var level = 0
BFS. with starting position (0,0)

find queueSize
then for each level / For the entire queue at this level {
    val node = popOffTop Queue

    if(node == targetPosition) return level

    for each direction: {
        - newCoordinate it+startingPosition
        - if not visited
        - add to queue,
        - mark new coordinate as visited

    }
}
level += 1

No path found.
return -1
 **/
class MinimumKnightMoves {
    data class Coordinates(val row: Int, val column: Int)
    fun solve(targetRow: Int, targetColumn: Int): Int{
        val targetCoord = Coordinates(targetRow, targetColumn)
        val visited = mutableSetOf<Coordinates>()


        val directions = listOf(
            Coordinates(1,2),
            Coordinates(1,-2),
            Coordinates(-1,2),
            Coordinates(-1,-2),
        )

        val queue = ArrayDeque<Coordinates>()
        val startingCoord = Coordinates(0,0)
        queue.addLast(startingCoord)
        visited.add(startingCoord)
        var levels = 0
        while(queue.isNotEmpty()) {
            val queueSize = queue.size
            for(i in 1..queueSize){
                val node = queue.removeFirst()
                if(node == targetCoord) return levels
                directions.forEach {
                    val newCoord = Coordinates(node.row + it.row, node.column + it.column)

                    if(newCoord !in visited) {
                        queue.addLast(newCoord)
                        visited.add(newCoord)
                    }
                }
            }
            levels++

        }

        return -1
    }
}