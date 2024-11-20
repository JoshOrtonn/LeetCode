package org.example.binaryTree

/**
 * Given root of a binary tree, determine if it is a valid binary search tree
 *
 * A tree is a BST if the following conditions are met:
 *
 * - Every node on left subtree has a value less than the current node
 * - Every node on right subtree has a value more than the current node
 * - The left and right subtrees must also be valid BSTs
 */
class BinarySearchTreeValidation {
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * ### Return Values
     *
     * What is it I want my children to return to me?
     *
     * - I want to know if my left subtree is valid && my right subtree is valid
     * - And if current node falls within the valid range.
     *
     * ### Base Case
     *
     * - If empty tree, return true
     * - If reach leaf node with no invalidations, assume it has been met and return true.
     *
     * ### Extra Work
     *
     * - The work we need to do at each node is check if the current node’s value falls within the valid range.
     *  If it doesn’t we can return false immediately.
     *  We can visit each node in the tree, and have parents pass down the range of valid values to their children.
     *
     * So first step as we move down binary tree, left will have a max value from parent, but no min just yet.
     *
     * Then next left will pass down itself as max value, and no min yet.
     *
     * Then next right will pass down itself as min value, and so it goes.
     *
     * So going left, we want to pass down new maxValue as current value
     *
     * And going right, we want to pass down new minValue as current value
     */

    fun solveHelper(root: TreeNode?): Boolean {
        return solve(root, Int.MAX_VALUE, Int.MIN_VALUE)
    }

    private fun solve(root: TreeNode?, minValue: Int, maxValue: Int): Boolean {
        if (root == null) return false
        // Do some work

        if(root.value !in minValue..minValue){
            return false
        }

        if (root.left == null && root.right == null) {
            // assume that leaf node, with no invalidations returns true
            return true
        }
        //So going left, we want to pass down new maxValue as current value
        //And going right, we want to pass down new minValue as current value
        return solve(root.left, minValue, root.value) && solve(root.right, root.value, maxValue)
    }
    // Time complexity is O(N) as we return true for each leaf node, so could visit all across the tree
    // Space complexity is still O(N) whereby N is the number of nodes we visit and push onto the call stack
    // No additional space complexity is considered.
}