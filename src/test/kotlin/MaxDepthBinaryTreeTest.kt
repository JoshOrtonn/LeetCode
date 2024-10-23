import org.example.MaxDepthBinaryTree
import org.example.MaxDepthBinaryTree.*
import kotlin.test.Test
import kotlin.test.assertEquals

class MaxDepthBinaryTreeTest{
    val maxDepthBinaryTree = MaxDepthBinaryTree()

    @Test
    fun shouldSolveForCase1() {
        val treeNode15 = TreeNode(15)
        val treeNode7 = TreeNode(7)
        val treeNode20 = TreeNode(20).apply {
            left = treeNode15
            right = treeNode7
        }
        val treeNode9 = TreeNode(9)
        val root = TreeNode(3).apply {
            left = treeNode9
            right = treeNode20
        }

        assertEquals(3, maxDepthBinaryTree.maxDepth(root))
    }

    @Test
    fun shouldSolveForCase2() {
        val node2 = TreeNode(2)
        val root = TreeNode(1).apply { right = node2 }

        assertEquals(2, maxDepthBinaryTree.maxDepth(root))
    }

    @Test
    fun shouldSolveForCase1Iterative() {
        val treeNode15 = TreeNode(15)
        val treeNode7 = TreeNode(7)
        val treeNode20 = TreeNode(20).apply {
            left = treeNode15
            right = treeNode7
        }
        val treeNode9 = TreeNode(9)
        val root = TreeNode(3).apply {
            left = treeNode9
            right = treeNode20
        }

        assertEquals(3, maxDepthBinaryTree.maxDepthIterative(root))
    }

    @Test
    fun shouldSolveForCase2Iterative() {
        val node2 = TreeNode(2)
        val root = TreeNode(1).apply { right = node2 }

        assertEquals(2, maxDepthBinaryTree.maxDepthIterative(root))
    }
}