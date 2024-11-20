import org.example.BinarySearchTreeValidation
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinarySearchTreeValidationTest{
    val binarySearchTreeValidation = BinarySearchTreeValidation()
    @Test
    fun shouldValidateBinarySearchTreeAsTrue(){
        val treeNode1 = BinarySearchTreeValidation.TreeNode(1)
        val treeNode3 = BinarySearchTreeValidation.TreeNode(3)
        val treeNode2 = BinarySearchTreeValidation.TreeNode(2).apply {
            left = treeNode1
            right = treeNode3
        }

        assertTrue(binarySearchTreeValidation.solveHelper(treeNode2))
    }

    @Test
    fun shouldValidateBinarySearchTreeAsFalse(){
        val treeNode1 = BinarySearchTreeValidation.TreeNode(1)
        val treeNode3 = BinarySearchTreeValidation.TreeNode(3)
        val treeNode6 = BinarySearchTreeValidation.TreeNode(6)
        val treeNode5 = BinarySearchTreeValidation.TreeNode(5).apply {
            left = treeNode3
            right = treeNode6
        }
        val treeNode4 = BinarySearchTreeValidation.TreeNode(4).apply {
            left = treeNode1
            right = treeNode5
        }

        assertFalse(binarySearchTreeValidation.solveHelper(treeNode4))
    }
}