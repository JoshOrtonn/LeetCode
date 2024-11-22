package depthFirstSearch

import org.example.depthFirstSearch.DepthFirstSearchGraph
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DepthFirstSearchGraphTest{

    @Test
    fun shouldVisitAllNodesIteratively() {
        val depthFirstSearchGraph = DepthFirstSearchGraph()
        val expectedOutput = mutableSetOf<Int>(0,1,2,3)
        assertEquals(expectedOutput, depthFirstSearchGraph.iterativeDFS())
    }
    @Test
    fun shouldVisitAllNodesRecursively() {
        val depthFirstSearchGraph = DepthFirstSearchGraph()
        val expectedOutput = mutableSetOf<Int>(0,1,2,3)
        assertEquals(expectedOutput, depthFirstSearchGraph.recursiveDFSHelper())
    }
}