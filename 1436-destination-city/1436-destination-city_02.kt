class Solution {
    fun destCity(paths: List<List<String>>): String {
        val from = HashSet<String>()
        val to = HashSet<String>()

        paths.forEach { path ->
            from.add(path[0])
            to.add(path[1])
        }

        to.forEach { candidate ->
            if (from.contains(candidate).not()) return candidate
        }

        return ""
    }
}

