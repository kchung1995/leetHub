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
    
    boolean result = false;
    
    public boolean dfs(TreeNode root, TreeNode subRoot) {
        // if the root of current tree is same
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root.val == subRoot.val && !result) {
            result = dfs(root, subRoot);
            if(result) return result;
        }
        
        if (root.left != null) {
            isSubtree(root.left, subRoot);
        }
        if (root.right != null) {
            isSubtree(root.right, subRoot);
        }
        
        return result;
    }
}