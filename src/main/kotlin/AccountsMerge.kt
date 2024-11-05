package org.example

class AccountsMerge {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val adjacencyMatrix = mutableMapOf<String, List<String>>()
        val nameToEmails = mutableMapOf<String, Set<String>>()

        accounts.forEach {
            val name = it[0]
            // emails
            val setToAdd: Set<String> = it.subList(1, it.size).toSet()
            nameToEmails[name] = (nameToEmails[name] ?: emptySet()) + setToAdd

            setToAdd.forEach { keyEmail ->
                val appendedValuesOfKeys = adjacencyMatrix.getOrDefault(
                    keyEmail,
                    emptyList<String>()
                ) + setToAdd.filter { currentEmail -> currentEmail != keyEmail }
                adjacencyMatrix[keyEmail] = appendedValuesOfKeys
            }
        }

        // Do DDFS for each email key in Adjaceny matrix, add values to stack, append to a list with name prefixed
        // and explore all of their values within the list, doing the same as above
        // Pop off stack, add to visited, append to list with name prefixed.

        val stack = ArrayDeque<String>()
        val outputList = mutableListOf<List<String>>()
        val visited = mutableSetOf<String>()
        adjacencyMatrix.keys.forEach { keyEmail ->
            stack.addFirst(keyEmail)
            val listOfCommonEmails: List<String> = dfs(stack, adjacencyMatrix, visited)

            if(listOfCommonEmails.isNotEmpty()){
                val name = nameToEmails.filter { it.value.contains(keyEmail) }.keys.first()

                val commonEmailWithName: List<String> = buildList<String> {
                    add(name)
                    addAll(listOfCommonEmails.sorted())
                }
                outputList.add(commonEmailWithName)
            }

        }


        return outputList
    }

    private fun dfs(
        stack: ArrayDeque<String>,
        adjacencyMatrix: MutableMap<String, List<String>>,
        visited: MutableSet<String>
    ): List<String> {
        val outputList = mutableSetOf<String>()
        while (stack.isNotEmpty()){
            val emailKey = stack.removeFirst()
            if(visited.add(emailKey)){
                // Visited returns false if it already was in the list,
                // hence we shouldn't be duplicating this effort.
                outputList.add(emailKey)
            }

            val commonEmails = adjacencyMatrix[emailKey]
            commonEmails?.forEach {
                // If value of email is not already visited nor in stack already push it to the top of the stack
                if(!visited.contains(it) && !stack.contains(it)){
                    stack.addFirst(it)
                }
            }
        }
        return outputList.toList()
    }
}