package org.example

class BinaryTreePathSum {
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * ### Return Values, Base Case
     *
     * - At root node, what do I want my subtrees to return,
     *     - Probably a list of their sums, for the current node to sum to.
     * - At node 1, so BASE CASE at leaf node we would return just singleton list of itself.
     * - At node 2, add 2 to leftSubtree list entries, and add 2 to rightSubtree list entries.
     *     - Return these two lists.
     * - Then once all that is done, we should have a list of values
     *      which if target is one of, we can return true, else false.
     */
    private fun solvePathSum(node: TreeNode?): MutableList<Int> {
        if (node == null) return mutableListOf()
        if (node.left == null && node.right == null) return mutableListOf(node.value)

        val leftPaths = solvePathSum(node.left)
        val rightPaths = solvePathSum(node.right)

        val newPaths = leftPaths.map { it + node.value} + rightPaths.map { it + node.value }

        return newPaths.toMutableList()
    }

    fun solveHelper(target: Int, root: TreeNode): Boolean {
        return target in solvePathSum(root)
    }

    fun solvePathSumWithoutList(node: TreeNode?, target: Int): Boolean {
        if (node == null) return false // Really hate this inversion of control, but...
        // Lets see if we can make the return list a bit better.
        val newCurrentTarget = target - node.value

        if (node.left == null && node.right == null) {
            // Returns true if we've found a path from root to leaf, whereby the value is minus'd each step to 0.
            return newCurrentTarget == 0
        }

        val leftPaths = solvePathSumWithoutList(node.left, newCurrentTarget)
        val rightPaths = solvePathSumWithoutList(node.right, newCurrentTarget)


        // Return if any paths are true
        return leftPaths || rightPaths
    }
}