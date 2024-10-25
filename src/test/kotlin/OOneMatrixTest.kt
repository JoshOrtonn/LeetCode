import org.example.OOneMatrix
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class OOneMatrixTest{
    val oOneMatrix = OOneMatrix()

    // TODO figure this shit out.
    @Test
    fun shouldSolveForMatrixEx1(){
        val input = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(0,0,0))
        val expectedOutput = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(0,0,0))

        val result = oOneMatrix.updateMatrix(input)
        expectedOutput.forEachIndexed { index, it ->
            assertContentEquals(it, result[index])
        }
    }

    @Test
    fun shouldSolveForMatrixEx2(){
        val input = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(1,1,1))
        val expectedOutput = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(1,2,1))

        val result = oOneMatrix.updateMatrix(input)
        expectedOutput.forEachIndexed { index, it ->
            assertContentEquals(it, result[index])
        }
    }

}