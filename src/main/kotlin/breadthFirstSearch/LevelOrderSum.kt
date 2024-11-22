
// Run BFS starting at root node.
// for(i in 1..queue.size)
// pop off queue, running total of all, then store in mutable list
// Then repeat
class LevelOrderSum {
    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun solve(startingNode: TreeNode): List<Int>{
        val queue = ArrayDeque<TreeNode>()
        val outputList = mutableListOf<Int>()

        queue.addLast(startingNode)

        while(queue.isNotEmpty()){
            val queueSize = queue.size
            var runningSum = 0

            for(i in 1..queueSize) {
                val node = queue.removeFirst()

                // Adding non null children to next in the queue
                node.left?.let{
                    queue.addLast(it)
                }
                node.right?.let{
                    queue.addLast(it)
                }
                runningSum += node.value
            }
            outputList.add(runningSum)
        }

        return outputList
    }
}