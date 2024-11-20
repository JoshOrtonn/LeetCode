package org.example.binaryTree


class BinaryTreeSumOfAllNodes {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun solve(node: TreeNode?): Int {
        // base case of passing an empty tree
        if(node == null) return 0
        // To save on call frames if we know the current node is the leaf we can just return its value
        if(node.left == null && node.right == null) return node.`val`

        // Otherwise, we will get the left subtree's value, and the right subtree's value
        val left = solve(node.left)
        val right = solve(node.right)

        // And add them with the current node's subtree.
        return left + right + node.`val`

        // Which will essentially work down to leaf node, return itself,
        // then backtrack to parent, calculate right hand subtree, and add itself passing back to parent
        // Recursively, essentially breaking it down into smaller problems.
    }

    // To solve for the problem of counting the number of nodes in a binary tree.
    // Simply follow similar practices,
    // Consider at any node, it's number of nodes, is 1 + left subtree Height + right subtree height
    // Left subtree height = left subtreeHeight + right subtree height + 1
    // Until we reach leaf node, which should equal 1.
    fun countNumberOfNodes(node: TreeNode?): Int {
        // base case of passing an empty tree
        if(node == null) return 0
        // To save on call frames
        // if we know the current node is the leaf we can just one as value
        if(node.left == null && node.right == null) return 1

        // Otherwise, we will get the left subtree's value, and the right subtree's value
        val left = countNumberOfNodes(node.left)
        val right = countNumberOfNodes(node.right)

        // Increment the left subtree and right subtree values by one.
        return left + right + 1

        // Which will essentially work down to leaf node, return itself,
        // then backtrack to parent, calculate right hand subtree, and add itself passing back to parent
        // Recursively, essentially breaking it down into smaller problems.
    }
}