/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node==null){
                ans.append("n ");
                continue;
            }
             
             ans.append(node.val+" ");
             queue.add(node.left);
             queue.add(node.right);
        }

        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        String []values = data.split(" ");
        if(values[0].equals("n")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int  i = 1 ;i<values.length ;i++){
            TreeNode parents = q.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parents.left = left;
                q.add(left);
            }

            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parents.right = right;
                q.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));