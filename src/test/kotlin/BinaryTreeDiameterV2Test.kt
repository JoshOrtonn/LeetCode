import org.example.BinaryTreeDiameterV2
import org.example.BinaryTreeDiameterV2.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeDiameterV2Test{
    val binaryTreeDiameterV2 = BinaryTreeDiameterV2()

    /**
     *  * Example 1:
     *  *                              3
     *  *                            9    2
     *  *                          1   4
     *  *                           5
     *  *
     *  * Output: 4, given longest path is 5 → 1 → 9 → 3 →2
     *  *
     */
    @Test
    fun shouldCalculateDiameterOfTreeExample1(){
        val treeNode2 = TreeNode(2)
        val treeNode5 = TreeNode(5)
        val treeNode1 = TreeNode(1).apply {
            right = treeNode5
        }
        val treeNode4 = TreeNode(4)
        val treeNode9 = TreeNode(9).apply {
            left = treeNode1
            right = treeNode4
        }
        val treeNode3 = TreeNode(3).apply {
            left = treeNode9
            right = treeNode2
        }
        assertEquals(4, binaryTreeDiameterV2.solveHelper(treeNode3))

    }

    /**
     *   *  * Example 2:
     *      *  *                               3
     *      *  *                            9
     *      *  *                          1   4
     *      *  *                        2    5
     *      *  * Output: 4
     *      *  *
     *      *  * Longest path is 2 → 1 → 9 → 4 → 3
     *      *  *
     */
    @Test
    fun shouldCalculateDiameterOfTreeExample2(){
        val treeNode2 = TreeNode(2)
        val treeNode5 = TreeNode(5)
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
        }
        val treeNode4 = TreeNode(4).apply { left = treeNode5 }
        val treeNode9 = TreeNode(9).apply {
            left = treeNode1
            right = treeNode4
        }
        val treeNode3 = TreeNode(3).apply {
            left = treeNode9
        }
        assertEquals(4, binaryTreeDiameterV2.solveHelper(treeNode3))
    }
}