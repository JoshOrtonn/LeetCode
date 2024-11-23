package org.example.breadthFirstSearch

class ZeroOneMatrix {
    data class Coordinate(val row: Int, val column: Int)
    fun distanceFromZero(input: List<List<Int>>): List<List<Int>> {
        val visited = mutableSetOf<Coordinate>()
        val queue = ArrayDeque<Coordinate>()

        val outputList = mutableListOf<MutableList<Int>>()
        for(i in 0..input.lastIndex){
            val newList = mutableListOf<Int>()
            for(j in 0..input[0].lastIndex) {
                if(input[i][j] == 0) {
                    val zeroCoordinate = Coordinate(i,j)
                    visited.add(zeroCoordinate)
                    queue.add(zeroCoordinate)
                    newList.add(0)
                } else {
                    newList.add(-1)
                }
            }
            outputList.add(newList)
        }

        val directions = listOf(
            Coordinate(0, 1),
            Coordinate(0, -1),
            Coordinate(-1, 0),
            Coordinate(1, 0)
        )
        var distance = 1

        while(queue.isNotEmpty()){
            val queueSize = queue.size
            for(i in 1..queueSize) {
                val node = queue.removeFirst()
                directions.forEach {
                    val newCoord = Coordinate(it.row+node.row, it.column+node.column)
                    if(newCoord !in visited && newCoord.row in input.indices && newCoord.column in input[0].indices && input[newCoord.row][newCoord.column] == 1){
                        visited.add(newCoord)
                        queue.addLast(newCoord)
                        outputList[newCoord.row][newCoord.column] = distance
                    }
                }
            }
            distance++
        }

        return outputList
    }
}

