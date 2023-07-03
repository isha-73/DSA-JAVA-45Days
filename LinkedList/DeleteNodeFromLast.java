/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        if (count == n) {
            // If the first node is to be removed
            return head.next;
        }
        
        ListNode t = head;
        for (int i = 1; i < (count - n); i++) {
            t = t.next;
        }
        
        if (t.next != null) {
            t.next = t.next.next;
        }
        
        return head;
    }
}