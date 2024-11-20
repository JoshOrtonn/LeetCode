import org.example.BinaryTreeGoodNodes
import org.example.BinaryTreeGoodNodes.TreeNode
import org.example.BinaryTreeGoodNodesList
import org.example.BinaryTreeGoodNodesList.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class BinaryTreeGoodNodesTest {
    @Test
    fun shouldFindGoodNodes(){
        val binaryTreeGoodNodes = BinaryTreeGoodNodes()

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

        assertEquals(3, binaryTreeGoodNodes.solveHelper(treeNode4))
    }

    @Test
    fun shouldFindGoodNodesList(){
        val binaryTreeGoodNodesList = BinaryTreeGoodNodesList()

        val treeNode3 = BinaryTreeGoodNodesList.TreeNode(3)
        val treeNode1 = BinaryTreeGoodNodesList.TreeNode(1)
        val treeNode6 = BinaryTreeGoodNodesList.TreeNode(6)
        val treeNode9 = BinaryTreeGoodNodesList.TreeNode(9)
        val treeNode2 = BinaryTreeGoodNodesList.TreeNode(2).apply {
            left = treeNode1
            right = treeNode3
        }
        val treeNode7 = BinaryTreeGoodNodesList.TreeNode(7).apply {
            left = treeNode6
            right = treeNode9
        }
        val treeNode4 = BinaryTreeGoodNodesList.TreeNode(4).apply {
            left = treeNode2
            right = treeNode7
        }

        val expectedOutput: List<Int> = listOf(4,7,9)
        assertContentEquals(expectedOutput, binaryTreeGoodNodesList.solveHelper(treeNode4))
    }
}