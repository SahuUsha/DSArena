/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        
        FindPair(target,head,ansList);
        
        return ansList;
    }
    
    public static void FindPair(int target , Node head , ArrayList<ArrayList<Integer>> ansList){
        if(head==null || head.next==null) return; 
        
        Node leftp = head;
        Node rightp  = head;
        
        while(rightp.next!=null){
            rightp =rightp.next;
        }
        
        while(leftp!=rightp && leftp!=null && rightp!=null){
            
            if(leftp.data + rightp.data ==target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(leftp.data);
                list.add(rightp.data);
                ansList.add(list);
                if(rightp==leftp.next){
                    break;
                }
                leftp = leftp.next;
                rightp = rightp.prev;
                
                
            }
           else if(leftp.data+rightp.data>=target){
                rightp = rightp.prev;
            }else if(leftp.data+rightp.data<target){
                leftp = leftp.next;
            }
            
        }
    
    
    }
    
}
