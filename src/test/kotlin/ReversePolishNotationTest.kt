import org.example.ReversePolishNotation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 *  Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 */
class ReversePolishNotationTest{
    private val reversePolishNotation = ReversePolishNotation()
    @Test
    fun shouldSolveForEx1() {
        val input = arrayOf("2", "1", "+", "3", "*")
        val expectedOutput = 9

        assertEquals(expectedOutput, reversePolishNotation.evalRPN(input))
    }

    @Test
    fun shouldSolveForEx2() {
        val input = arrayOf("4", "13", "5", "/", "+")
        val expectedOutput = 6
        assertEquals(expectedOutput, reversePolishNotation.evalRPN(input))

    }

    @Test
    fun shouldSolveForEx3() {
        val input = arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")
        val expectedOutput = 22

        assertEquals(expectedOutput, reversePolishNotation.evalRPN(input))
    }
}