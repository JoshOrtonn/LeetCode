package org.example.breadthFirstSearch

class RightMostNode {
    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    //### Notes
    //
    //- Perform BFS on a binary tree
    //- For loop of queue size from 1.. QueueSize
    //- Then just pop off everything from 1..QueueSize-1
    //- Then for the last one, just add it to the List
    //- Assuming we add left first.
    fun solve(input: TreeNode): List<Int> {
        val queue = ArrayDeque<TreeNode>()
        val outputList = mutableListOf<Int>()

        queue.addLast(input)
        while(queue.isNotEmpty()){
            val queueSize = queue.size
            for(i in 1..queueSize){
                val node = queue.removeFirst()
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }

                // If last entry in queueSize add it as rightmost in list
                if(i == queueSize){
                    outputList.add(node.value)
                }
            }
        }
        return outputList
    }
    // Complexities
    // Space Complexity: O(N)outputList + O(M) queue list size at peak which is less than n.
    // OutputList contains in worst case a tree of N size if just a line of children
    // So reduces to O(N)
    // Time complexity: O(N) As we loop through each node on the queue

}