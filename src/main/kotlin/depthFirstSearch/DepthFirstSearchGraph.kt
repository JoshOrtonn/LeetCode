package org.example.depthFirstSearch

import org.example.adjacencyListMakingPractice.AdjacencyListPractice

class DepthFirstSearchGraph {
    private val edges = listOf(listOf(0, 1), listOf(1, 2), listOf(2, 3), listOf(3, 0), listOf(0, 2))

    private val adjacencyMatrix: Map<Int, Set<Int>> =
        AdjacencyListPractice().buildDirectionalAdjacencyMatrix(edges, edges.size)

    fun recursiveDFSHelper(): MutableSet<Int> {
        val neighbours = mutableSetOf<Int>()
        val startingNode = adjacencyMatrix[0]!!.first()
        return recursiveDFS(startingNode, neighbours)
    }

    private fun recursiveDFS(node: Int, visited: MutableSet<Int>): MutableSet<Int> {
            visited.add(node)
            adjacencyMatrix[node]?.forEach {
                if (it !in visited) {
                    recursiveDFS(it, visited) // Literally same it's just with a call stack or declared stack
                }
            }
        return visited
    }

    fun iterativeDFS(): MutableSet<Int> {
        val stack = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()

        val startingNode = adjacencyMatrix[0]!!.first()
        stack.addFirst(startingNode)

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            // Given visited.add returns false if already added, we can not add it's neighbours.
            visited.add(node)
                adjacencyMatrix[node]?.forEach {
                    if (it !in visited) {
                        stack.addFirst(it)
                    }
                }
            }
        return visited
    }
}