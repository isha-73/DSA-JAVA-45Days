class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        if (root == null) {
            return 0;
        }

        Node lca = findLCA(root, a, b);

        int distanceA = findDistance(lca, a, 0);
        int distanceB = findDistance(lca, b, 0);

        return distanceA + distanceB;

    }

    static Node findLCA(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b)
            return root;

        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            // it means a and b are on diggerent sub trees
            return root; // so theie lca will be the root itself
        }
        if (left == null)
            return right;
        else
            return left;
    }

    static int findDistance(Node root, int a, int level) {
        if (root == null)
            return -1;
        if (root.data == a) {
            return level;
        }
        int leftdist = findDistance(root.left, a, level + 1);
        if (leftdist != -1) {
            return leftdist;
        }
        return findDistance(root.right, a, level + 1);
    }
}