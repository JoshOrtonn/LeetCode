package breadthFirstSearch

import org.example.breadthFirstSearch.LevelOrderTraversal
import org.example.breadthFirstSearch.LevelOrderTraversal.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class BinaryTreeLevelOrderTraversalTest{
    val binaryTreeLevelOrderTraversal = LevelOrderTraversal()

    @Test
    fun shouldProvideTreeLevelsEx1() {
        val treeNodeLevelTwo4 = TreeNode(6)
        val treeNodeLevelTwo3 = TreeNode(11)
        val treeNodeLevelTwo2 = TreeNode(15)
        val treeNodeLevelTwo1 = TreeNode(7)
        val treeNodeLevelOneLeft = TreeNode(9).apply {
            left = treeNodeLevelTwo4
            right = treeNodeLevelTwo3
        }
        val treeNodeLevelOneRight = TreeNode(20).apply {
            left = treeNodeLevelTwo2
            right = treeNodeLevelTwo1
        }
        val treeNodeRoot = TreeNode(3).apply {
            left = treeNodeLevelOneLeft
            right = treeNodeLevelOneRight
        }

        val expectedOutput = listOf(listOf(3),listOf(9,20),listOf(6, 11, 15,7))

        val result = binaryTreeLevelOrderTraversal.showLevelOrderPaths(treeNodeRoot)
        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
        assertContentEquals(expectedOutput[2], result[2])
    }

    @Test
    fun shouldProvideTreeLevelsEx2() {
        val treeNodeLevelTwo2 = TreeNode(15)
        val treeNodeLevelTwo1 = TreeNode(7)
        val treeNodeLevelOneLeft = TreeNode(9)
        val treeNodeLevelOneRight = TreeNode(20).apply {
            left = treeNodeLevelTwo2
            right = treeNodeLevelTwo1
        }
        val treeNodeRoot = TreeNode(3).apply {
            left = treeNodeLevelOneLeft
            right = treeNodeLevelOneRight
        }

        val expectedOutput = listOf(listOf(3),listOf(9,20),listOf(15,7))

        val result = binaryTreeLevelOrderTraversal.showLevelOrderPaths(treeNodeRoot)
        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
        assertContentEquals(expectedOutput[2], result[2])
    }

    @Test
    fun shouldProvideTreeLevelsEx3() {
        val treeNodeRoot = TreeNode(1)

        val expectedOutput = listOf(listOf(1))

        val result = binaryTreeLevelOrderTraversal.showLevelOrderPaths(treeNodeRoot)
        assertContentEquals(expectedOutput, result)
    }

    @Test
    fun shouldProvideTreeLevelsEx1Recursively() {
        val treeNodeLevelTwo4 = TreeNode(6)
        val treeNodeLevelTwo3 = TreeNode(11)
        val treeNodeLevelTwo2 = TreeNode(15)
        val treeNodeLevelTwo1 = TreeNode(7)
        val treeNodeLevelOneLeft = TreeNode(9).apply {
            left = treeNodeLevelTwo4
            right = treeNodeLevelTwo3
        }
        val treeNodeLevelOneRight = TreeNode(20).apply {
            left = treeNodeLevelTwo2
            right = treeNodeLevelTwo1
        }
        val treeNodeRoot = TreeNode(3).apply {
            left = treeNodeLevelOneLeft
            right = treeNodeLevelOneRight
        }

        val expectedOutput = listOf(listOf(3),listOf(9,20),listOf(6, 11, 15,7))

        val result = binaryTreeLevelOrderTraversal.showLevelOrderPaths(treeNodeRoot)
        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
        assertContentEquals(expectedOutput[2], result[2])
    }

    @Test
    fun shouldProvideTreeLevelsEx2Recursively() {
        val treeNodeLevelTwo2 = TreeNode(15)
        val treeNodeLevelTwo1 = TreeNode(7)
        val treeNodeLevelOneLeft = TreeNode(9)
        val treeNodeLevelOneRight = TreeNode(20).apply {
            left = treeNodeLevelTwo2
            right = treeNodeLevelTwo1
        }
        val treeNodeRoot = TreeNode(3).apply {
            left = treeNodeLevelOneLeft
            right = treeNodeLevelOneRight
        }

        val expectedOutput = listOf(listOf(3),listOf(9,20),listOf(15,7))

        val result = binaryTreeLevelOrderTraversal.showLevelOrderPaths(treeNodeRoot)
        assertContentEquals(expectedOutput[0], result[0])
        assertContentEquals(expectedOutput[1], result[1])
        assertContentEquals(expectedOutput[2], result[2])
    }

    @Test
    fun shouldProvideTreeLevelsEx3Recursively() {
        val treeNodeRoot = TreeNode(1)

        val expectedOutput = listOf(listOf(1))

        val result = binaryTreeLevelOrderTraversal.showLevelOrderPaths(treeNodeRoot)
        assertContentEquals(expectedOutput, result)
    }
}