package org.example.binaryTree

/**
 * ### **DESCRIPTION (credit [Leetcode.com](https://leetcode.com/problems/longest-univalue-path))**
 *
 * Given the root of the binary tree,
 * find the longest path where all nodes along the path have the same value.
 * This path doesn't have to include the root node.
 *
 * Return the number of edges on that path, not the number of nodes.
 **                     1
 *                  4       5
 *                4   4    5
 * Output: 2
 *
 * **Explanation**: The longest path of the same value is the path [4,4,4], which has a total of 2 **edges**.
 *
 * Example 2:
 *                          1
 *                       1       1
 *                     1   1    1  1
 *
 * Output: 4
 *
# Explanation

Similar to diameter of a tree, longest path eseentially, but with added condition that longest path of same value.

What do I need to understand from my subtrees?

- At each subtree, need to return longest path (or height of longest path, where currentValue is same as subtree’s value.
- So passing down to subtree the parent value
- Keeping track of longest path with max Variable
- Work bottom up, so do left and right recursion down to leaf node, then evaluate
- If Current Node Value is the same as parents’
- Return maxOf(LeftSubtree, RightSubtree) + 1
- Update for maxPath maxOf(maxVariable, LeftSubtree + RightSubtree)
- Given max path could come from anywhere in the tree
- If currentNodeValue is not the same
- Return 0.

Overall return maxPath

Base Case:

- Empty Tree return 0.

Return values:

- If CurrentNode same as parents
- Return max height of subtree: maxOf(LeftSubtree, RightSubtree) + 1

Extra Work:

- Update maxPath to be maxOf(maxPath, LeftSubtree + RightSubtree)
- Overall return maxPath from helper function
 */
class LongestUniValuePath {
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var maxPath = 0
    fun solveHelper(node: TreeNode?): Int {
        // First call to root node has no parents, so does not pass it, every subsequent call has one tho..
        solve(node)
        return maxPath
    }

    private fun solve(node:TreeNode?, parentValue: Int? = null): Int {
        if(node == null) return 0

        val leftHeight = solve(node.left, node.value)
        val rightHeight = solve(node.right, node.value)

        // Is the new path of leftHeight + rightHeight the new maxPath?
        maxPath = maxOf(maxPath , leftHeight+rightHeight)

        // Return the height of it's left and right subtree height if it matches the parent value, else return 0..
        return if(parentValue != null && node.value == parentValue){
            maxOf(leftHeight, rightHeight) + 1
        } else {
            0
        }


    }

}