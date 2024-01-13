class Solution {
    fun findTheWinner(n: Int, k: Int): Int {
        val friends = BooleanArray(n)

        var friendCount: Int = n
        var friendsPoint = n

        while (friendCount > 1) {
            for (i in 0 until k) {
                while (friends[friendsPoint % n]) {
                    friendsPoint++
                }
                friendsPoint++
            }
            friends[(friendsPoint - 1) % n] = true
            friendCount--
        }

        friendsPoint = 0
        while (friends[friendsPoint]) friendsPoint++
        return friendsPoint + 1
    }
}

