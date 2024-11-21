package depthFirstSearch

import org.example.depthFirstSearch.CloneGraph
import org.example.depthFirstSearch.IntGraphNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class CloneGraphTest {
    @Test
    fun testExampleOne() {
        val node2 = IntGraphNode(2)
        val node3 = IntGraphNode(3)
        val node1 = IntGraphNode(1).apply {
            neighbours = listOf(node2, node3)
        }
        val expectedOutput = mutableMapOf<Int, Set<Int>>()
        expectedOutput.put(1, setOf(2,3))
        expectedOutput.put(2, setOf(1))
        expectedOutput.put(3, setOf(1))

        val cloneGraph = CloneGraph()

        assertEquals(expectedOutput, cloneGraph.clone(node1))
    }

    @Test
    fun testExampleTwo() {
        val node2 = IntGraphNode(2)
        val node3 = IntGraphNode(3)
        val node4 = IntGraphNode(4)
        val node1 = IntGraphNode(1)

        node1.neighbours = listOf(node2, node4)
        node2.neighbours = listOf(node1, node3)
        node3.neighbours = listOf(node2, node4)
        node4.neighbours = listOf(node1, node3)


        val expectedOutput = mutableMapOf<Int, Set<Int>>()
        expectedOutput.put(1, setOf(2,4))
        expectedOutput.put(2, setOf(1,3))
        expectedOutput.put(3, setOf(2,4))
        expectedOutput.put(4, setOf(1,3))


        val cloneGraph = CloneGraph()

        assertEquals(expectedOutput, cloneGraph.clone(node1))
    }
}