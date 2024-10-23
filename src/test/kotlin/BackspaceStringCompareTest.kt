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

    @Test
    fun shouldSolveForTrueCaseMemory(){
        val s = "ab#c"
        val t = "ad#c"
        assertTrue(backspaceStringCompare.backspaceCompareSolvedForMemory(s, t))

    }

    @Test
    fun shouldSolveForFalseCaseMemory(){
        val s = "a#c"
        val t = "b"
        assertFalse(backspaceStringCompare.backspaceCompareSolvedForMemory(s, t))

    }

    @Test
    fun shouldSolveForFalseCase1Memory(){
        val s = "bxj##tw"
        val t = "bxj###tw"
        assertFalse(backspaceStringCompare.backspaceCompareSolvedForMemory(s, t))
    }

    @Test
    fun shouldSolveForEmptyStringMemory(){
        val s = "ab##"
        val t = "c#d#"
        assertTrue(backspaceStringCompare.backspaceCompareSolvedForMemory(s, t))

    }

    @Test
    fun shouldSolveForTrueCaseMemoryV2(){
        val s = "ab#c"
        val t = "ad#c"
        assertTrue(backspaceStringCompare.backspaceCompareSolvedForMemoryV2(s, t))

    }

    @Test
    fun shouldSolveForFalseCaseMemoryV2(){
        val s = "a#c"
        val t = "b"
        assertFalse(backspaceStringCompare.backspaceCompareSolvedForMemoryV2(s, t))

    }

    @Test
    fun shouldSolveForFalseCase1MemoryV2(){
        val s = "bxj##tw"
        val t = "bxj###tw"
        assertFalse(backspaceStringCompare.backspaceCompareSolvedForMemoryV2(s, t))
    }

    @Test
    fun shouldSolveForEmptyStringMemoryV2(){
        val s = "ab##"
        val t = "c#d#"
        assertTrue(backspaceStringCompare.backspaceCompareSolvedForMemoryV2(s, t))

    }
}