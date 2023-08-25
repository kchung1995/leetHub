class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val s1Len = s1.length
        val s2Len = s2.length
        val s3Len = s3.length
        
        if (s1Len + s2Len != s3Len) return false

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = mutableSetOf<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        
        while (queue.isNotEmpty()) {
            val (pos1, pos2) = queue.poll()
            if (pos1 + pos2 == s3Len) {
                return true
            }
            
            if (pos1 < s1Len && s1[pos1] == s3[pos1 + pos2] && Pair(pos1 + 1, pos2) !in visited) {
                queue.add(Pair(pos1 + 1, pos2))
                visited.add(Pair(pos1 + 1, pos2))
            }
            
            if (pos2 < s2Len && s2[pos2] == s3[pos1 + pos2] && Pair(pos1, pos2 + 1) !in visited) {
                queue.add(Pair(pos1, pos2 + 1))
                visited.add(Pair(pos1, pos2 + 1))
            }
        }
        
        return false
    }
}

