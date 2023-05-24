class Solution {
    fun destCity(paths: List<List<String>>): String {
        val from = HashSet<String>()
        val to = HashSet<String>()

        for (path in paths) {
            from.add(path[0])
            to.add(path[1])
        }

        for (candidate in to) {
            if (!from.contains(candidate)) return candidate
        }
        return ""
    }
}

