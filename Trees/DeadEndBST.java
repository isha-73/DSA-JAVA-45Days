package Trees;

/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG {
    public static boolean isDeadEnd(Node root) {
        return isDeadEndHelper(root, 1, Integer.MAX_VALUE);
    }

    private static boolean isDeadEndHelper(Node root, int min, int max) {
        if (root == null) {
            // An empty subtree doesn't have a dead end.
            return false;
        }

        // Check if the current node is a dead end.
        if (min == max) {
            return true;
        }

        // Check the left subtree with the updated range.
        boolean left = isDeadEndHelper(root.left, min, root.data - 1);

        // Check the right subtree with the updated range.
        boolean right = isDeadEndHelper(root.right, root.data + 1, max);

        // Return true if any subtree has a dead end.
        return left || right;
    }
}
