package org.example.lca

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/***
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *
 *                                  6
 *                           2           8
 *                         0   4       7   9
 *                            3  5
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */

/**
 * Do Breadth first search from root.
 * Add root node to queue
 *
 * Then do bfs, while queue is not empty()
 * essentially visit all nodes in breadth manner, unless return statement met:
 * (min >= x <= max) via sorting p and q, where x is the LCA.
 * take from first in queue, check it's not already been visited, visit it
 * Check if it's betweeen p and q, if not then add it's children to the queue
 * repeat above until either queue is empty, exhausted all nodes, or return statement met.
 *
 * Take root, check if it's between the two numbers p and q
 *
 * Adding child nodes to queue
 */
class LowestCommonAncestoryBinarySearchTree {
    private fun ArrayDeque<TreeNode?>.doesNotContain(p: TreeNode?, q: TreeNode?): Boolean {
        return (this.contains(p) && this.contains(q))
    }

    fun solve(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // Queue to track neighbours we see
        val queue = ArrayDeque<TreeNode?>()
        val visited = mutableSetOf<TreeNode?>()

        queue.addLast(root)
        // Basically explore whole tree, unless return is met.
        while (queue.isNotEmpty()) {
            // take first element from queue.
            val node = queue.removeFirstOrNull()

            // Check if it's not been visited before:
            if (node !in visited) {
                // Visit it.
                visited.add(node)

                // Check if the node is within the two numbers inclusively p, q
                // Given it's a binary tree for any p, q the first number between them
                // Will be the LCA.
                if (node.withinRange(p, q)) {
                    return node
                }

                // If not, we're gonna add the child nodes to queue to be visited.
                queue.addLast(node?.left)
                queue.addLast(node?.right)
            }
        }
        // If not found, then return null, some error state really.
        return null
    }

    private fun TreeNode?.withinRange(p: TreeNode?, q: TreeNode?): Boolean {
        if (p != null && q != null && this != null) {
            val min = minOf(p.`val`, q.`val`)
            val max = maxOf(p.`val`, q.`val`)

            if (this.`val` in min..max) {
                return true
            }
        }
        return false
    }

    /**
     * Obviously we can exploit a Binary search tree, knowing that left had side is less than node
     * and right hand side is greater than node.
     * If for any given node, both p and q are less than that node x, we can explore left side
     * else If for any given node, both p and q are more than node x, we can explore right side
     * else, i.e p and q are both not bigger or smaller, i.e they are either smaller and larger respectively
     * we can return the current node as the LCA.
     */
    fun solveWithoutBFS(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null || q == null) return null
        var current = root

        while (current != null) {
            when {
                current.`val` > p.`val` && current.`val` > q.`val` -> current = current.left
                p.`val` > current.`val` && q.`val` > current.`val` -> current = current.right // Move down more side
                else -> return current
                // Else We've found or node whereby both conditions are not met
                // I.e p > nodeToExplore < q or:
                // I.e q > nodeToExplore < p
                // Hence it's the LCA
            }
        }

        return null
    }
}


