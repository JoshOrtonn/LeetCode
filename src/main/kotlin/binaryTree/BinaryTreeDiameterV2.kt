package org.example.binaryTree

/**
 * Given the root of a binary tree, write a recursive function to find the diameter of the tree.
 *
 * Diameter of a binary tree is the length of the longest path of edges between any two nodes in a tree.
 *
 * Path may, or may not pass through the root.
 *
 * Example 1:
 *                              3
 *                            9    2
 *                          1   4
 *                           5
 *
 * Output: 4, given longest path is 5 → 1 → 9 → 3 →2
 *
 * Example 2:
 *                               3
 *                            9
 *                          1   4
 *                        2    5
 * Output: 4
 *
 * Longest path is 2 → 1 → 9 → 4 → 3
 *
 * ## Return Values
 *
 * - If I am a node in the tree, what values do I need from my left and right children to calculate the diameter of the subtree rooted at the current node?
 *     - To calculate diameter we need to know the:
 *         - Left child Subtree max depth (height)
 *         - Right child Subtree max depth (height)
 * - This tells us that each recursive call should return the max depth of the subtree rooted at the current node.
 *     - Either left or right
 *     - And we then use this value to calculate the diameter across a nodes, left and right children
 *
 * ### Base case
 *
 * If empty tree return 0
 *
 * If leaf node return 1
 *
 * ### Extra work
 *
 * - Keep track of replacing new maxDiameter to be returned
 */
class BinaryTreeDiameterV2 {
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var maxDiameter = 0
    fun solveHelper(node: TreeNode): Int {
        solve(node)
        return maxDiameter
    }

    private fun solve(node: TreeNode?): Int {
        if (node == null) return 0
        // If leaf node, return 1 as diameter (greatest path) is itself.
        if(node.left == null && node.right == null) return 1

        // Explore all left and right subtrees, obtaining their max heights
        val heightOfLeft = solve(node.left)
        val heightOfRight = solve(node.right)

        // Diameter is the max of the left + right subtrees in it's path
        val diameter = heightOfLeft + heightOfRight
        maxDiameter = maxOf(maxDiameter, diameter)

        // Hence each node should return the maxHeight of it's subtrees + 1 for itself
        return 1 + maxOf(heightOfLeft, heightOfRight)

    }
}