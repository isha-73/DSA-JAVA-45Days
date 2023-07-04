/**
 * Question: https://leetcode.com/problems/odd-even-linked-list/
 * Approach: Given the head of a singly linked list, group all the nodes with odd indices together followed by 
 * the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }
}
