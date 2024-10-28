import org.example.CloneGraph
import org.example.CloneGraph.Node
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * **Test case format:**
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed).
 * For example, the first node with  val == 1`, the second node with  val == 2`, and so on.
 * The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph.
 * Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with  val = 1`.
 * You must return the copy of the given node as a reference to the cloned graph.
 */
class CloneGraphTest{
    val cloneGraph = CloneGraph()

    /**
     *  * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
     *  * Output: [[2,4],[1,3],[2,4],[1,3]]
     *  * Explanation: There are 4 nodes in the graph.
     *  * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
     *  * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     *  * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
     *  * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     */
    @Test
    fun shouldSolveForProblemEx1(){
        val node4 = Node(4)
        val node3 = Node(3)
        val node2 = Node(2)
        val node1 = Node(1)

        node1.neighbors = arrayListOf(node2, node4)
        node2.neighbors = arrayListOf(node3, node1)
        node3.neighbors = arrayListOf(node2, node4)
        node4.neighbors = arrayListOf(node1, node3)

        val expectedOutput = node1

        val actual = cloneGraph.cloneGraph(node1)
        assertEquals(expectedOutput.`val`, actual!!.`val`)
        assertEquals(expectedOutput.neighbors[0]!!.`val`, actual.neighbors[0]!!.`val`)
        assertEquals(expectedOutput.neighbors[1]!!.`val`, actual.neighbors[1]!!.`val`)
    }

    @Test
    fun shouldSolveForProblemEx2(){
        val node1 = Node(1)

        val expectedOutput = node1

        assertEquals(expectedOutput, cloneGraph.cloneGraph(node1))
    }

    @Test
    fun shouldSolveForProblemEx3(){
        val expectedOutput = null

        assertEquals(expectedOutput, cloneGraph.cloneGraph(null))
    }

    @Test
    fun shouldSolveForProblemEx1Recursively(){
        val node4 = Node(4)
        val node3 = Node(3)
        val node2 = Node(2)
        val node1 = Node(1)

        node1.neighbors = arrayListOf(node2, node4)
        node2.neighbors = arrayListOf(node3, node1)
        node3.neighbors = arrayListOf(node2, node4)
        node4.neighbors = arrayListOf(node1, node3)

        val expectedOutput = node1

        val actual = cloneGraph.cloneGraphRecursivelyHelper(node1)
        assertEquals(expectedOutput.`val`, actual!!.`val`)
        assertEquals(expectedOutput.neighbors[0]!!.`val`, actual.neighbors[0]!!.`val`)
        assertEquals(expectedOutput.neighbors[1]!!.`val`, actual.neighbors[1]!!.`val`)
    }

    @Test
    fun shouldSolveForProblemEx2Recursively(){
        val node1 = Node(1)

        val expectedOutput = node1

        assertEquals(expectedOutput.`val`, cloneGraph.cloneGraphRecursivelyHelper(node1)!!.`val`)
    }

    @Test
    fun shouldSolveForProblemEx3Recursively(){
        val expectedOutput = null

        assertEquals(expectedOutput, cloneGraph.cloneGraphRecursivelyHelper(null))
    }
}