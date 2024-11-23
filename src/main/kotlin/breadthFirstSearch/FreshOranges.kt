package org.example.breadthFirstSearch

/**
# Algorithm

For each rotten orange, so maybe a once through, denoting where the rotten oranges are, adding their Coords to a queue.
And making a note of fresh orangesTotal

var turnedOranges = 0

Mark them as visited

while(queue is not empty)

denote QueueSize at minute 0

val foundFresh = false

Iterate across queueSize

- pop off queue

do BFS in adjacent directions

- If any adjacent is fresh, not in visited then
- add to queue
- addToVisited
- turnedOranges++
- Add to ToBeRotten list

}

increment minute++

update grid to contain new rotten oranges

if(turnedOranges = freshOrangeTotal) {

return minute

}

else return -1

 **/

class FreshOranges {
    data class Coordinate(val row: Int, val column: Int)
    private fun Coordinate.isInBounds(input: List<MutableList<String>>): Boolean {
        return this.row in input.indices && this.column in input[0].indices
    }
    fun turnToRotten(input: List<MutableList<String>>): Int {
        val visited = mutableSetOf<Coordinate>()
        val queue = ArrayDeque<Coordinate>()
        var totalFreshOranges = 0
        for(i in 0..input.lastIndex){
            for(j in 0..input[0].lastIndex) {
                if(input[i][j] == "R"){
                    val freshCoord = Coordinate(i,j)
                    visited.add(freshCoord)
                    queue.addLast(freshCoord)
                } else if(input[i][j] == "F"){
                    totalFreshOranges++
                }
            }
        }

        val directions = listOf(
            Coordinate(0, 1),
            Coordinate(0, -1),
            Coordinate(1, 0),
            Coordinate(-1, 0),
        )

        var turnedOranges = 0
        var minutes = 0
        while(queue.isNotEmpty()) {
            val queueSize = queue.size
            val toBeRottenList = mutableListOf<Coordinate>()

            for(i in 1..queueSize){
                val node = queue.removeFirst()
                directions.forEach {
                    val newCoord = Coordinate(node.row + it.row, node.column + it.column)
                    if(newCoord.isInBounds(input) && newCoord !in visited && input[newCoord.row][newCoord.column] == "F") {
                        visited.add(newCoord)
                        toBeRottenList.add(newCoord)
                        queue.addLast(newCoord)
                    }
                }
            }

            turnedOranges += toBeRottenList.size
            minutes++
            toBeRottenList.forEach {
                input[it.row][it.column] = "R"
            }
            if(turnedOranges == totalFreshOranges) {
                return minutes
            }
        }

        return -1
    }
}
