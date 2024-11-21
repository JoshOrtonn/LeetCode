package org.example.adjacencyListMakingPractice

/**
 * - Given an integer `n` which represents the number of nodes in a graph,
 * - and a list of edges `edges` , where edges[i] = [ui, vi] **bidirectional** edge between two nodes
 *      write a function to return the adjacency list
 *      representation of the graph.
 *     - Keys should be nodes, and values should be the list of nodes each node is connected to.
 */
class AdjacencyListPractice {

    // val edges = listOf(listOf(0,1), listOf(1,2), listOf(2,3), listOf(3, 0), listOf(0,2))
    // val numberOfNodes = 4
    // val output = Map[0: [1,2,3], 1: [0,2], 2: [0,1,3], 3: [0,2]]
    fun buildBidirectionalAdjacencyMatrix(input: List<List<Int>>, numberOfNodes: Int): Map<Int, Set<Int>> {
        val map = mutableMapOf<Int, Set<Int>>()

        input.forEach { edges: List<Int> ->
            // Lookup first put if not present with second as value
            // Otherwise append last to first
            map.put(edges.first(), map.getOrDefault(edges.first(), setOf()) + edges.last())
            map.put(edges.last(),  map.getOrDefault(edges.last(), setOf()) + edges.first())

        }

        return map.toMap()
    }

    // val edges = listOf(listOf(0,1), listOf(1,2), listOf(2,3), listOf(3, 0), listOf(0,2))
    // val output = Map[0: [1,2], 1: [2], 2: [3], 3: [0]]
    // val numberOfNodes = 4
    fun buildDirectionalAdjacencyMatrix(input: List<List<Int>>, numberOfNodes: Int): Map<Int, Set<Int>> {
        val map = mutableMapOf<Int, Set<Int>>()

        input.forEach { edges: List<Int> ->
            // Lookup first put if not present with second as value
            // Otherwise append last to first
            map.put(edges.first(), map.getOrDefault(edges.first(), setOf()) + edges.last())

        }

        return map.toMap()
    }
}