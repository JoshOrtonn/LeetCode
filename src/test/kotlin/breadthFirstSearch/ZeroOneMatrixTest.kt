package breadthFirstSearch

import org.example.breadthFirstSearch.ZeroOneMatrix
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ZeroOneMatrixTest {
    private val zeroOneMatrix = ZeroOneMatrix()

    @Test
    fun shouldTurnToRottenEx1() {
        val input = listOf(
            listOf(1, 0, 1),
            listOf(0, 1, 0),
            listOf(1, 1, 1)
        )

        val expectedOutput = listOf(
            listOf(1, 0, 1),
            listOf(0, 1, 0),
            listOf(1, 2, 1)
        )

        assertEquals(expectedOutput, zeroOneMatrix.distanceFromZero(input))
    }

    @Test
    fun shouldTurnToRottenEx2() {
        val input = listOf(
            listOf(1, 1, 1),
            listOf(1, 1, 1),
            listOf(1, 1, 1)
        )

        val expectedOutput = listOf(
            listOf(-1, -1, -1),
            listOf(-1, -1, -1),
            listOf(-1, -1, -1)
        )

        assertEquals(expectedOutput, zeroOneMatrix.distanceFromZero(input))
    }
}