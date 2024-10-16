import org.example.ValidParenthesis
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidParenthesisTest{
    val validParenthesis = ValidParenthesis()
    @Test
    fun assertExampleIsValid() {
        val input = "()"

        assertTrue(validParenthesis.isValidParenthesis(input))
    }
    @Test
    fun assertExample2IsValid() {
        val input = "()[]{}"

        assertTrue(validParenthesis.isValidParenthesis(input))
    }
    @Test
    fun assertExample3IsValid() {
        val input = "(]"

        assertFalse(validParenthesis.isValidParenthesis(input))
    }
    @Test
    fun assertExample4IsValid() {
        val input = "([])"

        assertTrue(validParenthesis.isValidParenthesis(input))
    }
    @Test
    fun assertExample5IsValid() {
        val input = "["

        assertFalse(validParenthesis.isValidParenthesis(input))
    }

}