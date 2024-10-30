import org.example.ValidateBinarySearchTree
import org.example.ValidateBinarySearchTree.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class ValidateBinarySearchTreeTest {
    val validateBinarySearchTree = ValidateBinarySearchTree()

    @Test
    fun shouldBeTrueForCase1() {
        val node1 = TreeNode(1)
        val node3 = TreeNode(3)
        val root = TreeNode(2).apply {
            left = node1
            right = node3
        }
        assertTrue(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeFalseForCase2() {
        val node1 = TreeNode(1)
        val node3 = TreeNode(3)
        val node6 = TreeNode(6)
        val node4 = TreeNode(4).apply {
            left = node3
            right = node6
        }

        val root = TreeNode(5).apply {
            left = node1
            right = node4
        }


        // Explanation: The root node's value is 5 but its right child's value is 4.
        assertFalse(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeFalseForCase3() {
        //[5,4,6,null,null,3,7]
        val node7 = TreeNode(7)
        val node3 = TreeNode(3)
        val node6 = TreeNode(6).apply {
            left = node3
            right = node7
        }
        val node4 = TreeNode(4).apply {
            left = node3
            right = node6
        }

        val root = TreeNode(5).apply {
            left = node4
            right = node6
        }

        // Explanation: The root node's value is 5 but its right child's value is 4.
        assertFalse(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeFalseForCase4() {
        //[5,4,6,null,null,3,7]
        val node7 = TreeNode(7)
        val node3 = TreeNode(3)
        val node6 = TreeNode(6).apply {
            left = node3
            right = node7
        }
        val node4 = TreeNode(4).apply {
            left = node3
            right = node6
        }

        val root = TreeNode(5).apply {
            left = node4
            right = node6
        }

        // Explanation: The root node's value is 5 but its right child's value is 4.
        assertFalse(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeFalseForCase5() {
        /*

                            32
                        26      47
                    19              56
                        27
         */
        //[32,26,47,19,null,null,56,null,27]
        val node27 = TreeNode(27)
        val node19 = TreeNode(19).apply {
            right = node27
        }
        val node26 = TreeNode(26).apply {
            left = node19
        }

        val node56 = TreeNode(56)

        val node47 = TreeNode(47).apply {
            right = node56
        }

        val root = TreeNode(32).apply {
            left = node26
            right = node47
        }

        // Explanation: The root node's value is 5 but its right child's value is 4.
        assertFalse(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeFalseForCase6() {
        /*

                            32
                        26      47
                    19              56
                                 48    54




         */
        //[32,26,47,19,null,null,56,null, 48, 54]
        val node48 = TreeNode(48)
        val node54 = TreeNode(54)
        val node19 = TreeNode(19)
        val node26 = TreeNode(26).apply {
            left = node19
        }

        val node56 = TreeNode(56).apply {
            left = node48
            right = node54
        }

        val node47 = TreeNode(47).apply {
            right = node56
        }

        val root = TreeNode(32).apply {
            left = node26
            right = node47
        }

        assertFalse(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeTrueForCase7() {
        /*[3,1,5,0,2,4,6]

                            3
                         1       5
                       0  2    4  6


         */
        //[32,26,47,19,null,null,56,null, 48, 54]
        val node4 = TreeNode(4)
        val node6 = TreeNode(6)
        val node0 = TreeNode(0)
        val node2 = TreeNode(2)

        val node5 = TreeNode(5).apply {
            left = node4
            right = node6
        }

        val node1 = TreeNode(1).apply {
            left = node0
            right = node2
        }

        val root = TreeNode(3).apply {
            left = node1
            right = node5
        }

        assertTrue(validateBinarySearchTree.isValidBST(root))
    }

    @Test
    fun shouldBeTrueForCase8() {
//        [3,null,30,10,null,null,15,null,45]

        /*

                        3
                            30
                          10
                              15
                                 45


         */
        val node45 = TreeNode(45)
        val node15 = TreeNode(15).apply { right = node45 }
        val node10 = TreeNode(10).apply {
            right = node15
        }

        val node30 = TreeNode(30).apply {
            left = node10
        }

        val root = TreeNode(3).apply {
            right = node30
        }

        assertFalse(validateBinarySearchTree.isValidBST(root))
    }

}