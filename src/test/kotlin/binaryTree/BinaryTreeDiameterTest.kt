package binaryTree

import org.example.binaryTree.BinaryTreeDiameter
import org.example.binaryTree.BinaryTreeDiameter.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeDiameterTest{
    private val binaryTreeDiameter = BinaryTreeDiameter()


    @Test
    fun shouldFindDiameter() {
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
        assertEquals(3, binaryTreeDiameter.diameterOfBinaryTree(treeNode1))
    }
    @Test
    fun shouldFindDiameterEasierExample() {
        val treeNode2 = TreeNode(2)
        val treeNode1 = TreeNode(1).apply {
            right = treeNode2
        }
        assertEquals(1, binaryTreeDiameter.diameterOfBinaryTree(treeNode1))
    }



    @Test
    fun shouldFindDiameterEasierExampleV2() {
        val treeNode2 = TreeNode(2)
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
        }
        assertEquals(1, binaryTreeDiameter.diameterOfBinaryTree(treeNode1))
    }


    @Test
    fun shouldFindDiameterEasierExampleEdgeCaseIterative() {
        val treeNode1 = TreeNode(1)

        assertEquals(0, binaryTreeDiameter.diameterOfBinaryTree(treeNode1))
    }

    @Test
    fun shouldFindDiameterEasierExampleEdgeCaseIterative2() {
        val treeNode1 = TreeNode(1)
        val treeNode3 = TreeNode(3).apply { left = treeNode1 }
        val treeNode2 = TreeNode(2).apply {
            left = treeNode3
        }

        assertEquals(2, binaryTreeDiameter.diameterOfBinaryTree(treeNode2))
    }
}