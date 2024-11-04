import org.example.Permutations
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class PermutationsTest {
    val permutations = Permutations()

    @Test
    fun shouldReturnAllPossiblePermutationsComplexCase() {
        val input = intArrayOf(1, 2, 3)
        val expectedOutput = listOf<List<Int>>(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )

        assertContentEquals(expectedOutput, permutations.permute(input))
    }

    @Test
    fun shouldReturnAllPossiblePermutationsSimpleCase() {
        val input = intArrayOf(0, 1)
        val expectedOutput = listOf<List<Int>>(
            listOf(0, 1),
            listOf(1, 0),
        )
        assertContentEquals(expectedOutput, permutations.permute(input))

    }

    @Test
    fun shouldReturnAllPossiblePermutationsSingleton() {
        val input = intArrayOf(1)
        val expectedOutput = listOf<List<Int>>(listOf(1))

        assertContentEquals(expectedOutput, permutations.permute(input))

    }
}