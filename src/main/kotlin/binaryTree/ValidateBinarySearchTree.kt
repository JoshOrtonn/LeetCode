package org.example.binaryTree

/**
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
class ValidateBinarySearchTree {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     */
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        // Helper function that checks if the tree is a valid BST within the range (low, high)
        // Start the recursion with the entire range of valid values for a BST
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun helper(node: TreeNode?, low: Long, high: Long): Boolean {
        // Base case: null nodes are valid BSTs
        if (node == null) {
            return true
        }
        // The current node's value must be greater than 'low' and less than 'high'
        if (node.`val` <= low || node.`val` >= high) {
            return false
        }
        // Recursively validate the left and right subtrees
        // Left subtree values must be < node.`val`
        // Hence pass along current node as high value
        val left = helper(node.left, low, node.`val`.toLong())
        // Right subtree values must be > node.`val`,
        // hence pass along the current node as the new low given we need the right subtree below to > than.
        val right = helper(node.right, node.`val`.toLong(), high)
        // Return true if both subtrees are valid
        return left && right
    }
}