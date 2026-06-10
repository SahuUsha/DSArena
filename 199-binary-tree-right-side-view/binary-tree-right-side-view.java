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
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> List = new ArrayList<>();
          RightSideView(root , 1 , List);
          return List;
    }
    int maxdepth = 0;
     public void RightSideView(TreeNode root, int cl ,  List<Integer> ll ){
               if(root==null){
                return ;
               }
               if(maxdepth<cl){
                // System.out.println(root.val+" ");
                ll.add(root.val);
                maxdepth = cl;
               }
               RightSideView(root.right, cl+1 ,ll);
               RightSideView(root.left, cl+1 , ll);
        }

}