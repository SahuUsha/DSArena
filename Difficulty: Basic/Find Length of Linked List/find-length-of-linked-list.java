/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
        
        if(head==null){
            return 0;
        }
        // code here
        Node temp = head;
        int count =1;
        
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        
        return count;
    }
}