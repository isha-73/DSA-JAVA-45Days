// Problem: Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){return null;}
        if(head.next==null){return head;}
        ListNode temp=head;

        while(temp!=null){

            while(temp.next!=null && temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        
        return head;
    }
}