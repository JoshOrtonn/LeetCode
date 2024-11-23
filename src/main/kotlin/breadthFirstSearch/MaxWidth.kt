


class MaxWidth {
    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    /*
### Algorithm

BFS at starting node

while queue is not empty, and not just containing nulls.
Create queue, with value and width position, updated by parent incrementing for each child by one, including nulls.

iterate through queue size which would double each time, for each node, null or not.

Then determine max width at each level, given width position list, take non nulls, and ensure list size > 1, then take the last one.

Then check if that one is the new max
    */

    fun solve(treeNode: TreeNode): Int {
        val queue = ArrayDeque<Pair<TreeNode?, Int>>()
        queue.addLast(Pair(treeNode, 1))
        // And contains a First that equals notNull
        var maxWidth = 0
        while(queue.isNotEmpty() && !queue.all { it.first == null }) {
            val queueSize = queue.size
            var widthPosition = 0

            val widthPositions = mutableListOf<Pair<TreeNode?, Int>>()

            for(i in 1..queueSize){
                val pair = queue.removeFirst()
                widthPosition++
                queue.addLast(pair.first?.left to widthPosition)
                widthPosition++
                queue.addLast(pair.first?.right to widthPosition)

                widthPositions.add(pair)
            }

            val nonNullWidthPositions = widthPositions.filter {it.first?.value != null}
            nonNullWidthPositions.forEach {println("[" + it.first!!.value + "] has width position: " + it.second)}
            if(nonNullWidthPositions.size > 1) {
                maxWidth = maxOf(maxWidth, nonNullWidthPositions.last().second)
            }
        }
        return maxWidth
    }
}
