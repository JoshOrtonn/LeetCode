package org.example

/**
 * Matrix
 * Medium
 * Topics
 * Companies
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 * Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
class OOneMatrix {
    // Find path for each node to nearest 0.
    // BFS using queue FIFO, Visit node, store neighbours, then remove first from queue calculate height / distance.

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        if(mat.isEmpty() || mat[0].isEmpty()) return emptyArray()

        // saving a hashMap for coordinates lookup for nearest to a 0.
        // To save on execution time.
        // Given we are going to iterate for n x m times.

        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()

        // Add 0 values to the queue and visited
        // To then work backwards from them to their neighbours with distance being value + neighbourValue
        for(row in 0 until mat.size){
            for (col in 0 until mat[0].size){
                if(mat[row][col] == 0) {
                    queue.addLast(Triple(row, col, mat[row][col]))
                    visited.add(Pair(row, col))
                }
            }
        }

        while(queue.isNotEmpty()){
            // At the start queue will just contain 0s, which will then grow to also contain it's neighbours which will invaraible be 1.
            // And as queue continues to grow with 1s neighbours
            // The path will be currentNodeValue(third) + neighbourValue as the new neighbour's value.
            val currentNode: Triple<Int, Int, Int> = queue.removeFirst()


            val neighbours = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1))

            // Enqueue it's non visited neighbours
            // Which if 1, will remain at 1.
            // And theory goes that we will then enqueue the value 1s and follow same principle
            // Such that 1 + 1 will be 2, for those prepopulated with 1s enclosed by 1s.
            neighbours.forEach {
                val newX = currentNode.first + it.first
                val newY = currentNode.second + it.second
                if(newX to newY !in visited){
                    mat.safeGet(newX, newY)?.let { neighbourValue ->
                        val distanceFromZero = neighbourValue + currentNode.third
                        // Whereby it is the value at X and Y
                        queue.addLast(Triple(newX, newY, distanceFromZero))

                        mat[newX][newY] = distanceFromZero
                        // Really struggling to see how we can get 1 + 0
                        visited.add(Pair(newX, newY))
                    }

                }
            }
        }

        return mat
    }


    private fun Array<IntArray>.safeGet(x: Int, y: Int): Int? {
        return if(x in 0..lastIndex && y in 0.. this[0].lastIndex) {
            this[x][y]
        } else {
            null
        }
    }
}