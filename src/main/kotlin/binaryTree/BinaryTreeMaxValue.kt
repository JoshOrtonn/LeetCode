package org.example.binaryTree


class BinaryTreeMaxValue {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun solve(node: TreeNode?): Int {
        // base case of passing an empty tree
        if(node == null) return 0

        // Base case if leaf node, return itself to parent.
        if(node.left == null && node.right == null) return node.`val`

        // Otherwise, we will get the left subtree's max Value, and the right subtree's max value
        val left = solve(node.left)
        val right = solve(node.right)

        // And then confirm which one of left, right, or current value is the max value, and return that to parent.
        return maxOf(maxOf(left, right), node.`val`)

        // Which will essentially work down to leaf node, return itself,
        // then backtrack to parent, calculate right hand subtree, and return max of left, right or current.
        // then backtrack again.. Recursively, essentially breaking it down into smaller problems.
    }
}