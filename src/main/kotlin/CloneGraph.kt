package org.example

/**
 *
 * /**
 *  * Definition for a Node.
 *  * class Node(var `val`: Int) {
 *  *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 *  * }
 *  */
 *
 * class Solution {
 *     fun cloneGraph(node: Node?): Node? {
 *
 *     }
 * }
 *
 * Clone Graph
 * Medium
 * Topics
 * Companies
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list.
 * The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node
 */


class CloneGraph {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    // Should we use BFS or DFS?
    // Lets use BFS. With a visited Set
    // take the node, add itself to visited set,
    // add it's neighbours to new arrayList
    // E.g Node1 has neighbours 2,4
    // Add node1 to visitedSet, add it's neighbours to new Node1 with new neighbours
    // Then continue.
    fun cloneGraph(node: Node?): Node? {
        if(node == null) return null
        else if(node.neighbors.isEmpty()) {
            // Is this needed?
            return node
        }

        val queue = ArrayDeque<Node>()
        val originalToClonedGraph = mutableMapOf<Node, Node>()
        val visited = mutableSetOf<Node>()


        // using queue as searching neighbours first
        queue.addLast(node)
        while (queue.isNotEmpty()){
            val currentNode: Node = queue.removeFirst()
            val newClonedNode = Node(currentNode.`val`)
            // If we haven't been here, maybe redundant.
            if(currentNode !in visited){
                visited.add(currentNode)
                // Add neighbours to arrayList / node Neighbours type.
                currentNode.neighbors.forEach {
                    // Should never be the case, as should be populated.
                    if(it != null) {
                        queue.addLast(it)
                        newClonedNode.neighbors += Node(it.`val`)
                    }
                }
                originalToClonedGraph[currentNode] = newClonedNode
            }
        }

        return originalToClonedGraph[node]
    }

    fun cloneGraphRecursivelyHelper(node: Node?): Node? {
        val mutableSet = mutableMapOf<Node, Node>()
        return cloneGraphRecursively(node, mutableSet)
    }

    // Generally recusively is kinda BFS
    // As we cannot properly capture the queue like aspect, with a call stack.
    private fun cloneGraphRecursively(node: Node?, originalToClonedGraph: MutableMap<Node, Node>): Node? {
        // Base case
        if(node == null) {
            return null
        }

        // If we've visited it before return itself.
        if(node in originalToClonedGraph) {
            return originalToClonedGraph[node]
        }

        val newNode = Node(node.`val`)
        originalToClonedGraph[node] = newNode

        node.neighbors.forEach {
            // Append to list, the newly create node.val from the previous node.
            // TODO draw out callstack on paper
            newNode.neighbors += cloneGraphRecursively(it, originalToClonedGraph)
        }


        return newNode

    }
}