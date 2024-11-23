package breadthFirstSearch

import org.example.breadthFirstSearch.MinimumKnightMoves
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumKnightMovesTest {
    private val minimumKnightMoves = MinimumKnightMoves()

    @Test
    fun testExampleOne() {

        assertEquals(1,minimumKnightMoves.solve(1,2))
    }
    @Test
    fun testExampleTwo() {
        assertEquals(4,minimumKnightMoves.solve(4,4))
    }
}