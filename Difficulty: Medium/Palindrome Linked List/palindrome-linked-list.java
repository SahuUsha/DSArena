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
         if(head==null || head.next==null){
            return true;
        }
        
        Node headNode = head;
        
        Node middle = findMiddle(headNode);
        Node secondReverse = reverse(middle.next);
        
        Node temp = head;
        
        while(secondReverse!=null){
            
            if(temp.data!=secondReverse.data){
                return false;
            }
            
            temp = temp.next;
            secondReverse = secondReverse.next;
        }
        
        return true;
    }
    
    public Node findMiddle(Node head){
        Node first = head;
        Node second = head;
        
        while(second.next!=null && second.next.next!=null){
            
            first = first.next;
            second = second.next.next;
        }
        
        return first;
    }
        
    public Node reverse(Node head){
        Node temp = head;
        Node prev = null;
        
        while(temp!=null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        
        return prev;
        
    }
    
        
    public boolean isPalindromebyList(Node head) {
        
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