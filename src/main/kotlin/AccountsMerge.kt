package org.example

class AccountsMerge {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val adjacencyMatrix = createAdjacencyMatrix(accounts)

        val outputList = mutableListOf<List<String>>()
        val visited = mutableSetOf<String>()

        // For each of the keys added, do BFS to explore them,
        // and then prepend them with the name and append to overall output list
        adjacencyMatrix.keys.forEach { keyEmail ->
            val name = keyEmail.first
            val listOfCommonEmails: List<String> = dfs(keyEmail, adjacencyMatrix, visited)

            if (listOfCommonEmails.isNotEmpty()) {
                outputList.add(buildList<String> {
                    add(name)
                    addAll(listOfCommonEmails)
                })
            }

        }


        return outputList
    }

    // For each of the inputs, split up name and rest of emails
    private fun createAdjacencyMatrix(accounts: List<List<String>>): Map<Pair<String, String>, List<String>> {
        return buildMap<Pair<String, String>, List<String>> {
            accounts.forEach {
                val name = it[0]

                // emails
                val emailSet: Set<String> = it.subList(1, it.size).toSet()
                // for each of the lists besides current email, append them to new adjacency matrix,
                // with current email as key,
                // Do this for them all, to obtain total adjacency with keys containing all emails essentially.
                // May prove to be duplicate work, but it's at least exhaustive
                emailSet.forEach { keyEmail ->
                    put(name to keyEmail, getOrDefault(
                        name to keyEmail,
                        emptyList<String>()
                    ) + emailSet.filter { currentEmail -> currentEmail != keyEmail })

                }
            }
        }
    }

    // Do DFS for each email key in Adjacency matrix, add values to stack.
    // and explore all of their values within the list, doing the same as above
    // Pop off stack, add to visited, append to list with name prefixed.
    private fun dfs(
        rootNode: Pair<String, String>,
        adjacencyMatrix: Map<Pair<String, String>, List<String>>,
        visited: MutableSet<String>
    ): List<String> {
        val (name, email) = rootNode

        val stack = ArrayDeque<String>()
        stack.addFirst(email)

        return buildList<String> {
            while (stack.isNotEmpty()) {
                val emailKey = stack.removeFirst()
                if (visited.add(emailKey)) {
                    // Visited returns false if it already was in the list,
                    // hence we shouldn't be duplicating this effort.
                    add(emailKey)
                }

                val commonEmails = adjacencyMatrix[name to emailKey]
                commonEmails?.forEach { it: String ->
                    // If value of email is not already visited nor is it in the stack already
                    // then we can push it to the top of the stack to add itself to the list, and explore it's neighbours
                    if (!visited.contains(it) && !stack.contains(it)) {
                        stack.addFirst(it)
                    }
                }
            }
        }.sorted()
    }
}