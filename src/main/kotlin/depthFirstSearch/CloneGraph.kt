package org.example.depthFirstSearch

/**
 * Given a reference to a variable node which is part of an undirected,
 * connected graph, write a function to return a copy of the graph as an
 * adjacency list in dictionary form.
 * The keys of the adjacency list are the values of the nodes,
 * and the values are the neighbors of the nodes.
 */
/**
Given a reference to a variable node which is part of an undirected, connected graph, write a function to return a copy of the graph as an adjacency list in dictionary form.
The keys of the adjacency list are the values of the nodes, and the values are the neighbors of the nodes.

node is an instance of the following class, where neighbors is a list of references to other nodes in the graph (also of type IntGraphNode):

class IntGraphNode:
def __init__(self, value = 0, neighbors = None):
self.value = value
self.neighbors = neighbors if neighbors is not None else []
EXAMPLES
Example 1:

Input:
node = IntGraphNode(1, [IntGraphNode(2), IntGraphNode(3)])
 */


/**
Given a reference to a variable node which is part of an undirected, connected graph, write a function to return a copy of the graph as an adjacency list in dictionary form.
The keys of the adjacency list are the values of the nodes, and the values are the neighbors of the nodes.

node is an instance of the following class, where neighbors is a list of references to other nodes in the graph (also of type IntGraphNode):

class IntGraphNode:
def __init__(self, value = 0, neighbors = None):
self.value = value
self.neighbors = neighbors if neighbors is not None else []
EXAMPLES
Example 1:

Input:
node = IntGraphNode(1, [IntGraphNode(2), IntGraphNode(3)])
 */
class CloneGraph {
    fun clone(node: IntGraphNode): Map<Int, Set<Int>> {
        // DFS to visit all neighbours and collate some adjacency matrix
        return DFS(node)
    }

    fun DFS(node: IntGraphNode): Map<Int,Set<Int>> {
        val stack = ArrayDeque<IntGraphNode>()
        val visited = mutableSetOf<Int>()
        val outputMap = mutableMapOf<Int, Set<Int>>()

        stack.addFirst(node)

        while(stack.isNotEmpty()){
            val node = stack.removeFirst()
            // Given this returns false if already added, it can implicitally do the already visited check for us
            if(visited.add(node.value)){
                node.neighbours.forEach { neighbour: IntGraphNode ->
                    stack.add(neighbour)
                    outputMap.put(node.value, outputMap.getOrDefault(node.value, setOf()) + neighbour.value)
                    // Bidirectional so add reversely too
                    outputMap.put(neighbour.value, outputMap.getOrDefault(neighbour.value, setOf()) + node.value)
                }
            }
        }
        return outputMap
    }
}

class IntGraphNode(var value: Int){
    var neighbours: List<IntGraphNode> = emptyList()
}

/**
 * Complexity Analysis
 * Time Complexity: O(N + M) where N is the number of nodes and M is
 * the number of edges in the graph for the depth-first search traversal.
 * Space Complexity: O(N + M) where N is the number of nodes in the graph and M is the number of edges in the graph.
 * The space complexity is due to the adjacency list that stores the graph structure:
 * each of the N nodes is stored once as the keys,
 * and each of the M edges is stored as part of the values in the dictionary.
 *
 *
 *
 */