class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length == t.length) {
            return s == t
        }
        val sq: Queue<Char> = LinkedList<Char>( s.map { it } )
        val st: Queue<Char> = LinkedList<Char>( t.map { it } )

        while (sq.isNotEmpty()) {
            val current = sq.peek()
            while (st.isNotEmpty()) {
                val compare = st.poll()
                if (current == compare) {
                    sq.poll()
                    break
                }
            }
            if (sq.isNotEmpty() && st.isEmpty()) return false
        }
        if (sq.isNotEmpty()) return false

        return true
    }
}

