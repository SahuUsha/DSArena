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
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> res = new ArrayList<>();
        // postorder( root , res);
        // return res;
        return InterativePostOrder(root);
    }
    public void postorder(TreeNode root , List<Integer> res){
        if(root==null){
            return;
        }

        postorder(root.left , res);
        postorder(root.right , res);
        res.add(root.val);
    }

    public List<Integer> InterativePostOrder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        // Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty()){

            TreeNode node = s1.pop();
            if(node==null){
                continue;
            }
           
            // s2.push(node);
            list.add(node.val);

            if(node.left!=null){
                s1.push(node.left);
            }
            if(node.right!=null){
                s1.push(node.right);
            }
        }
    //     int size = s2.size();
    //     for(int i = 0; i<size;i++){
    //         TreeNode r1 = s2.pop(); 
    //         list.add(r1.val);
    //    }
    int size = list.size()/2;
    for(int i = 0; i<size;i++){
        int temp = list.get(i);
        list.set(i,list.get(list.size()-i-1));
        list.set(list.size()-i-1, temp);
    }

    
        return list;
    }
}