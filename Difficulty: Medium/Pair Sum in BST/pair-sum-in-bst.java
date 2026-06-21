/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    Set<Integer> set = new HashSet<>();
    boolean findTarget(Node root, int target) {
        // Write your code here
        if(root==null) return false;
        
        if(set.contains(target-root.data)) return true;
        set.add(root.data);
        
        return findTarget(root.left,target) || findTarget(root.right,target);
        
    }
    
    
}