import org.example.CoinChange
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CoinChangeTest {
    private val coinChange = CoinChange()

    @Test
    fun shouldProvideFewestCoinsEx1() {
        val coinsDenoms = intArrayOf(1,2,5)
        val amount = 11
        assertEquals(3, coinChange.fewestNumberOfCoins(coinsDenoms, amount))
    }

    @Test
    fun shouldProvideFewestCoinsEx2() {
        val coinsDenoms = intArrayOf(2)
        val amount = 3
        assertEquals(-1, coinChange.fewestNumberOfCoins(coinsDenoms, amount))
    }
    @Test
    fun shouldProvideFewestCoinsEx3() {
        val coinsDenoms = intArrayOf(1)
        val amount = 0
        assertEquals(0, coinChange.fewestNumberOfCoins(coinsDenoms, amount))
    }
}