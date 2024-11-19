package org.example

class BinaryTreeMaxDepth {
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun solveMaxDepth(node: TreeNode?): Int {
        // Recursively at given node, we want to find maxOf(Leftsubtree, RightSubtree) + 1
        // Base case is when given node is a leaf node, we return 1.
        // And if given an empty tree, return 0.

        if(node == null) return 0
        if(node.left == null && node.right == null) return 1

        val left = solveMaxDepth(node.left)
        val right = solveMaxDepth(node.right)


        return maxOf(left, right) + 1

    }
}