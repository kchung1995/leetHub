class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val a = num1.split("+", "i").filter { it.isNotEmpty() }
        val b = num2.split("+", "i").filter { it.isNotEmpty() }
        val (aReal, aImaginary) = Pair(a[0].toInt(), a[1].toInt())
        val (bReal, bImaginary) = Pair(b[0].toInt(), b[1].toInt())

        val real = aReal * bReal - aImaginary * bImaginary
        val imginary = aReal * bImaginary + aImaginary * bReal

        return "${real}+${imginary}i"
    }
}

