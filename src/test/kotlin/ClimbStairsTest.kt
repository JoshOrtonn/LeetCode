import org.example.ClimbStairs
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ClimbStairsTest{
    @ParameterizedTest
    @MethodSource("providePermutationsForSteps")
    fun shouldBeNPermsWithMSteps(input: Int, expectedOutput: Int){
        val climbStairs = ClimbStairs()
        assertEquals(expectedOutput,climbStairs.climbStairs(input))
    }

    @ParameterizedTest
    @MethodSource("providePermutationsForSteps")
    fun shouldBeNPermsWithMStepsMemoized(input: Int, expectedOutput: Int){
        val climbStairs = ClimbStairs()
        assertEquals(expectedOutput, climbStairs.climbStairsMemoized(input))
    }


    companion object {
        @JvmStatic
        private fun providePermutationsForSteps(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(6, 13),
                Arguments.of(7, 21),
            )
        }
    }
}