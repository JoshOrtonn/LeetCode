package org.example

class AccountsMerge {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {

        val adjacencyMatrix = mutableMapOf<String, List<Set<String>>>()

        accounts.forEach {
            val name = it[0]
            // emails
            val setToAdd: Set<String> = it.subList(1, it.size).toSet()
            adjacencyMatrix[name] = (adjacencyMatrix.getOrDefault(name, emptyList<Set<String>>()) + listOf(setToAdd))
        }
        val mapOfEmailGroupToEmailGroup = mutableMapOf<String, MutableList<String>>()

        val undirectedMap = buildMap<String, List<String>> {
            adjacencyMatrix.forEach {
                it.value.forEach {
                    it.forEachIndexed { index, email ->
                        val key: String = email
                        val preExistingValues: List<String> = get(key) ?: emptyList()
                        put(key, preExistingValues + it.filter { otherEmails -> otherEmails != key })
                    }
                }
            }
        }

        dfs(undirectedMap)

        return accounts
    }

    // Continue this tomorrow
    private fun dfs(undirectedMap: Map<String, List<String>>) {
        val stack = ArrayDeque<String>()
        val visited = mutableSetOf<String>()

        undirectedMap.keys.forEach {
            stack.addFirst(it)
        }

        while (stack.isNotEmpty()){
            val email = stack.first()
            visited.add(email)
            val associatedEmails = undirectedMap[email]


        }

    }
}