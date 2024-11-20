import org.example.BinaryTreePathSum2
import org.example.BinaryTreePathSum2.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class BinaryTreePathSum2Test {
    private val binaryTreePathSum = BinaryTreePathSum2()

    @Test
    fun shouldFindPathSumMatchingTarget() {
        val treeNode8 = TreeNode(8)
        val treeNode7 = TreeNode(7)
        val treeNode10 = TreeNode(10)
        val treeNode5 = TreeNode(5)
        val treeNode2 = TreeNode(2).apply {
            left = treeNode8
            right = treeNode7
        }
        val treeNode4 = TreeNode(4).apply {
            left = treeNode5
            right = treeNode10
        }
        val treeNode1 = TreeNode(1).apply {
            left = treeNode2
            right = treeNode4
        }
        assertContentEquals(listOf(listOf(1,2,7), listOf(1,4,5)), binaryTreePathSum.solveHelper(treeNode1, 10))
    }

}