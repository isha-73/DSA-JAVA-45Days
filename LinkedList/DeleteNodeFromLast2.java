/**
 * 
 * Problem Statement: Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Approach: Two pointer approach in one traversal
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
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= n; i++) {
            if (fast == null) {
                // Invalid input, n is greater than the length of the list
                return head;
            }
            fast = fast.next;
        }

        // If fast becomes null, it means n is equal to the length of the list
        // In this case, we need to remove the head node
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}