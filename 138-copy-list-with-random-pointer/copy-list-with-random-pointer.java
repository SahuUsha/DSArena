/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        insertNodeInBetween(head);
        connectRandomNode(head);
        return joinAndDisconnectNext(head);

    }

    public void insertNodeInBetween(Node head){
        Node temp = head;

        while(temp!=null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next=newNode;

            temp = temp.next.next;
        }
    }

    public void connectRandomNode(Node head){

        Node temp = head;

        while(temp!=null){

            if(temp.random!=null){
            temp.next.random  = temp.random.next;
            }

            temp = temp.next.next;
        }
    }


    public Node joinAndDisconnectNext(Node head){
        Node dummyList = new Node(-1);
        Node dum = dummyList;

        Node temp = head;

        while(temp!=null){
            Node child = temp.next;
            dum.next = child;
            dum  = child;
            temp.next = child.next;

            temp = child.next;
        }
        return dummyList.next;
    }
}