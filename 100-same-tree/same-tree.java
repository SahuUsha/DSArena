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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null ) return true;

        if(p==null || q ==null) return false;
        
        if(p.val!=q.val) return false;

    
        return isSameTree(p.left , q.left)  && isSameTree(p.right , q.right);
    }

    public boolean isIdentical(TreeNode p, TreeNode q){

         Queue<TreeNode> que1 = new LinkedList<>();
         Queue<TreeNode> que2 = new LinkedList<>();

         que1.add(p);
         que2.add(q);

         while(!que1.isEmpty() && !que2.isEmpty()){

            TreeNode node1 = que1.poll();
            TreeNode node2 = que2.poll();

            if(node1.val!=node2.val){
                return false;
            }

            if(node1.left!=null && node2.left!=null){
                que1.add(node1.left);
                que2.add(node2.left);
            }
            else if(node1.left==null || node2.left==null){
                return false;
            }


             if(node1.right!=null && node2.right!=null){
                que1.add(node1.right);
                que2.add(node2.right);
            }
            else if(node1.right==null || node2.right==null){
                return false;
            }

         }
         return true;

    }
}