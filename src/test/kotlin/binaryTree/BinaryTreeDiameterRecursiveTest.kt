package binaryTree

import org.example.binaryTree.BinaryTreeDiameter.TreeNode
import org.example.binaryTree.BinaryTreeDiameterRecursive
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeDiameterRecursiveTest{
    private val binaryTreeDiameter = BinaryTreeDiameterRecursive()
    @Test
    fun shouldFindDiameterRecursive() {
        val treeNode5 = TreeNode(5)
        val treeNode4 = TreeNode(4)
        val treeNode3 = TreeNode(3)
        val treeNode2 = TreeNode(2).apply {
            left = treeNode4
            right = treeNode5
        }
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
            right = treeNode3
        }
        assertEquals(3, binaryTreeDiameter.diameterOfBinaryTreeRecursiveHelper(treeNode1))
    }
    @Test
    fun shouldFindDiameterEasierExampleRecursive() {
        val treeNode2 = TreeNode(2)
        val treeNode1 = TreeNode(1).apply {
            right = treeNode2
        }
        assertEquals(1, binaryTreeDiameter.diameterOfBinaryTreeRecursiveHelper(treeNode1))
    }
    @Test
    fun shouldFindDiameterEasierExampleRecursiveV2() {
        val treeNode2 = TreeNode(2)
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
        }
        assertEquals(1, binaryTreeDiameter.diameterOfBinaryTreeRecursiveHelper(treeNode1))
    }
    @Test
    fun shouldFindDiameterEasierExampleEdgeCase() {
        val treeNode1 = TreeNode(1)

        assertEquals(0, binaryTreeDiameter.diameterOfBinaryTreeRecursiveHelper(treeNode1))
    }
    @Test
    fun shouldFindDiameterEasierExampleEdgeCase2() {
        val treeNode1 = TreeNode(1)
        val treeNode3 = TreeNode(3).apply { left = treeNode1 }
        val treeNode2 = TreeNode(2).apply {
            left = treeNode3
        }

        assertEquals(2, binaryTreeDiameter.diameterOfBinaryTreeRecursiveHelper(treeNode2))
    }
}