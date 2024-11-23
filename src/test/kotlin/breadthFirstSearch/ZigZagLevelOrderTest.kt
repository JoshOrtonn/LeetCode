package breadthFirstSearch

import org.example.breadthFirstSearch.TreeNode
import org.example.breadthFirstSearch.ZigZagLevelOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ZigZagLevelOrderTest {
    val zigZagLevelOrder = ZigZagLevelOrder()

    @Test
    fun shouldReturnZigZagLevelOrderEx1() {
        val treeNode7 = TreeNode(7)
        val treeNode8 = TreeNode(8)
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
        val expectedOutput = listOf(listOf(1), listOf(4,3), listOf(2,7), listOf(8))
        assertEquals(expectedOutput, zigZagLevelOrder.solve(treeNode1))
    }

    @Test
    fun shouldReturnZigZagLevelOrderEx2() {
        val treeNode9 = TreeNode(9)
        val treeNode6 = TreeNode(6)
        val treeNode5 = TreeNode(5)
        val treeNode2Leaf = TreeNode(2)

        val treeNode3 = TreeNode(3).apply {
            right = treeNode2Leaf
        }
        val treeNode1 = TreeNode(1).apply {
            right = treeNode5
        }
        val treeNode2 = TreeNode(2).apply{
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
        // [[4], [7, 2], [1, 3, 6, 9], [2, 5]]
        val expectedOutput = listOf(listOf(4), listOf(7,2), listOf(1,3,6,9), listOf(2,5))
        assertEquals(expectedOutput, zigZagLevelOrder.solve(treeNode4))
    }
}