import org.example.Fibbonaci
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FibbonaciTest{

    val fibbonaci = Fibbonaci()
    @Test
    fun isCorrectF3(){
        assertEquals(2, fibbonaci.solve(3))
    }
    @Test
    fun isCorrectF4(){
        assertEquals(3, fibbonaci.solve(4))
    }
    @Test
    fun isCorrectF8(){
        assertEquals(21, fibbonaci.solve(8))
    }

    @Test
    fun isCorrectF3Memoized(){
        assertEquals(2, fibbonaci.solveWithMemoization(3))
    }
    @Test
    fun isCorrectF4Memoized(){
        assertEquals(3, fibbonaci.solveWithMemoization(4))
    }
    @Test
    fun isCorrectF8Memoized(){
        assertEquals(21, fibbonaci.solveWithMemoization(8))
    }
}