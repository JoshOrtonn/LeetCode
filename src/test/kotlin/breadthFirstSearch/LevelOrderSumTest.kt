package breadthFirstSearch

import LevelOrderSum
import LevelOrderSum.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class LevelOrderSumTest {
    private val levelOrderSum = LevelOrderSum()
    @Test
    fun shouldMatchExpectedLevelOrderSumEx1() {
        val treeNode8 = TreeNode(8)
        val treeNode7 = TreeNode(7)
        val treeNode2 = TreeNode(2).apply {
            left = treeNode8
        }
        val treeNode3 = TreeNode(3).apply {
            right = treeNode2
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode7
        }
        val treeNode1 = TreeNode(1).apply {
            left = treeNode3
            right = treeNode4
        }
        val expectedOutput = listOf(1,7,9,8)
        assertEquals(expectedOutput, levelOrderSum.solve(treeNode1))
    }
    @Test
    fun shouldMatchExpectedLevelOrderSumEx2() {
        val treeNode5 = TreeNode(5)
        val treeNode4 = TreeNode(4)
        val treeNode3 = TreeNode(3).apply {
            left = treeNode4
        }
        val treeNode2 = TreeNode(2).apply {
            left = treeNode3
        }

        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
            right = treeNode5
        }
        val expectedOutput = listOf(1,7,3,4)
        assertEquals(expectedOutput, levelOrderSum.solve(treeNode1))
    }
}