package depthFirstSearch

import org.example.depthFirstSearch.SurroundedRegions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class SurroundedRegionsTest {
    val surroundedRegions = SurroundedRegions()
    @Test
    fun shouldEqualExpectedGridOne() {
        println("____________________________________")

        println("GridOne")
        val inputGrid = listOf(
            mutableListOf("X","X","X","X","O"),
            mutableListOf("X","X","O","X","X"),
            mutableListOf("X","X","O","X","O"),
            mutableListOf("X","O","X","X","X"),
            mutableListOf("X","O","X","X","X"),
        )

        val expectedOutput = listOf(
            mutableListOf("X","X","X","X","O"),
            mutableListOf("X","X","X","X","X"),
            mutableListOf("X","X","X","X","O"),
            mutableListOf("X","O","X","X","X"),
            mutableListOf("X","O","X","X","X"),
        )

        assertEquals(expectedOutput, surroundedRegions.solve(inputGrid))
    }
    @Test
    fun shouldEqualExpectedGridTwo() {
        println("____________________________________")

        println("GridTwo")
        val inputGrid = listOf(
            mutableListOf("O","O"),
            mutableListOf("O","X")
        )

        val expectedOutput = listOf(
            mutableListOf("O","O"),
            mutableListOf("O","X")
        )
        assertEquals(expectedOutput, surroundedRegions.solve(inputGrid))
    }
    @Test
    fun shouldEqualExpectedGridThree() {
        println("____________________________________")

        println("GridThree")
        val inputGrid = listOf(
            mutableListOf("X","X","X","X"),
            mutableListOf("X","O","O","X"),
            mutableListOf("X","X","O","X"),
            mutableListOf("X","O","X","X")
        )

        val expectedOutput = listOf(
            mutableListOf("X","X","X","X"),
            mutableListOf("X","X","X","X"),
            mutableListOf("X","X","X","X"),
            mutableListOf("X","O","X","X")
        )
        assertEquals(expectedOutput, surroundedRegions.solve(inputGrid))
    }
}