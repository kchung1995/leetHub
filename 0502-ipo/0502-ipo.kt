class Solution {
    data class Ready(val profit: Int, val capital: Int) : Comparable<Ready> {
        override fun compareTo(other: Ready): Int = capital - other.capital
    }
    
    data class Project(val profit: Int, val capital: Int) : Comparable<Project> {
        override fun compareTo(other: Project): Int = other.profit - profit
        
        companion object {
            fun from(ready: Ready): Project {
                return with (ready) {
                    Project(
                        ready.profit,
                        ready.capital
                    )
                }
            }
        }
    }
    
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        // put all the elements into priority queue.
        // among projects with capital[i] higher than `currentProfit`, choose the one with highest profits[i]
        // use two distinct priority queues
        
        val readyQueue = PriorityQueue<Ready>()
        val projectPool = PriorityQueue<Project>()
        for (i in 0 until profits.size) {
            readyQueue.add(Ready(profits[i], capital[i]))
        }
        
        var currentProfit: Int = w

        while (!readyQueue.isEmpty() && readyQueue.peek().capital <= currentProfit) {
            projectPool.add(Project.from(readyQueue.poll()))
            if (readyQueue.isEmpty()) break
        }

        
        for (dayCount in 1..k) {
            // choose the project with highest profit
            if (projectPool.isEmpty()) break
            currentProfit += projectPool.poll().profit
            
            // add available projects to projectPool
            if (readyQueue.isEmpty()) continue
            while (readyQueue.peek().capital <= currentProfit) {
                projectPool.add(Project.from(readyQueue.poll()))
                if (readyQueue.isEmpty()) break
            }
        }
        
        return currentProfit
    }
}