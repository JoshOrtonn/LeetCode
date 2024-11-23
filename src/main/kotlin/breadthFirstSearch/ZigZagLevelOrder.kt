package org.example.breadthFirstSearch

class TreeNode(var value: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ZigZagLevelOrder {

    /*
    ### Algorithm

  - Start at starting node.
      - Do BFS, starting at start node
          - Get Queue size, for(i in 1.. queue.size), enqueue it’s left and right, then add it’s value to a list.
              - And every “right” one you just reverse the order of the list.
              - Start counter++ each time, Left, Right, Left, Right (mod 2 == 0) list.reverse
    */
    fun solve(treeNode: TreeNode): List<List<Int>> {
        val queue = ArrayDeque<TreeNode>()
        val outputList = mutableListOf<List<Int>>()
        queue.addLast(treeNode)
        var counter = 0

        while(queue.isNotEmpty()){
            val queueSize = queue.size
            val list = mutableListOf<Int>()
            counter++
            for(i in 1..queueSize) {
                val node = queue.removeFirst()

                node.left?.let{
                    queue.addLast(it)
                }
                node.right?.let{
                    queue.addLast(it)
                }
                list.add(node.value)
            }
            if(counter % 2 == 0){
                // Should reverse list on every right which occurs every 2
                // Think this one reverses in place...
                list.reverse()
            }

            outputList.add(list)
        }

        return outputList
    }
}