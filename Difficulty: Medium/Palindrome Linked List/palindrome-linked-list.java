/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        
        Node temp = head;
        while(temp!=null){
             list.add(temp.data);
             temp = temp.next;
        }
        
        
        int left  = 0;
        int right = list.size()-1;
        
        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        
        
        return true;
    }
}