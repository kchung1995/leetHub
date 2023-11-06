class SeatManager(n: Int) {

    val numberOfSeats: Int = n
    val seats = HashSet<Int>()    
    var smallestNumberedUnreservedSeat: Int = 1

    fun reserve(): Int {
        val reservedSeat: Int = smallestNumberedUnreservedSeat
        seats.add(smallestNumberedUnreservedSeat)
        for (i in smallestNumberedUnreservedSeat + 1 .. numberOfSeats + 1) {
            if (seats.contains(i).not()) {
                smallestNumberedUnreservedSeat = i
                break
            }
        }

        return reservedSeat
    }

    fun unreserve(seatNumber: Int) {
        seats.remove(seatNumber)
        smallestNumberedUnreservedSeat = minOf(smallestNumberedUnreservedSeat, seatNumber)
        require(1 <= smallestNumberedUnreservedSeat && smallestNumberedUnreservedSeat <= numberOfSeats)
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * var obj = SeatManager(n)
 * var param_1 = obj.reserve()
 * obj.unreserve(seatNumber)
 */

