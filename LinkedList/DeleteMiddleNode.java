// Delete Middle Node in Linked List using 2 pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
// url: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        /**

        fast node is 2X times fast than slow node
        to delete mid in odd list: 
        loop till fast.next.next.next is not true

        right mid in even list:
        loop till fast.next.next is not true

        left mid:
        fast.next.next.next.next
         */
         if(fast.next==null){
             return null;
         }

         while( fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
        }
        slow.next=slow.next.next;

        return head;


    }
}