package depthFirstSearch

import org.example.adjacencyListMakingPractice.AdjacencyListPractice
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AdjacencyListPracticeTest{
    @Test
    fun shouldBuildBidirectionalAdjMatrix(){
        val adjacencyList = AdjacencyListPractice()

        val edges = listOf(listOf(0,1), listOf(1,2), listOf(2,3), listOf(3, 0), listOf(0,2))
        val numberOfNodes = 4
        val output: Map<Int, Set<Int>> = adjacencyList.buildBidirectionalAdjacencyMatrix(edges, numberOfNodes)

        val expectedOutput = mutableMapOf<Int, Set<Int>>()
        expectedOutput.put(0, setOf(1,2,3))
        expectedOutput.put(1, setOf(0,2))
        expectedOutput.put(2, setOf(0, 1, 3))
        expectedOutput.put(3, setOf(0, 2))

        assertEquals(expectedOutput[0], output[0])
        assertEquals(expectedOutput[1], output[1])
        assertEquals(expectedOutput[2], output[2])
        assertEquals(expectedOutput[3], output[3])
    }

    @Test
    fun shouldBuildDirectionalAdjMatrix(){
        val adjacencyList = AdjacencyListPractice()

        val edges = listOf(listOf(0,1), listOf(1,2), listOf(2,3), listOf(3, 0), listOf(0,2))
        val numberOfNodes = 4
        val output: Map<Int, Set<Int>> = adjacencyList.buildDirectionalAdjacencyMatrix(edges, numberOfNodes)

        val expectedOutput = mutableMapOf<Int, Set<Int>>()
        expectedOutput.put(0, setOf(1,2))
        expectedOutput.put(1, setOf(2))
        expectedOutput.put(2, setOf(3))
        expectedOutput.put(3, setOf(0))

        assertEquals(expectedOutput[0], output[0])
        assertEquals(expectedOutput[1], output[1])
        assertEquals(expectedOutput[2], output[2])
        assertEquals(expectedOutput[3], output[3])
    }
}