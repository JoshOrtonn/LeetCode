package depthFirstSearch

import GraphValidTree
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GraphValidTreeTest {
    val graphValidTree = GraphValidTree()
    @Test
    fun shouldBeValidForConnectedGraph() {
        // n = 4
        // edges = [[0, 1], [1, 3], [3,6]
        val input: List<List<Int>> = listOf(listOf(0, 1), listOf(1,3), listOf(3,6))

        assertTrue(graphValidTree.isValid(input))
    }

    @Test
    fun shouldFailNonConnectedGraph() {
        // n = 4
        // edges = [[0, 1], [2, 3]]
        val input: List<List<Int>> = listOf(listOf(0, 1), listOf(2,3))
        assertFalse(graphValidTree.isValid(input))
    }

    @Test
    fun shouldFailForCyclicGraph() {
        // n = 4
//        edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
        val input: List<List<Int>> = listOf(listOf(0, 1), listOf(1,2), listOf(1,3),  listOf(1,4),  listOf(2,3))
        assertFalse(graphValidTree.isValid(input))
    }
}