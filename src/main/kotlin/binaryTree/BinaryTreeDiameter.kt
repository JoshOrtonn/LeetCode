package org.example.binaryTree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */
class BinaryTreeDiameter {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // Uses DFS for Post Order traversal L, R, N
    // Fast runtime
    // Slower for memory

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        // Conduct Depth first search at least to reach all nodes,
        // Doing it in a post-order traversal so go left, go right then calculate height and diameter
        // Best way is to count upwards from leaf node whereby height is 1.
        // And add up left + right heights at each node.
        val stack = ArrayDeque<TreeNode?>()
        val heightHashmap = hashMapOf<TreeNode, Int>()
        var maxDiameter = 0
        val visited = mutableSetOf<TreeNode?>()
        stack.addFirst(root)

        while (stack.isNotEmpty()) {
            // Peek is key for Post order traversal
            // If next node found as null, just return the max diameter
            val node = stack.firstOrNull() ?: return maxDiameter

            // node not been visited
            if (node !in visited) {
                // Add it to visited node, so we don't add it's children or itself again.
                visited.add(node)
                node.right?.let { stack.addFirst(it) } // R (of post order, collect all first, then do work on N)
                node.left?.let { stack.addFirst(it) } // L (of post order)

            } else if (node in visited) {
                // Given stack will be built with leafmost at the top, we can calculate heights bottom up.
                // So at leaf most the height of it's subtrees are 0, but of itself is 1 + maxOF(LH, RH) so 1.
                // And work upwards from there.
                val leftHeight = heightHashmap.getOrDefault(node.left, 0)
                val rightHeight = heightHashmap.getOrDefault(node.right, 0)

                val heightOfCurrentNode = 1 + maxOf(leftHeight, rightHeight)
                val diameterOfCurrentNode = leftHeight + rightHeight

                heightHashmap.put(node, heightOfCurrentNode)
                maxDiameter = maxOf(maxDiameter, diameterOfCurrentNode)

                // Pop after storing height, N(of Post order)
                stack.removeFirstOrNull()
            }
        }

        return maxDiameter
    }
}