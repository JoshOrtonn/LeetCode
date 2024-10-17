import org.example.InvertBinaryTree
import org.example.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class InvertBinaryTreeTest{
    val solution = InvertBinaryTree()
    @Test
    fun shouldInvertTreeEx1() {
        val treeNode4 = TreeNode(4)
        val treeNode2 = TreeNode(2)
        val treeNode7 = TreeNode(7)
        val treeNode1 = TreeNode(1)
        val treeNode3 = TreeNode(3)
        val treeNode6 = TreeNode(6)
        val treeNode9 = TreeNode(9)
        treeNode2.left = treeNode1
        treeNode2.right = treeNode3
        treeNode7.left = treeNode6
        treeNode7.right = treeNode9
        treeNode4.left = treeNode2
        treeNode4.right = treeNode7

        val input = treeNode4


        val solved = solution.invertTree(input)

        val expectedTreeNode4 = TreeNode(4)
        expectedTreeNode4.right = treeNode2
        expectedTreeNode4.left = treeNode7
        expectedTreeNode4.left?.left = treeNode9
        expectedTreeNode4.left?.right = treeNode6
        expectedTreeNode4.right?.left = treeNode3
        expectedTreeNode4.right?.right = treeNode1
        assertNotNull(solved?.left)
        assertEquals(expectedTreeNode4.left, solved?.left)
        assertNotNull(solved?.right)
        assertEquals(expectedTreeNode4.right, solved?.right)
        assertNotNull(solved?.left?.right)
        assertEquals(expectedTreeNode4.left?.right, solved?.left?.right)
        assertNotNull(solved?.left?.left)
        assertEquals(expectedTreeNode4.left?.left, solved?.left?.left)
        assertNotNull(solved?.right?.left)
        assertEquals(expectedTreeNode4.right?.left, solved?.right?.left)
        assertNotNull(solved?.right?.right)
        assertEquals(expectedTreeNode4.right?.right, solved?.right?.right)

    }
}