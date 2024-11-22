package org.example.breadthFirstSearch

class LevelOrderTraversal {
    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    // Given a binary tree, return the level-order traversal of its nodes' values. (i.e., from left to right, level by level).
    // Take tree, which is non cyclic connected graph
    // Then do BFS adding each left and right values per level!! to a list.
    // Meaning we do a for loop for the size of the queue, popping off the queue, and adding it's children in the process.
    fun showLevelOrderPaths(input: TreeNode): List<List<Int>> {
        val queue = ArrayDeque<TreeNode>()
        val outputList = mutableListOf<List<Int>>()

        queue.addLast(input)

        while (queue.isNotEmpty()) {
            val queueSize = queue.size
            // for each of the items in the queue which at the start of a new level, should be the entire queue.
            val levelList = mutableListOf<Int>()
            for(i in 1..queueSize){

                // Take each node off the queue, adding their children to it
                // Then it should be added to a level list
                val node = queue.removeFirst()
                levelList.add(node.value)

                node.left?.let {
                    queue.addLast(it)
                }
                node.right?.let {
                    queue.addLast(it)
                }
            }
            // After queueSize iterations, i.e after the level is done
            // We add the level list to the output list.
            outputList.add(levelList)
        }

        return outputList.toList()
    }
}