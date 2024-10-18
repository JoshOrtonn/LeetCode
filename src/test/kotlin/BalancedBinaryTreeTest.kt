import org.example.BalancedBinaryTree
import org.example.BalancedBinaryTree.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BalancedBinaryTreeTest{
    val balancedBinaryTree = BalancedBinaryTree()

    @Test
    fun assertFalseForUnbalancedTree() {
        val treeNode2R = TreeNode(2)
        val treeNode3R = TreeNode(3)
        val treeNode4R = TreeNode(4)
        val treeNode4L = TreeNode(4)
        val treeNode3L = TreeNode(3).apply {
            left = treeNode4L
            right = treeNode4R
        }
        val treeNode2L = TreeNode(2).apply {
            left = treeNode3L
            right = treeNode3R
        }
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2L
            right = treeNode2R
        }

        assertFalse(balancedBinaryTree.isBalanced(treeNode1))
    }

    @Test
//    [3,9,20,null,null,15,7]
    fun assertTrueForBalancedTree() {
        val treeNode15 = TreeNode(15)
        val treeNode7 = TreeNode(7)
        val treeNode9 = TreeNode(9)
        val treeNode20 = TreeNode(20).apply {
            left = treeNode15
            right = treeNode7
        }
        val treeNode3 = TreeNode(3).apply {
            left = treeNode9
            right = treeNode20
        }

        assertTrue(balancedBinaryTree.isBalanced(treeNode3))
    }

    @Test
    fun assertTrueForEmptyTree() {
        assertTrue(balancedBinaryTree.isBalanced(null))
    }

    @Test
    fun assertTrueForRightOnlyBinaryTree() {
        /*
                1
                    2
                        3
         */
        val treeNode3 = TreeNode(3)
        val treeNode2 = TreeNode(2).apply { right = treeNode3 }
        val treeNode1 = TreeNode(1).apply { right = treeNode2 }
        assertFalse(balancedBinaryTree.isBalanced(treeNode1))
    }
}