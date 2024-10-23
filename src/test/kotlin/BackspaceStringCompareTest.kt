import org.example.BackspaceStringCompare
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BackspaceStringCompareTest {
    val backspaceStringCompare = BackspaceStringCompare()

    @Test
    fun shouldSolveForTrueCase(){
        val s = "ab#c"
        val t = "ad#c"
        assertTrue(backspaceStringCompare.backspaceCompare(s, t))

    }

    @Test
    fun shouldSolveForFalseCase(){
        val s = "a#c"
        val t = "b"
        assertFalse(backspaceStringCompare.backspaceCompare(s, t))

    }

    @Test
    fun shouldSolveForFalseCase1(){
        val s = "bxj##tw"
        val t = "bxj###tw"
        assertFalse(backspaceStringCompare.backspaceCompare(s, t))
    }

    @Test
    fun shouldSolveForEmptyString(){
        val s = "ab##"
        val t = "c#d#"
        assertTrue(backspaceStringCompare.backspaceCompare(s, t))

    }
}