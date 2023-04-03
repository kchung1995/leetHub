class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var result: Int = 0

        var front = 0
        var end = people.size -1

        while (front < end) {
            if (people[front] + people[end] <= limit) {
                result++
                front++
                end--
            }
            else {
                if (people[end] <= limit) result++
                end--
            }
        }

        if (front == end && people[front] <= limit) result++

        return result
    }
}
