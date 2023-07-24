package Trees;

public static void findPreSuc(Node root, int key) {
    if (root == null) {
        // The tree is empty, return immediately.
        return;
    }

  

    // Search for the key in the tree while updating the predecessor and successor nodes.
    while (root != null) {
        if (root.data == key) {
            // Key is found, handle the predecessor and successor cases.
            if (root.left != null) {
                // If the left subtree exists, predecessor is the rightmost node in the left subtree.
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
            }

            if (root.right != null) {
                // If the right subtree exists, successor is the leftmost node in the right subtree.
                suc = root.right;
                while (suc.left != null) {
                    suc = suc.left;
                }
            }

            // We found the key, no need to continue the search.
            break;
        } else if (root.data > key) {
            // Key is smaller than the current node, move to the left subtree.
            suc = root; // The current node can be a potential successor.
            root = root.left;
        } else {
            // Key is larger than the current node, move to the right subtree.
            pre = root; // The current node can be a potential predecessor.
            root = root.right;
        }
    }

    // The values of pre and suc will be printed automatically by the driver code.
}
