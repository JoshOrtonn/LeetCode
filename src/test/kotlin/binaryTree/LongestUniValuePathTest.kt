package binaryTree

import org.example.binaryTree.LongestUniValuePath
import org.example.binaryTree.LongestUniValuePath.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestUniValuePathTest{
    val longestUniValuePath = LongestUniValuePath()

    /**
     *  * Example 1:
     *  *                              1
     *  *                            4     5
     *  *                          4  4   5
     *  *
     *  *
     *  * Output: 2, given longest path of same value is 4 → 4 → 4
     *  *
     */
    @Test
    fun shouldCalculateLongestUniValuePathExample1(){
        val treeNodeLeaf1 = TreeNode(4)
        val treeNodeLeaf2 = TreeNode(4)
        val treeNodeLeaf3 = TreeNode(5)
        val treeNodeChild1 = TreeNode(4).apply {
            left = treeNodeLeaf1
            right = treeNodeLeaf2
        }
        val treeNodeChild2 = TreeNode(5).apply {
            left = treeNodeLeaf3
        }
        val treeNodeRoot = TreeNode(1).apply {
            left = treeNodeChild1
            right = treeNodeChild2
        }
        assertEquals(2, longestUniValuePath.solveHelper(treeNodeRoot))

    }

    /**
     *   *  * Example 2:
     *      *  *
     *      *  *                            1
     *      *  *                          1   1
     *      *  *                        1  1 1 1
     *      *  * Output: 4
     *      *  *
     *      *  * Longest path is 1 → 1 → 1 → 1
     *      *  *
     */
    @Test
    fun shouldCalculateDiameterOfTreeExample2(){
        val treeNodeLeaf1 = TreeNode(1)
        val treeNodeLeaf2 = TreeNode(1)
        val treeNodeLeaf3 = TreeNode(1)
        val treeNodeLeaf4 = TreeNode(1)
        val treeNodeChild1 = TreeNode(1).apply {
            left = treeNodeLeaf1
            right = treeNodeLeaf2
        }
        val treeNodeChild2 = TreeNode(1).apply {
            left = treeNodeLeaf3
            right = treeNodeLeaf4
        }
        val treeNodeRoot = TreeNode(1).apply {
            left = treeNodeChild1
            right = treeNodeChild2
        }
        assertEquals(4, longestUniValuePath.solveHelper(treeNodeRoot))
    }
}