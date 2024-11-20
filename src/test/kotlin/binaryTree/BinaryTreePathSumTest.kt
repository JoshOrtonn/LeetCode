package binaryTree

import org.example.binaryTree.BinaryTreePathSum
import org.example.binaryTree.BinaryTreePathSum.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinaryTreePathSumTest {
    private val binaryTreePathSum = BinaryTreePathSum()

    @Test
    fun shouldFindPathSumMatchingTarget() {
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
        assertTrue(binaryTreePathSum.solveHelper(17, treeNode4))
    }

    @Test
    fun shouldNotFindAnyPathSumWithTarget() {
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
        assertFalse(binaryTreePathSum.solveHelper(13, treeNode4))
    }

    @Test
    fun shouldFindPathSumMatchingTargetWithoutListUsage() {
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
        assertTrue(binaryTreePathSum.solvePathSumWithoutList(treeNode4, 17))
    }

    @Test
    fun shouldNotFindAnyPathSumWithTargetWithoutListUsage() {
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
        assertFalse(binaryTreePathSum.solvePathSumWithoutList(treeNode4, 13))
    }
}