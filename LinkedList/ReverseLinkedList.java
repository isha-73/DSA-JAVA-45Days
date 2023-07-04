/**
Recusive solution
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){return null;}
        ListNode newHead = reverse(head);
        return newHead;
    }
    static ListNode reverse(ListNode head){
        if(head.next==null) return head;

        ListNode newHead= reverse(head.next);
        head.next.next=head; //interchange link
        head.next=null; //break old link
        return newHead;

    }
}
/*
 * Iterative solution
 */

