class Solution {
    Node divide(Node head) {

        if (head == null || head.next == null)
            return head;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node odd = head;
        Node even = head;

        while (even != null) {

            Node evenNext = even.next;
            even.next = null;

            if (even.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = even;
                } else {
                    evenTail.next = even;
                    evenTail = even;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = even;
                } else {
                    oddTail.next = even;
                    oddTail = even;
                }
            }

            even = evenNext;
        }

        if (evenHead == null)
            return oddHead;

        evenTail.next = oddHead;

        return evenHead;
    }
}