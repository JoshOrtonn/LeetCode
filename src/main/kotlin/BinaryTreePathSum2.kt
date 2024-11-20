package org.example


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