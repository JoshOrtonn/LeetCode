package org.example

/**
 * Given the root node of a binary tree, write a function to find the number of “good nodes” in the tree.
 *
 * A node X in the tree is considered “good” if
 * in the path from the ***root*** to the node X,
 * there are **no nodes** with a value greater than X’s value.
 *
 *### Define the Return value
 *
 * If I’m a node in the tree, what values do I need from my left and right children to
 * calculate the number of good nodes in the subtree rooted at the current node?
 *
 * - I need to know the number of good nodes in my left,
 * - and the number of good nodes in my right
 * - Add them together.
 *
 * So return the number of good nodes in the subtree rooted at current node.
 *
 * ### Base Case:
 *
 * - The number of good nodes in an empty tree is 0.
 *
 * ### Extra Step: Determine if a node is “good”
 *
 * Current node is good, if either next child is more than current node.
 * But some complex cases if binary tree goes 4 → 7 → 6 → 9 then it’s not a satisfactory path.
 *
 * Instead need to keep track of max value of path.
 *
 * And if currentValue is greater than the max value,
 * then we can increment the maxPathCounter by 1 + recursive(leftSubtree) + recurse(rightSubtree)
 *
 *
 * Consider an extension whereby not only do we want to include the number of good nodes, but also the list of good nodes.
 */
class BinaryTreeGoodNodes {

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun solveHelper(treeNode: TreeNode): Int {
        val maxValue = Int.MIN_VALUE
        return solve(treeNode, maxValue)
    }

    private fun solve(treeNode: TreeNode?, maxValue: Int): Int {
        if (treeNode == null) return 0
        var count = 0
        return if (treeNode.value > maxValue) {
            count++
            1 + solve(treeNode.left, treeNode.value) + solve(treeNode.right, treeNode.value)
        } else {
//            return solve(treeNode.left, maxValue) + solve(treeNode.right, maxValue)
            // Could also return 0 here I think as we know a path should stop if the current value is less than.
            // Then therotically there's no path through it.
            // But this is to ensure we visit all nodes.
            0
        }
    }

}

class BinaryTreeGoodNodesList {

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun solveHelper(treeNode: TreeNode): List<Int> {
        val maxValue = Int.MIN_VALUE
        val mutableList = mutableListOf<Int>()
        return solve(treeNode, maxValue, mutableList)
    }

    private fun solve(treeNode: TreeNode?, maxValue: Int, mutableList: MutableList<Int>): List<Int> {
        if (treeNode == null) return emptyList<Int>()// Don't like this inversion of control, where we return void, but..
        if (treeNode.value > maxValue) {
            mutableList.add(treeNode.value)

            val left = solve(treeNode.left, treeNode.value, mutableList)
            val right = solve(treeNode.right, treeNode.value, mutableList)

            return mutableList
        }
        return emptyList()
    }

}