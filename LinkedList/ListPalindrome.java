/*
 * https://leetcode.com/problems/palindrome-linked-list
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Find out the middle of the list (if even then left middle)
        // then reverse the right half list
        //keep pointer p1 and p2 to compare left and right halves inorder 
        //to proove if palindrom or not

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

        while(p2!=null){
            if(p1.val!=p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;

         
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