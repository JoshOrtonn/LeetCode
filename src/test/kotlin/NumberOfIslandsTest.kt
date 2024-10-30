import org.example.NumberOfIslands
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfIslandsTest {
    val numberOfIslands = NumberOfIslands()

    @Test
    fun shouldCountNumberOfIslandsEx1(){
/*
        Input: grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        Output: 1

 */
        val grid =  arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0'))
        assertEquals(1, numberOfIslands.numIslands(grid))
    }

    @Test
    fun shouldCountNumberOfIslandsEx2(){
/*
        Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 */
        val grid =  arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1'))
        assertEquals(3, numberOfIslands.numIslands(grid))
    }

}