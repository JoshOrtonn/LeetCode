package org.example.breadthFirstSearch

import kotlin.collections.mutableSetOf as mutableSetOf1

/*
DESCRIPTION (credit Leetcode.com)
You are given an m x n binary matrix grid where each cell contains either a 0 or a 1.

Write a function that returns a matrix of the same dimensions where each cell contains the distance to the nearest 0 in the original matrix.
The distance between two adjacent cells is 1. If there is no 0 in the grid, return -1 for each cell.

 */
class ZeroOneMatrix {
    data class Coordinate(val row: Int, val column: Int)
    fun distanceFromZero(input: List<List<Int>>): List<List<Int>> {
        val visited = mutableSetOf1<Coordinate>()
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
        val set = mutableSetOf1(1,2,3)

        return outputList
    }
}
// TODO figure out complexities
