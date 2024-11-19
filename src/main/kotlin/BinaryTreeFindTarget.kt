package org.example

class BinaryTreeFindTarget {
    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null

    }

    /**
     * # Problem: Find Target in Binary Tree
     *
     * Find if target exists within Binary tree, return true if it does, return false if it does not.
     *
     * Return Values and Base Cases
     *
     * - BC 1. If node is null, return false
     *    BC 2. If leaf node not target, return false
     * - BC 2. If current node is target return true
     * - Otherwise keep exploring left and right node.
     *     - And return at bottom outcomes of left || right
     */

    fun findTarget(target: Int, node: TreeNode?): Boolean {
        if(node == null) return false
        if(node.value == target) return true
        if(node.left == null && node.right == null) return false


        // This will short circuit rather than assigning as separate then evaluating
        // Only the second condition will be run on false of left.
        return findTarget(target, node.left) || findTarget(target, node.right)

    }
}