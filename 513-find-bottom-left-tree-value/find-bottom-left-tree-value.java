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
    public int findBottomLeftValue(TreeNode root) {
        bottomLeft(root,0);
        return bottom;
        
    }
    int bottom = 0;
    int maxDepth = -1;
    public void bottomLeft(TreeNode root , int level){
        if(root==null){
            return;
        }
     
     if(maxDepth<level){
        bottom = root.val;
        maxDepth = level;
     }
     
     bottomLeft(root.left,level+1);
     bottomLeft(root.right,level+1);
    }
}