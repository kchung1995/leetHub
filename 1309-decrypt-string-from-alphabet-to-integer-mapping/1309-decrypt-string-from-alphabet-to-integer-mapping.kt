class Solution {
    fun freqAlphabets(s: String): String {
        var sb = StringBuilder()
				val n = s.length
				var i: Int = 0

				while (i < n) {
					if (i + 2 < n && s[i + 2] == '#') {
						val num = s.substring(i, i + 2).toInt()
						sb.append('a' + num - 1)
						i += 3
					}
					else {
						val num = s[i] - '0'
						sb.append('a' + num - 1)
						i++
					}
				}

        return sb.toString()
    }
}

