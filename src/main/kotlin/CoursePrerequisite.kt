package org.example

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 *
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */

// Feels like this can be solved using an adjacency matrix of key being [courseToUndertake] = [CourseIdCompleted, CourseId2Completed]
// And kinda like a DFS problem going from courseToUndertake, until all values are visited, and are okay to be completed.
// Stack or recursion
// GO through list of pre-requistes intArray [[1,0],[1,3]]
// This will mena that to take course 1 you should finish course 3 and course 0
// So add to adjacencyMap, at key 1, course 0 and 3.
// Then use adjacencyMap in DFS. [1] = [0,3]
// then do dfs on 0, if adjacencyMap[0] is null, assume it can be done.
// addToVisited..
// But if course 0 requires course 1 then return fail.
class CoursePrerequisite {
    fun canFinishV2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adjacencyMatrix = mutableMapOf<Int, List<Int>>()
        prerequisites.forEach {
            adjacencyMatrix[it.first()] = adjacencyMatrix.getOrDefault(it.first(), emptyList()) + it.last()
        }

        // DFS

        // Stack and visited, reset's for each course, is this correct?
        adjacencyMatrix.forEach { courseToBeUndertaken ->
            //Stack which will hold the course
            val stack = ArrayDeque<Int>()
            // To hold the courses we visit, and if we've already visited it, there will be a cyclical issue, return false
            val coursePreReqsVisited = mutableSetOf<Int>()
            // Add the key for course to be undertaken, and add to visited
            stack.addFirst(courseToBeUndertaken.key)
            while (stack.isNotEmpty()) {
                val course = stack.removeFirst()
                if (course in coursePreReqsVisited) {
                    // at this point we've already visited this node before, and noted a cyclical behaviour
                    return false
                } else {
                    if (adjacencyMatrix[course] != null) {
                        // really this only satisfies one level of indirection if adjacencyMatrix[course] = value which itself is null.
                        // add course to visited if the course has preReqs.
                        coursePreReqsVisited.add(course)
                    }
                }
                // Add it's neighbours to explore
                adjacencyMatrix[course]?.forEach {
                    // Only add nonPushed to the stack as this will produce a cycle for case of:
                    // Map[1] = [0, 7], Map[7] = [0] will become a cycle given two 0's added to stack
                    // So prevent that from happening. Maybe tho this'll only solve true case..
                    if (!stack.contains(it)) {
                        stack.addFirst(it)
                    }
                }
            }
        }
        return true

    }

    // TODO Continue to solve iterative approach
    fun canFinishV3(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val visited = buildMap<Int, State> {
            for (i in 0 until numCourses) {
                put(i, State.Unvisited)
            }
        }.toMutableMap()

        val stack = ArrayDeque<Int>()
        if (prerequisites.size < 2) return true

        val adjacencyMatrix = mutableMapOf<Int, List<Int>>()
        // Build Adjacency matrix
        prerequisites.forEach {
            val previousValue = adjacencyMatrix.getOrDefault(it.first(), emptyList())
            adjacencyMatrix[it.first()] = previousValue + it.last()
        }

        stack.addFirst(adjacencyMatrix.keys.first())
        // Sure we will need for each adj matrix, if unconnected graph.

        adjacencyMatrix.forEach {
            while (stack.isNotEmpty()) {
                val course = stack.removeFirst()
                if(visited[course] == State.Visited) return false
                visited[course] = State.Visiting
                adjacencyMatrix[course]?.forEach { neighbour ->
                    if (visited[neighbour] == State.Visiting) {
                        return false
                    } else if(visited[neighbour] == State.Unvisited){
                        stack.addFirst(neighbour)
//                    visited[neighbour] = State.Visiting
                    }
                }
                // Shouldn't add to this, until we've looped through all
                visited[it.key] = State.Visited
            }
        }


        return visited.values.none { it == State.Visiting }
    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adjacencyMatrix = mutableMapOf<Int, List<Int>>()
        // Build Adjacency matrix
        prerequisites.forEach {
            val previousValue = adjacencyMatrix.getOrDefault(it.first(), emptyList())
            adjacencyMatrix[it.first()] = previousValue + it.last()
        }

        val visited = buildMap<Int, State> {
            for (i in 0 until numCourses) {
                put(i, State.Unvisited)
            }
        }.toMutableMap()

        for (i in 0 until numCourses) {
            if (!dfs(i, visited, adjacencyMatrix)) return false
        }
        return true
    }

    private fun dfs(course: Int, visited: MutableMap<Int, State>, graph: MutableMap<Int, List<Int>>): Boolean {
        if (visited[course] == State.Visiting) return false // Cycle detected
        if (visited[course] == State.Visited) return true // Already visited

        // Mark current node as visiting
        visited[course] = State.Visiting

        // And for each children explore each path, any attempt to visit a visiting node,
        // indicates we are still on the same path with no solution to a visited or empty child node, hence we can return false.
        graph[course]?.forEach {
            if (!dfs(it ,visited, graph)) return false
        }

        // If reach node with no children, we will drop out here
        visited[course] = State.Visited
        return true
    }

    enum class State {
        Unvisited,
        Visiting,
        Visited
    }
}
/**
[[1,4],[2,4],[3,1],[3,2]]
Adj[1] = [4]
Adj[2] = [4]
Adj[3] = [1, 2]
Adj[4] = null
[1] => [] visited = (1), [4]
[4] => [] visited = (4) => stack empty, so reset visited..
Adj[2] => [2] => [] visited = (2), stack becomes [4]
[4] => [] visited = (2, 4) Adj[4] => null. so stack is empty, reset visited
Adj[3] > [3] => [] visited = (3), stack becomes [2, 1]
[2] => [1] visited = (3, 2), stack becomes [4, 1]
[4] =>  [1] visited = (3,2,4), stack remains [1] as Adj[4] is null.
[1] => [] visited = (3,2,4, 1) stack becomes [4]
[4] => [] fails as it's in visited... (maybe should only add non-null adjacency to this, as has no preReq)
 *
 */


// [1,0], [2,0], [1,2], [0, 2]
// Adj = [1] = [0, 2],  [0] = [2], [2] = [0]
// Stack = [0] => [] course not visited, add visited = 0, adjacency[0] = add [2] to stack
// Stack = [2] => [] course not visited, add visited = 0, 2, adjacency[2] = add[0] to stack
// Stack = [0] => [] course visited return false