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
    int maxRange =Integer.MAX_VALUE;
    int minRange =Integer.MIN_VALUE;
    Pair(int minRange ,int maxRange){
        this.minRange = minRange;
        this.maxRange = maxRange;
    }
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
     HashMap<Integer,Pair> map = new HashMap<>();
     TreeNode root = new TreeNode(preorder[0]);
     map.put(root.val, new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE));
     for(int i = 1 ; i<preorder.length ; i++){
        TreeNode newNode = new TreeNode(preorder[i]);
        TreeNode prev = null;
        TreeNode temp = root;
        while(temp!=null){
            prev = temp;
            if(preorder[i]>temp.val){
               temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        Pair ptemp = map.get(prev.val);
       if (preorder[i] < prev.val) {
            prev.left = newNode;
            map.put(preorder[i], new Pair(ptemp.minRange, prev.val));
        } else {
           prev.right = newNode;
            map.put(preorder[i], new Pair(prev.val, ptemp.maxRange));
        }
    }

    return root;
    }
}