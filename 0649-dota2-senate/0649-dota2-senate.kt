class Solution {
    fun predictPartyVictory(senate: String): String {
        val n = senate.length
        val radiant: Queue<Int> = LinkedList<Int>()
        val dire: Queue<Int> = LinkedList<Int>()

        for (i in 0 until n) {
            when (senate[i]) {
                'R' -> radiant.add(i)
                'D' -> dire.add(i)
            }
        }

        while (radiant.isNotEmpty() && dire.isNotEmpty()) {
            val radiantIndex = radiant.poll()
            val direIndex = dire.poll()

            if (radiantIndex < direIndex)
                radiant.add(radiantIndex + n)
            else
                dire.add(direIndex + n)
        }

        return if (radiant.size > dire.size) "Radiant" else "Dire"
    }
}

