package depthFirstSearch

import org.example.depthFirstSearch.DepthFirstSearch
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DepthFirstSearchTest{

    @Test
    fun shouldVisitAllNodesIteratively() {
        val depthFirstSearch = DepthFirstSearch()
        val expectedOutput = mutableSetOf<Int>(0,1,2,3)
        assertEquals(expectedOutput, depthFirstSearch.iterativeDFS())
    }
    @Test
    fun shouldVisitAllNodesRecursively() {
        val depthFirstSearch = DepthFirstSearch()
        val expectedOutput = mutableSetOf<Int>(0,1,2,3)
        assertEquals(expectedOutput, depthFirstSearch.recursiveDFSHelper())
    }
}