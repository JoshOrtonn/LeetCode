package org.example


/**
 * Given the root of a binary tree and an integer target.
 * Write a recursive function to find all root-to-leaf paths where sum of all values along the path sum to target.
 *
 * Target = 10
 * Output: [[1,2,7], [1,4,5]]
 *
 * Explanation:
 *
 * Start with target value, minusing down the binary tree
 *
 * If we reach leaf node and the value is 0, we have found a path sum match.
 *
 * Therefore we need to keep a track of the path we take and add it to a list.
 *
 * Base Case:
 *
 * If node is null return emptyList
 *
 * If node is leaf node and target becomes 0, add all elements to list.
 *
 * What do I want from my child nodes, or what do I want from my parent.
 *  - Nothing actually but I do:
 * - Want to keep a running track of the:
 *     - target - currentValue, so return that.
 * - And pushing and popping off the stack as we backtrack?
 */
class BinaryTreePathSum2 {
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val path = mutableListOf<Int>()
    private val result = mutableListOf<List<Int>>()

    fun solveHelper(root: TreeNode, target: Int): List<List<Int>> {
        solve(root, target)

        return result.toList()
    }

    private fun solve(node: TreeNode?, runningMinuser: Int) {
        if (node == null) return
        val currentValue = runningMinuser - node.value
        path.add(node.value)

        if (node.left == null && node.right == null) {
            if (currentValue == 0) {
                // We've found a match, we can add all list items to this.
                result.add(path.toList())
            }
        }

        solve(node.left, currentValue)
        solve(node.right, currentValue)

        // If we reach here too, we should remove the last as well
        path.removeLast()
    }
}