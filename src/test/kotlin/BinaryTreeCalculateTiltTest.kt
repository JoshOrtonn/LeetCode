import org.example.BinaryTreeCalculateTilt
import org.example.BinaryTreeCalculateTilt.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeCalculateTiltTest{
    val binaryTreeCalculateTilt = BinaryTreeCalculateTilt()

    @Test
    fun shouldCalculateBinarySearchTree() {
        val treeNode1 = TreeNode(1)
        val treeNode3 = TreeNode(3)
        val treeNode5 = TreeNode(5).apply {
            left = treeNode1
            right = treeNode3
        }
        assertEquals(2, binaryTreeCalculateTilt.solveHelper(treeNode5))
    }
    @Test
    fun shouldCalculateComplexBinarySearchTree() {
        val treeNode3 = TreeNode(3)
        val treeNode1 = TreeNode(1)
        val treeNode6 = TreeNode(6)
        val treeNode9 = TreeNode(9)
        val treeNode2 = TreeNode(2).apply {
            left = treeNode1
            right = treeNode3
        }
        val treeNode7 = TreeNode(7).apply {
            left = treeNode6
            right = treeNode9
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode2
            right = treeNode7
        }
        assertEquals(21, binaryTreeCalculateTilt.solveHelper(treeNode4))

    }
}