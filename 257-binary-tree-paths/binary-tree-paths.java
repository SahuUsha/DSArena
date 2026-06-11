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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        TreePath(root ,res ,"");
        return res;
        
    }

    public void TreePath(TreeNode root , List<String> res , String path){
        
        if(root.left==null && root.right==null ){
            // if(path.length())
            res.add(path+root.val);
         
        }

         if(root.left!=null) TreePath(root.left , res , path+String.valueOf(root.val)+"->");
        if(root.right!=null) TreePath(root.right , res , path+String.valueOf(root.val)+"->");
    

    }
}