package breadthFirstSearch

import MaxWidth
import MaxWidth.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxWidthTest {
    val maxWidth = MaxWidth()

    @Test
    fun shouldReturnZigZagLevelOrderEx1() {
        val treeNode9 = TreeNode(9)
        val treeNode1 = TreeNode(1)
        val treeNode2 = TreeNode(2).apply {
            left = treeNode1
        }
        val treeNode7 = TreeNode(7).apply {
            right = treeNode9
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode2
            right = treeNode7
        }

        assertEquals(4, maxWidth.solve(treeNode4))
    }

    @Test
    fun shouldReturnMaxWidthEx2() {
        val treeNode9 = TreeNode(9).apply {
            left = TreeNode(1)
        }
        val treeNode6 = TreeNode(6).apply {
            right = TreeNode(1)
        }
        val treeNode1 = TreeNode(1).apply {
            left = TreeNode(7)
        }
        val treeNode2 = TreeNode(2).apply {
            left = treeNode1
        }
        val treeNode7 = TreeNode(7).apply {
            left = treeNode6
            right = treeNode9
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode2
            right = treeNode7
        }
        assertEquals(7, maxWidth.solve(treeNode4))
    }

    @Test
    fun shouldReturnMaxWidthEx3() {
        val treeNode2 = TreeNode(2).apply {
            left = TreeNode(1)
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode2
            right = TreeNode(7)
        }
        assertEquals(2, maxWidth.solve(treeNode4))
    }
}
