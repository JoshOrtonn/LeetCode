/**
You are given an integer **n** and a list of undirected **edges** where each entry in the list is a pair of integers representing an edge between nodes **1** and **n**.
You have to write a function to check whether these edges make up a valid tree.

There will be no duplicate edges in the **edges** list. (i.e. [0, 1] and [1, 0] will not appear together in the list).
 */

// A valid tree is one where all edges are connected, and not acyclic
// To find if they are all connected we could at least compare the set of visited, to the adjacency matrix keys size.
// If different we know its not valid.

class GraphValidTree {

    // Create bidirectional Adjacency Matrix
    // Do DFS compare visited Set to bidirectional Adjacency matrix size.
    // If different return false
    // Tricky part is detecting cycles, given bidirectional nature given a tree is not a cycle too.
    fun isValid(input: List<List<Int>>): Boolean {
        // Create bidirectional Adjacency Matrix
        // Do DFS compare visited Set to bidirectional Adjacency matrix size.
        // As in connected graph all should be visited
        // If different return false
        // Tricky part is detecting cycles, with bidirectional nature given a tree is not a cycle too.
        val adjacencyMatrix = createBiDirectionalAdjacencyMatrix(input)
        val startingNode = adjacencyMatrix.keys.first()
        val visitedSet = mutableSetOf<Int>()

//        return recursiveDFS(startingNode, adjacencyMatrix, visitedSet, null)
//                && adjacencyMatrix.size == visitedSet.size
        return iterativeDFS(startingNode, adjacencyMatrix, visitedSet)
                && adjacencyMatrix.size == visitedSet.size
    }

    private fun recursiveDFS(
        currentNode: Int,
        adjacencyMatrix: Map<Int, Set<Int>>,
        visitedSet: MutableSet<Int>,
        parent: Int?
    ): Boolean {
        visitedSet.add(currentNode)
        adjacencyMatrix[currentNode]?.forEach {
            if (it !in visitedSet) {
                // Essentially this will continue exploring neighbours, until a false is found
                if (!recursiveDFS(it, adjacencyMatrix, visitedSet, currentNode)) {
                    // False for being not valid
                    return false
                }
                // Essentially if it has already been visited, BUT it was not the previous node that added it to the stack
            } else if (it in visitedSet && parent != it) {
                // Else if in visited set, but not just the parent, return true for cycle detected.
                return false

            }
        }
        // Assume if we've hit here that no cycle has been found
        return true
    }


    private fun iterativeDFS(
        rootNode: Int,
        adjacencyMatrix: Map<Int, Set<Int>>,
        visitedSet: MutableSet<Int>
    ): Boolean {
        val stack = ArrayDeque<Int>()
        stack.addFirst(rootNode)
        val parent = mutableMapOf<Int, Int>()

        while(stack.isNotEmpty()) {
            val currentNode = stack.removeFirst()
            visitedSet.add(currentNode)
            adjacencyMatrix[currentNode]?.forEach { neighbour: Int ->
                if (neighbour !in visitedSet) {
                    stack.addFirst(neighbour)
                    parent[neighbour] = currentNode // Mark parent of it, as node, and not
                    // Note this can be overwritten, if two nodes add it as a neighbour to the stack

                    // Essentially if it has already been visited,
                    // BUT it was not the previous node (parent) that added it to the stack
                } else if (neighbour in visitedSet && neighbour != parent[currentNode]) {
                    // Else if in visited set, but not just the parent, return true for cycle detected.
                    return false

                }
            }
        }
        // Assume if we've hit here that no conflict is found
        return true
    }


    fun createBiDirectionalAdjacencyMatrix(input: List<List<Int>>): Map<Int, Set<Int>> {
        val outputMap = mutableMapOf<Int, Set<Int>>()
        input.forEach {
            outputMap.put(it.first(), outputMap.getOrDefault(it.first(), setOf()) + it.last())
            outputMap.put(it.last(), outputMap.getOrDefault(it.last(), setOf()) + it.first())
        }
        return outputMap
    }
}
