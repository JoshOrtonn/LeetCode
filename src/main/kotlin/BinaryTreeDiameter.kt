package org.example

import org.example.BinaryTreeDiameter.TreeNode

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

    // Uses DFS for Post Order traversal
    // But exceeeds time limit sadly.
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root?.right == null && root?.left == null) return 0

        // Conduct Depth first search at least to reach all nodes,
        // counting the number of steps to reach from root.
        // Doing it in a post-order traversal so go left, go right then calcualte height
        // Best way is to count upwards from leaf node whereby height is 1.
        // And add up left + right at each node.
        val stack = ArrayDeque<TreeNode?>()
        val helperHashmap = hashMapOf<TreeNode, Int>()
        val visited = mutableSetOf<TreeNode?>()
        stack.addFirst(root)

        while (stack.isNotEmpty()) {
//            val node = stack.removeFirst() // should we peek instead?
            val node = stack.firstOrNull() // Peek is key

            if(node != null && node !in visited) {
                visited.add(node)
                if (node.left == null && node.right == null) {
                    // height at this leaf node is 0
                    helperHashmap.put(node, 1)
                    // Pop after storing height
                    stack.removeFirstOrNull()
                } else {
                    // Add it's non-null neighbours, continue until we see all neighbours
                    node.right?.let { stack.addFirst(it) }
                    node.left?.let { stack.addFirst(it) }
                }
            } else if(node !=null && node in visited) {
                // Should always have left and right, really.
                // Not trueee
                val leftHeight = helperHashmap.getOrDefault(node.left, 0)
                val rightHeight = helperHashmap.getOrDefault(node.right, 0)
                // Pop after storing height
                stack.removeFirstOrNull()
                helperHashmap.put(node, leftHeight+rightHeight)
            } else {
                // Removing null from stack, but really we should prevent nulls from being added.
                stack.removeFirstOrNull()
            }

        }

        return helperHashmap.maxOf { it.value }
    }
}