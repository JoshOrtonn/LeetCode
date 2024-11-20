package binaryTree

import org.example.binaryTree.BinaryTreeMaxValue
import org.example.binaryTree.BinaryTreeMaxValue.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class BinaryTreeMaxValueTest {
    val binaryTreeMaxValue = BinaryTreeMaxValue()
    @Test
    fun shouldFindMaxNodeInTree(){
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
        assertEquals(9, binaryTreeMaxValue.solve(treeNode4))
    }
}