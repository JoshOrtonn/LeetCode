package org.example.binaryTree

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

    /**
     * ### Return Values, Base Case
     *
     * - At root node, what do I want my subtrees to return,
     *     - Wrong way to think of it. Instead should not relying on backtracking here to calculate,
     *          but instead minus target from current value downwards.
     *     - Hence at current node, I want to pass to my children the target - node value
     * - Base case: leaf node, which won’t have any children.
     *     - if the targetValue - leafNode value is 0, then we return true, we have found a match
     *     - Otherwise we return false.
     *     - How to ensure the last one, is not the most important one…
     * - Base case: null node, return false.
     */

    fun solvePathSumWithoutList(node: TreeNode?, target: Int): Boolean {
        if (node == null) return false // Base case empty tree, return false
        // Calculate new running current target
        val newCurrentTarget = target - node.value

        // If leaf node..
        if (node.left == null && node.right == null) {
            // Returns true if we've found a path from root to leaf, whereby the value is minus'd each step to 0.
            return newCurrentTarget == 0
        }

        val leftPaths = solvePathSumWithoutList(node.left, newCurrentTarget)
        val rightPaths = solvePathSumWithoutList(node.right, newCurrentTarget)


        // Return if any paths are true
        // I prefer this to doing it inline, it just helps me debug slightly easier.
        return leftPaths || rightPaths
    }
}