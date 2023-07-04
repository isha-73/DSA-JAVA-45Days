/*
 * Given the head of a singly linked list and two integers 
 * left and right where left <= right, reverse the nodes 
 * of the list from position left to position right, and return the reversed list.
 * https://leetcode.com/problems/reverse-linked-list-ii
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevLeft = dummy;
        ListNode cur = head;

        // Move cur to the left node
        for (int i = 1; i < left; i++) {
            prevLeft = cur;
            cur = cur.next;
        }

        // Reverse the sublist between left and right nodes
        ListNode prev = null;
        ListNode next = null;
        ListNode leftNode = cur; // Store the original left node for later connection
        for (int i = left; i <= right; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // Connect the reversed sublist to the original list
        prevLeft.next = prev;
        leftNode.next = cur;

        return dummy.next;
    }
}


