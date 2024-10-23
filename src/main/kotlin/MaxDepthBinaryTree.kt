package org.example

import com.sun.source.tree.Tree
import kotlin.math.max

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
class MaxDepthBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // Previously did this with post order traversal working out diameter of a binary tree
    // Which is essnetially a more complex version of this, that could span across or ignore root.
    // but this one just need to work upwards from leaf node, calculating height.
    // Given height of node is 1 + maxOf(leftSubtree, rightSubtree)
    // We can recursively go down to leaf node, return 0 at that case.
    // Such that a leaf node will have a height of 1 in the tree.
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0

        val leftHeight = maxDepth(root.left)
        val rightHeight = maxDepth(root.right)

        val maxHeightOfCurrent = 1 + maxOf(leftHeight, rightHeight)

        return maxHeightOfCurrent
    }

    // Peek is imperative in Post order traversal
    // TODO maybe look to improve iterative's space effiency
    // TODO does it need to be post order??
    // Previously the diameter did, but maybe this does not..
    fun maxDepthIterative(root: TreeNode?): Int {
        val stack = ArrayDeque<TreeNode?>()
        val visited = mutableSetOf<TreeNode?>()
        val heightHashmap = mutableMapOf<TreeNode, Int>()

        stack.addFirst(root)

        while (stack.isNotEmpty()){
            val node = stack.firstOrNull()
            if(node != null && node !in visited) {
                visited.add(node)
                // L, R adding down the tree to top of stack
                node.right?.let { stack.addFirst(it) }
                node.left?.let { stack.addFirst(it) }

            // Calculate N now, as this branch should come back up the stack
            } else if(node != null && node in visited) {

                // Calculate height, based on root.left and root.right's value in the hashmap, or 0 if default for leaf node.
                val leftHeight = heightHashmap.getOrDefault(node.left, 0)
                val rightHeight = heightHashmap.getOrDefault(node.right, 0)

                // Formula for height of current node in tree
                val currentHeight = 1 + maxOf(leftHeight, rightHeight)

                heightHashmap.set(node, currentHeight)

                // Popping off the stack.
                stack.removeFirstOrNull()
            }
        }
        // really the last value to process should be the root one,
        // so could instead of a hashmap just use a variable, but we shall see.
        return heightHashmap[root]!!
    }
}