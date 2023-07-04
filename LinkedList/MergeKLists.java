// Divide And Conqure method: using 2 list merge method
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Check if the input array is empty or null
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        int interval = 1;
        // Merge pairs of linked lists iteratively
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                // Merge two lists at index i and i + interval
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;  // Double the interval size for the next iteration
        }
        
        return lists[0];  // Return the final merged list
    }
    
    // Merge two sorted linked lists into a single sorted list
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy node as the head of the merged list
        ListNode curr = dummy;  // Pointer to track the current node in the merged list
        
        // Compare the values of nodes from both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;  // Connect current node to l1
                l1 = l1.next;  // Move l1 pointer forward
            } else {
                curr.next = l2;  // Connect current node to l2
                l2 = l2.next;  // Move l2 pointer forward
            }
            curr = curr.next;  // Move the pointer in the merged list forward
        }
        
        // Append any remaining nodes from l1 or l2 to the merged list
        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }
        
        return dummy.next;  // Return the head of the merged list
    }
}

//Heap method

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a min-heap (priority queue) with a custom comparator to sort nodes
  
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // Add all the head nodes from the linked lists to the min-heap
      for(ListNode list:lists){
                      if (list != null) {
                minHeap.offer(list);
            }
      }

        // Create a dummy node as the head of the merged list
     ListNode dummy = new ListNode();
     ListNode cur= dummy;

        // Process the nodes in the min-heap

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            cur.next=node;
            cur=node;
            if(node.next!=null){
                minHeap.offer(node.next);
            }
        }

       // Return the merged list
        return dummy.next;
    }
}