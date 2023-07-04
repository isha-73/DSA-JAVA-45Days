
/*
 * https://leetcode.com/problems/copy-list-with-random-pointer
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * 
 */
class Solution {
    public Node copyRandomList(Node head) {
        //create deep copy
        Node temp1=head;
        Node head2 = new Node(0);
        Node temp2=head2;
       

        while(temp1!=null){
            Node n = new Node(temp1.val);
            temp2.next=n;
            temp2=n;
            temp1=temp1.next;
        }
        head2=head2.next;
        temp2=head2;

        //bringing back temp1 and temp2 (pointers of original and duplicate lists)
        temp1=head;

        //alternate connections

        Node temp=new Node(0);
        while(temp1!=null){
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;

            temp.next=temp2;
            temp2=temp2.next;
            temp=temp.next;
        }
         temp2=head2;
        //bringing back temp1 and temp2 (pointers of original and duplicate lists)
        temp1=head;

        //assigning random pointers

        while(temp1!=null && temp2!=null){
            if(temp1.random==null) temp2.random=null;
            else temp2.random=temp1.random.next;

            temp1=temp2.next;
            if(temp1==null) break;
            temp2=temp1.next;
        }

        temp2=head2;
        temp1=head;

        //separate the lists
        while(temp1!=null){
            temp1.next=temp2.next;
            temp1=temp1.next;
              if(temp1==null) break;
            temp2.next=temp1.next;
            if(temp2.next==null) break;
            temp2=temp2.next;
        }


        return head2;
    }
}