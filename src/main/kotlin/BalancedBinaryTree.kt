package org.example

import kotlin.math.abs

/**
 *
 * Given a binary tree, determine if it is height balanced,
 * meaning the depth of two subtrees at any node is never more than one.
 *
 * A height balanced binary tree is a binary tree in which the height of the left subtree
 * and right subtree of any node does not differ by more than 1.
 *
 * Example 1. True
 *              3
 *           9    20
 *              15  7
 *
 *
 * Example 2. False as two more subtrees below value 2.
 *                          1
 *                      2        2
 *                   3    3
 *                 4  4
 *
 *
 * Example 3.  False as two more subtrees below 1.
 *
 *                 1
 *                     2
 *                         3
 *
 *
 */


class BalancedBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return getHeight(root) != -1
    }

    private fun getHeight(root: TreeNode?): Int {
        if (root == null) return 0

        val leftHeight = 1 + getHeight(root.left)
        if (leftHeight == 0) return -1
        val rightHeight = 1 + getHeight(root.right)
        if (rightHeight == 0) return -1

        if (abs(leftHeight - rightHeight) > 1) return -1
        return maxOf(leftHeight, rightHeight)
    }
 }