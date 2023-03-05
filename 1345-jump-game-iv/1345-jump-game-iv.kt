class Solution {
    fun isMovableForward(i: Int, length: Int): Boolean = i + 1 < length
    
    fun isMovableBackward(i: Int): Boolean = i - 1 >= 0
    
    fun minJumps(arr: IntArray): Int {
        val length = arr.size
        val dist = IntArray(length) { -1 }
        
        // record arrays with same value
        val floors = HashMap<Int, MutableList<Int>>()
        
        for (i in 0 until length) {
            if (floors[arr[i]] == null) floors[arr[i]] = mutableListOf<Int>()
            floors[arr[i]]!!.add(i)
        }
        
        // bfs
        val q: Queue<Int> = LinkedList<Int>()
        q.add(0)
        dist[0] = 0
        while(q.isNotEmpty()) {
            val current = q.poll()
            
            if (current == length - 1)
                return dist[current]
            
            if (isMovableForward(current, length) && dist[current + 1] == -1) {
                dist[current + 1] = dist[current] + 1
                q.add(current + 1)
            }
            
            if (isMovableBackward(current) && dist[current - 1] == -1) {
                dist[current - 1] = dist[current] + 1
                q.add(current - 1)
            }
            
            if (floors[arr[current]] != null) {
                for (i in floors[arr[current]]!!) {
                    if (i != current && dist[i] == -1) {
                        dist[i] = dist[current] + 1
                        q.add(i)
                    }
                }
                floors.remove(arr[current])
            }
        }
        
        return -1
    }
}