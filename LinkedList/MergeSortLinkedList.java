public class MergeSortLinkedList {

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        // Split the linked list into two halves
        middle.next = null;

        // Recursive calls to mergeSort for both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        Node sortedList = merge(left, right);
        return sortedList;
    }

    private static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 5 -> 2 -> 8 -> 3 -> 1
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(8);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);

        System.out.println("Original linked list:");
        printList(head);

        // Sort the linked list using Merge Sort
        head = mergeSort(head);

        System.out.println("Sorted linked list:");
        printList(head);
    }
}
