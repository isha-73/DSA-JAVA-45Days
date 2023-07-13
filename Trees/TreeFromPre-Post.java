package Trees;

class Solution {
     public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return construct(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode construct(int[] preorder, int preLow, int preHigh, int[] postorder, int postLow, int postHigh) {
        if (preLow > preHigh || postLow > postHigh) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLow]);

        if (preLow == preHigh) {
            return root;
        }

        int leftRootValue = preorder[preLow + 1];
        int leftRootIndexPost = -1;

        for (int i = postLow; i <= postHigh; i++) {
            if (postorder[i] == leftRootValue) {
                leftRootIndexPost = i;
                break;
            }
        }

        int leftSize = leftRootIndexPost - postLow + 1;

        root.left = construct(preorder, preLow + 1, preLow + leftSize, postorder, postLow, leftRootIndexPost);
        root.right = construct(preorder, preLow + leftSize + 1, preHigh, postorder, leftRootIndexPost + 1, postHigh - 1);

        return root;
    }

}