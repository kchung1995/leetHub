class Solution {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val groupElements: List<Pair<Int, Int>> = groupSizes
            .mapIndexed { id, size -> Pair(id, size) }
            .sortedWith(compareBy({ it.second }, { it.first }))
        
        var result: MutableList<List<Int>> = mutableListOf<List<Int>>()
        var current = mutableListOf<Int>()
        for (element in groupElements) {
            current.add(element.first)
            if (current.size == element.second) {
                result.add(current.toList())
                current = mutableListOf<Int>()
            }
        }
        
        return result.toList()
    }
}
