/**
 * To find Node where cycle starts in a linked list
 * https://leetcode.com/problems/linked-list-cycle-ii
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        boolean flag=false; // to detect cycle

        while(fast!=null && fast.next!=null){
             
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) {
                flag=true;
                break;
            }
            
        }

       if(flag){
        ListNode temp=head;
        while(slow!=temp){
            temp=temp.next;
            slow=slow.next;
        }
        return slow;
       }
       return null;
    }
}