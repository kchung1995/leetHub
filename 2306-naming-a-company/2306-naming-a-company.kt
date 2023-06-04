class Solution {
    fun distinctNames(ideas: Array<String>): Long {
        val alphabets: Int = 26
        val initialGroup = Array<HashSet<String>>(alphabets) { HashSet() }
        for (idea in ideas) initialGroup[idea[0] - 'a'].add(idea.substring(1))

        var result: Long = 0
        for (i in 0 until alphabets - 1) {
            for (j in i + 1 until alphabets) {
                var numOfMutual: Long = 0
                for (ideaA in initialGroup[i]) {
                    if (initialGroup[j].contains(ideaA)) {
                        numOfMutual++
                    }
                }

                result += 2 * (initialGroup[i].size - numOfMutual) * (initialGroup[j].size - numOfMutual)
            }
        }

        return result
    }
}

