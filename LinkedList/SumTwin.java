/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 * Approach: 1) Finding middle
 *  2) Reverse the right sublist 
 * 3) then add the val of pointers p1 and p2 of left and right lists.
 */

class Solution {
    public int pairSum(ListNode head) {
        
      ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow is middle

        ListNode node= reverse(slow.next);
        // slow.next=node;

        ListNode p1=head;
        ListNode p2=node;
        int max=0;
        while(p2!=null){
           int sum = (p1.val+p2.val);
            max=Math.max(max,sum);
            p1=p1.next;
            p2=p2.next;
        }
        return max;

         
    }
    ListNode reverse(ListNode head) {
    ListNode curr=head;
    ListNode prev=null;
    ListNode after=null;

    while(curr!=null){
        after=curr.next;
        curr.next=prev;
        prev=curr;
        curr=after;
    }
        return prev;
    }
}