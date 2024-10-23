package org.example

import org.example.BinaryTreeDiameter.TreeNode

class BinaryTreeDiameterRecursive{
    fun diameterOfBinaryTreeRecursiveHelper(root: TreeNode?): Int {
        diameterOfBinaryTreeRecursive(root)

        return maxDiameter
    }


    // Post order traversal L, R, N
    // Definition: The height of a current node is the number of edges in the longest downward path
    //    from itself to a leaf node.
    // Definition: The diameter of a binary tree is the number of edges in the longest path between any two nodes in the tree.
    // Important distinction in that Diameter is equal to the leftHeight + Right Height of the current node
    // But the current height of the node is 1 + maxOf(LeftSubtreeHeight, rightSubtreeHeight)
    // with a base case of 0, for null nodes, children of leaf nodes.
    // Such that leaf nodes have a height of 1, but a diameter of 0

    var maxDiameter = 0
    private fun diameterOfBinaryTreeRecursive(
        node: TreeNode?
    ): Int {
        // If current node is a child of a leaf node return 0
        if(node == null) return 0

        val leftHeight = diameterOfBinaryTreeRecursive(node.left)
        val rightHeight = diameterOfBinaryTreeRecursive(node.right)

        // Current Diameter
        /**
         *          2 (diameter would equal f(3) + f(r) == 2
         *                  as left height of f(3) = 1 + (1 + 0)
         *         3 (diameter would equal f(1) + f(r) == 1
         *               as left height of f(1) is: 1 + maxOf(f(1l), f(1r)) (given 1l and 1r are 0) = 1
         *        1 (diameter would equal 0 + 0)
         *                  as left and right heights from leaf node short circuits as 0
         *
         */
        // Update current diameter, if larger than previously found maxDiameter
        maxDiameter = maxOf(maxDiameter, leftHeight + rightHeight)


        // Return height of current node, which is max of left or right + 1
        val heightOfCurrentNode = 1 + maxOf(leftHeight, rightHeight)
        /**
         *          2 (height would equal 1+ max(f(3), f(r)) == max(2, 0) == 3 But remember, it's height!!, and not diameter
         *         3 (height would equal 1 + max((f(1) == 1), 0) == 2
         *        1  (height would equal 1 + max(0, 0)   == 1)
         *                  As left and right nodes from leaf return 0
         */
        return heightOfCurrentNode
    }
}