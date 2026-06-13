/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    private  void makeParents(TreeNode root , Map<TreeNode, TreeNode> parents_track ){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left!=null){
                parents_track.put(node.left,node);
                q.offer(node.left);
            }

            if(node.right!=null){
                parents_track.put(node.right,node);
                q.offer(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents_track = new HashMap<>();
        Map<TreeNode,Boolean> visited =new HashMap<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        makeParents(root,parents_track);
        queue.offer(target);
        visited.put(target,true);
        int dis =0;
        while(!queue.isEmpty()){
            int size  = queue.size();
            if(dis==k) break;
            dis++;
            for(int i = 0 ; i<size ; i++){
             TreeNode curr = queue.poll();
             visited.put(curr,true);
             if(visited.get(parents_track.get(curr))==null && parents_track.get(curr)!=null){
                  queue.offer(parents_track.get(curr));
                  visited.put(parents_track.get(curr),true);
             }

             if(curr.left!=null && visited.get(curr.left)==null){
                queue.offer(curr.left);
                visited.put(curr.left,true);
             }

             if(curr.right!=null && visited.get(curr.right)==null){
                queue.offer(curr.right);
                visited.put(curr.right,true);
             }

         
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }
}