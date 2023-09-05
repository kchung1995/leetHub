/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        val elementsPerHeight: MutableList<MutableList<Int>> = mutableListOf()
        traverse(0, root, elementsPerHeight)

        return elementsPerHeight.map { height -> height.maxOf { it } }
    }

    private fun traverse(height: Int, root: TreeNode?, elements: MutableList<MutableList<Int>>) {
        if (root == null) return

        if (elements.size - 1 < height) elements.add(mutableListOf<Int>())
        elements[height].add(root.`val`)

        traverse(height + 1, root.left, elements)
        traverse(height + 1, root.right, elements)
    }
}

