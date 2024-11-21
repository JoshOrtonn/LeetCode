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
        val neighbourMap = mutableMapOf<Int, Set<Int>>()
        val outputMap = mutableMapOf<Int, Set<Int>>()

        return DFS(node)

        //  // put itself as key, and each of it's neighbours as values
        //  // And then put each of neighbours as key, and itself as value
        //  node.neighbours.forEach { neighbour: IntGraphNode ->
        //   // Run DFS for each neighbour
        //    neighbourMap.put(node.value, map.getOrDefault(node.value, setOf()) + neighbour.value)
        //    neighbourMap.put(neighbour.value, map.getOrDefault(neighbour.value, setOf()) + node.value)
        //  }
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

