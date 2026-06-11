/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        allPath(root,new ArrayList<>(),ans);
        return ans;
        
    }
    public void allPath(Node root , ArrayList<Integer> path  , ArrayList<ArrayList<Integer>> ans){
        if(root==null) return;
        
        path.add(root.data);
        
        if(root.left==null && root.right == null ){
            ans.add(new ArrayList<>(path));
        }else{
            
        allPath(root.left , path ,ans);
        allPath(root.right , path,ans);
        }
        
        path.remove(path.size()-1);
        
        
    }
}