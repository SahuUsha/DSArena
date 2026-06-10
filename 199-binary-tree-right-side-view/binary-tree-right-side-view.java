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

 class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node , int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> List = new ArrayList<>();
        //   RightSideView(root , 1 , List);
        rightView(root,List);
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


// By BFS;

         public void rightView(TreeNode root , List<Integer> list) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        if(root==null) return;

        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pq = q.poll();
            
            map.put(pq.level, pq.node.val);
            
            if(pq.node.left!=null){
                q.offer(new Pair(pq.node.left,pq.level+1));
            }
            
            if(pq.node.right!=null){
                q.offer(new Pair(pq.node.right,pq.level+1));
            }
            
        }
        // ArrayList<Integer> list = new ArrayList<>();
        
        for(int m : map.values()){
            list.add(m);
        }
        
        // return list;
    }

}