package org.example.binaryTree


/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *
 * Input: root = [4,2,7,1,3,6,9]
 *
 * Output: [4,7,2,9,6,3,1]
 * Explaination:
 * For each child node of root, invert each of it's children
 * Input:
 *                                       4
 *                                   2       7
 *                                 1   3   6   9
 *
 *
 * Output:                               4
 *                                   7      2
 *                                9   6   3   1
 *
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * * For each child node of root, invert each of it's children
 *  * Input:
 *  *                                       4
 *  *                                   2       7
 *  *                                 1   3   6   9
 *  *
 *  *
 *  * Output:                               4
 *  *                                   7      2
 *  *                                9   6   3   1
 */

class InvertBinaryTree {
    // Start at root, invert left and right, with a temp variable holding the other one
    // Then for each left, invert left and right.
    // Then for each right, invert left and right.
    fun invertTree(root: TreeNode?): TreeNode? {
        // swap around binary tree on this section
        val temp = root?.left //
        root?.left = root?.right // 7 becomes 2 -- 9 becomes 6 -- null
        root?.right = temp // 2 becomes 7 -- 6 becomes 9 -- null

        // Then want to visit next left child.

        // Head down left most, swapping along the way
        if (root?.left != null) {
            // down left hand side tree
            invertTree(root.left)
        }
        if (root?.right != null) {
            // reach here when leftmost exhausted, and returned child most,
            invertTree(root.right)
        }

        // Returning the treeNode at leafmost, back to the recursive loop
        // For it then to traverse down next right node, starting doing leftmost again
        // Going back up before then going down right, and leftmost again
        // Swapping at each level.
        return root
    }

    /*
        Really should use Depth First Search
     */
}