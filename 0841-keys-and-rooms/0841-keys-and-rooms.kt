class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val roomsNotVisited = (0 until rooms.size).toMutableSet()
        val roomsCandidate = mutableListOf<Int>(0)

        while(roomsCandidate.isNotEmpty()) {
            val currentRoom = roomsCandidate.removeFirst()
            roomsNotVisited.remove(currentRoom)

            val keys = rooms[currentRoom]
            for (key in keys) {
                if (roomsNotVisited.contains(key)) {
                    roomsCandidate.add(key)
                }
            }
        }

        return roomsNotVisited.isEmpty()
    }
}

