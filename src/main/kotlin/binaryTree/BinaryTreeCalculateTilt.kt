package org.example.binaryTree

import kotlin.math.abs

/***
 * Given the root node of a binary tree, write a recursive function to return the sum of each node’s tilt.
 *
 * The tilt of a node is the absolute difference between the sum of its left subtree and sum of its right subtree.
 *
 * If a node has an empty left or right subtree the sum is 0.
 */
class BinaryTreeCalculateTilt {
    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    /**
     * The tilt at any node is considered to be the sum of it’s left subtree, minus the sum of it’s right subtree (absolute) so it’s positive.
     *
     * Tilt = |SumLeft -  SumRight|
     *
     * And output is running total of tilt
     * And the Tilt of all nodes is the sum of all of their tilts.
     *
     * ### Return Values
     *
     * Given any node, what do I need to return to my parents?
     *
     * - Return the sum of leftSubtree + RightSubtree + currentNodeValue
     * - Calculate tilt with |leftSubtree - rightSubtree| and add to current sumOfTilts number
     *     - USING GLOBAL VARIABLE
     *
     * ### Base Case:
     *
     * if null node return 0
     *
     * If leaf node return itself as sum
     *
     * ### Extra work:
     *
     * - Calculate: Tilt as  | Sum of left subtree - Sum of right subtree| through global variable, before returning the sum up to the parents
     */
    private var sumOfTilts = 0

    fun solveHelper(treeNode: TreeNode?): Int {
        if (treeNode == null) return 0

        // Obviously would not work if treeNode.right is null....
        solve(treeNode)

        return sumOfTilts
    }

    private fun solve(treeNode: TreeNode?): Int {
        if(treeNode == null) return 0
        if(treeNode.left == null && treeNode.right == null){
            // Hit leaf node, we can return self as sum.
            return treeNode.value
        }

        // Calculate left and right subtreeSums
        val leftSubTreeSum = solve(treeNode.left)
        val rightSubTreeSum = solve(treeNode.right)

        // Add sumOfTilts as we go.
        sumOfTilts += abs(leftSubTreeSum - rightSubTreeSum)

        // Return sum of self, left and right subtree to parent
        return leftSubTreeSum + rightSubTreeSum + treeNode.value
    }
    //Time Complexity: O(N), where N is the number of nodes in the tree.
    // We visit each node exactly once, and at each node, we perform constant time work.
    //Space Complexity: O(N), where N is the number of nodes.
    //  A total of N call frames have to be allocated, one for each node in the tree.
}