import org.example.BinaryTreeMaxDepth
import org.example.BinaryTreeMaxDepth.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeMaxDepthTest{
    val binaryTreeMaxDepth = BinaryTreeMaxDepth()
    @Test
    fun shouldFindMaxDepth(){
        val treeNode8 = TreeNode(8)
        val treeNode1 = TreeNode(1).apply {
            right = treeNode8
        }
        val treeNode6 = TreeNode(6)
        val treeNode9 = TreeNode(9)
        val treeNode2 = TreeNode(2).apply {
            left = treeNode1
        }
        val treeNode7 = TreeNode(7).apply {
            left = treeNode6
            right = treeNode9
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode2
            right = treeNode7
        }

        assertEquals(4, binaryTreeMaxDepth.solveMaxDepth(treeNode4))
    }
}