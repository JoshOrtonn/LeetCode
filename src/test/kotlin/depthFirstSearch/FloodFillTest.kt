package depthFirstSearch

import org.example.depthFirstSearch.FloodFill
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FloodFillTest {
    val floodFill = FloodFill()

    @Test
    fun shouldChangeExpectedColoursEx1() {
        val input = listOf(mutableListOf(1, 0, 1), mutableListOf(1, 0, 0), mutableListOf(0, 0, 1))
        val startingRow = 1
        val startingColumn = 1
        val colour = 2

        val expectedOutput = listOf(mutableListOf(1, 2, 1), mutableListOf(1, 2, 2), mutableListOf(2, 2, 1))
        assertEquals(expectedOutput, floodFill.solve(input, startingRow, startingColumn, colour))
    }

    @Test
    fun shouldChangeExpectedColoursEx2() {
        val input = listOf(mutableListOf(1, 1, 1), mutableListOf(1, 1, 0), mutableListOf(1, 0, 1))
        val startingRow = 1
        val startingColumn = 1
        val colour = 2

        val expectedOutput = listOf(mutableListOf(2, 2, 2), mutableListOf(2, 2, 0), mutableListOf(2, 0, 1))
        // Output: [[1,2,1],[1,2,2],[2,2,1]]
        assertEquals(expectedOutput, floodFill.solve(input, startingRow, startingColumn, colour))
    }
}