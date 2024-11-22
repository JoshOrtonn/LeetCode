package depthFirstSearch

import org.example.depthFirstSearch.NumberOfIslands
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class NumberOfIslandsTest {
    val numberOfIslands = NumberOfIslands()

    @Test
    fun testExampleOne() {
        val input = listOf(
            mutableListOf(1,1,0,1),
            mutableListOf(1,1,0,1),
            mutableListOf(1,1,0,0)
        )

        assertEquals(2, numberOfIslands.solve(input))
    }
    @Test
    fun testExampleTwo() {
        val input = listOf(
            mutableListOf(1,1,1,1,0),
            mutableListOf(1,1,0,1,0),
            mutableListOf(1,1,0,0,0),
            mutableListOf(0,0,0,0,0)
        )

        assertEquals(1, numberOfIslands.solve(input))
    }
    @Test
    fun testExampleThree() {
        val input = listOf(
            mutableListOf(1,1,0,0,0),
            mutableListOf(1,1,0,0,0),
            mutableListOf(0,0,1,0,0),
            mutableListOf(0,0,0,1,1)
        )
        assertEquals(3, numberOfIslands.solve(input))
    }
}
