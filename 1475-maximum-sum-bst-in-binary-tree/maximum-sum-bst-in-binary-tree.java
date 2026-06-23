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
class Info{
    boolean isBST;
    int min;
    int max;
    int sum;

    Info(boolean isBST, int min, int max,int sum){
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

int ans = 0;

    public int maxSumBST(TreeNode root) {
        DFS(root);
        return ans;
    }

    public Info DFS(TreeNode root){
        if(root==null){
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        }
        
        Info left = DFS(root.left);
        Info right = DFS(root.right);

       
       
       if(left.isBST && right.isBST && 
         left.max<root.val && right.min>root.val){

          
          int sum =left.sum + right.sum + root.val;

           ans = Math.max(ans,sum);


           int minValue = Math.min(left.min,root.val);
           int maxValue = Math.max(right.max,root.val);

           return new Info(true,minValue,maxValue,sum);

         }
        return new Info(false,0,0,0);
    }

}