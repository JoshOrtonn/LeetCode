package breadthFirstSearch

import org.example.breadthFirstSearch.FreshOranges
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FreshOrangesTest {
    private val freshOranges = FreshOranges()
    @Test
    fun shouldTurnToRottenEx1() {
        val input = listOf(
            mutableListOf("R", "F"),
            mutableListOf("F", "F"))
        assertEquals(2, freshOranges.turnToRotten(input))
    }
    @Test
    fun shouldTurnToRottenEx2() {

        val input = listOf(
            mutableListOf("R", "F", "F", "F"),
            mutableListOf("F", "F", "F", "R"),
            mutableListOf("E", "E", "F", "F"))

        assertEquals(2, freshOranges.turnToRotten(input))
    }
    @Test
    fun shouldNotBeAbleToTurnAllOranges() {
        val input = listOf(
            mutableListOf("R", "E"),
            mutableListOf("E", "F"))

        assertEquals(-1, freshOranges.turnToRotten(input))
    }

}