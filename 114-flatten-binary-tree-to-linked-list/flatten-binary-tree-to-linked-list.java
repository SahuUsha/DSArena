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

      
        // while(curr!=null){
            
        //     if(curr.left==null){
        //         list.add(curr.data);
        //         curr = curr.right;
        //     }else{
        //         Node prev = curr.left;
                
        //         while(prev.right!=null && prev.right!=curr){
        //             prev = prev.right;
        //         }
        //         if(prev.right==null){
        //             prev.right=curr;
        //             list.add(curr.data);
        //             curr = curr.left;
        //         }else{
        //             prev.right=null;
        //             curr = curr.right;
        //         }
                
                
        //     }
        // }
        
    public void flatten(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                curr = curr.right;
            }else{

            TreeNode prev = curr.left;

            while(prev.right!=null && prev.right!=curr){
                prev = prev.right;
            }

            if(prev.right==null){
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }else{
                curr.right = curr.left;
                curr.left = null;
            }

            }

        }

    }
}