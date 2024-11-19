import org.example.BinaryTreeSumOfAllNodes
import org.example.BinaryTreeSumOfAllNodes.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeSumOfAllNodesTest {
    val binaryTreeSumOfAllNodes = BinaryTreeSumOfAllNodes()
    @Test
    fun shouldSumAllNodes(){
        val treeNode1 = TreeNode(1)
        val treeNode3 = TreeNode(3)
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
        assertEquals(32, binaryTreeSumOfAllNodes.solve(treeNode4))
    }
}