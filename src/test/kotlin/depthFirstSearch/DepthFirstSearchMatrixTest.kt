package depthFirstSearch

import org.example.depthFirstSearch.DepthFirstSearchMatrix
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DepthFirstSearchMatrixTest{
    val depthFirstSearchMatrix = DepthFirstSearchMatrix()

    @Test
    fun shouldVisitAllNodesInGrid(){
        assertTrue(depthFirstSearchMatrix.DFS())
    }
}