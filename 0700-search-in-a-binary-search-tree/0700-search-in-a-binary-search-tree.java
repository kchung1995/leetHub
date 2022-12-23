/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode find(TreeNode current, int val) {
        if (current.val == val) {
            return current;
        }
        if (!Objects.equals(current.right, null) && current.val < val) {
            return find(current.right, val);
        }
        if (!Objects.equals(current.left, null) && current.val > val) {
            return find(current.left, val);
        }
        
        return null;
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
        return find(root, val);
    }
}