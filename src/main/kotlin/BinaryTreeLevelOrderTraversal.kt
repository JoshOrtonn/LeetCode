package org.example

/**
 *
 * Binary Tree Level Order Traversal
 * Medium
 * Given the root of a binary tree, return the level order
 * traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 *
 */
class BinaryTreeLevelOrderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // BFS can be achieved to reach all nodes, visiting all of their neighbours first
    // Queue to add each neighbour too, with a secondary Int for current height
    // Given it needs to occur across the nodes.
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        val outputList = mutableMapOf<Int, List<Int>>()
        if (root == null) return emptyList()

        queue.addLast(root to 0)
        outputList[0] = listOf(root.`val`)

        while (queue.isNotEmpty()) {
            val treeNode = queue.removeFirstOrNull()

            if (treeNode != null) {
                val nextLevel = treeNode.second + 1
                // Enqueue it's neighbours and add one to it's level
                treeNode.first.left?.let {
                    appendToQueueAndList(it, nextLevel, queue, outputList)

                }
                treeNode.first.right?.let {
                    appendToQueueAndList(it, nextLevel, queue, outputList)
                }
            }
        }

        return outputList.values.toList()
    }

    // BFS can be achieved to reach all nodes, visiting all of their neighbours first
    // Queue to add each neighbour too, with a secondary Int for current height
    // Given it needs to occur across the nodes.

    fun levelOrderRecursivelyHelper(treeNode: TreeNode?): List<List<Int>> {
        val mutableMap = mutableMapOf<Int, List<Int>>()
        return levelOrderRecursively(treeNode, mutableMap, 0)
    }

    private fun levelOrderRecursively(treeNode: TreeNode?, outputMap: MutableMap<Int, List<Int>>, previousLevel: Int): List<List<Int>> {
        if (treeNode == null) return emptyList()
        if(outputMap.isEmpty()) {
            appendToMap(treeNode, previousLevel, outputMap)
        }

        val nextLevel = previousLevel + 1

        // Put child treeNodes within the map, then recursive through them.
        appendToMap(treeNode.left, nextLevel, outputMap)
        appendToMap(treeNode.right, nextLevel, outputMap)

        levelOrderRecursively(treeNode.left, outputMap, nextLevel)
        levelOrderRecursively(treeNode.right, outputMap, nextLevel)

        return outputMap.values.toList()
    }

    private fun appendToMap(
        it: TreeNode?,
        nextLevel: Int,
        outputList: MutableMap<Int, List<Int>>
    ) {
        // Append to existing list
        it?.let {
            outputList[nextLevel] = outputList.getOrDefault(nextLevel, emptyList()) + it.`val`
        }

    }

    private fun appendToQueueAndList(
        it: TreeNode,
        nextLevel: Int,
        queue: ArrayDeque<Pair<TreeNode, Int>>,
        outputList: MutableMap<Int, List<Int>>
    ) {
        queue.addLast(it to nextLevel)
        // Append to existing list
        outputList[nextLevel] = outputList.getOrDefault(nextLevel, emptyList()) + it.`val`

    }
}