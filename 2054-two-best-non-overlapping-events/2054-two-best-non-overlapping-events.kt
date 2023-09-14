data class Event(val time: Int, val value: Int, val isStart: Boolean)

class Solution {
    fun maxTwoEvents(givenEvents: Array<IntArray>): Int {
        var result = 0
        var maxValue = 0
        val events = Array<Event>(givenEvents.size * 2) { Event(0, 0, false) }

        for (i in givenEvents.indices) {
            val start = givenEvents[i][0]
            val end = givenEvents[i][1]
            val value = givenEvents[i][2]
            events[i * 2] = Event(start, value, true)
            events[i * 2 + 1] = Event(end + 1, value, false)
        }

        events.sortWith(compareBy({ it.time }, { it.isStart }))

        for (event in events) {
            if (event.isStart) {
                result = maxOf(result, event.value + maxValue)
            } else {
                maxValue = maxOf(maxValue, event.value)
            }
        }

        return result
    }
}

