import org.example.BinaryTreeFindTarget
import org.example.BinaryTreeFindTarget.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinaryTreeFindTargetTest{
    private val binaryTreeFindTarget = BinaryTreeFindTarget()

    @Test
    fun shouldFindTargetInBinaryTree() {
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

        assertTrue(binaryTreeFindTarget.findTarget(3, treeNode4))
    }

    @Test
    fun shouldNotFindTargetInBinaryTree() {
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
        assertFalse(binaryTreeFindTarget.findTarget(18, treeNode4))
    }

}