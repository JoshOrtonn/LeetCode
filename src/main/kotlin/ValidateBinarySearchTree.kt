package org.example

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
        if(root != null) {
            if(root.left != null){
                if(root.left!!.`val` >= root.`val`) return false
            }
            if(root.right != null){
                if(root.right!!.`val` <= root.`val`) return false
            }

            if(!isValidLeftSubtree(root.left, root.`val`)) return false
            if(!isValidRightSubtree(root.right, root.`val`)) return false
        }
        // If no invalid case met, we can assume it's true.
        return true
    }

    // In a binary search tree, every node to the right (including all ancestors), must be greater
    // The same goes for the left sub trees, every node to the left, including all ancestors must be less than.
    // so for:

    /*
                            32
                        26      47
                    19              56
                        27

           It should be false, given left of 32 is 26, fine, but that should be the new MAX value within it.
           Left of 26 should be less than 26
           But right of 19 should be more than 19, but less than 27!!
           So need to keep a running min and max value I think
           I think max value for leftSubtree
           Max is running total of left hand subtree, presumably it should be
           running min value for rightSubtree

     */
    private fun isValidLeftSubtree(node: TreeNode?, maxValue: Int): Boolean {
        // Base case we got to here, and no falses met.
        if(node == null){
            return true
        }

        if(node.left != null){
            if(node.left!!.`val` >= node.`val`) return false
        }
        if(node.right != null){
            if(node.right!!.`val` <= node.`val` || node.right!!.`val` >= maxValue) return false
        }


        // Going left the new max is current val.
        // So 26 should be set here first, I wonder then, if 19 is set,
        if(!isValidLeftSubtree(node = node.left, node.`val`)) return false
        if(!isValidLeftSubtree(node = node.right, maxValue)) return false

        // should reach here once all of left subtree is exhausted.. I think.
        return true
    }

    private fun isValidRightSubtree(node: TreeNode?, minValue: Int): Boolean {
        // Base case we got to here, and no falses met.
        if(node == null){
            return true
        }
        var newMin = minValue

        if(node.left != null) {
            if(node.left!!.`val` >= node.`val` || node.left!!.`val` <= minValue) return false
            newMin = minOf(newMin, node.`val`)
        }
        if(node.right != null){
            if(node.right!!.`val` <= node.`val` || node.right!!.`val` <= minValue) return false
        }


        if(!isValidRightSubtree(node.left, newMin)) return false
        if(!isValidRightSubtree(node.right, node.`val`)) return false

        // should reach here once all of left subtree is exhausted.. I think.
        return true
    }




}