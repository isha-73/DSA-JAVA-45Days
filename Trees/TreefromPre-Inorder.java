package Trees;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions
class Solution {
     static TreeNode construct(int[] preorder,int prelow, int prehi, int[] inorder,int inlow,int inhi){
         if(prelow>prehi) return null;
         TreeNode root = new TreeNode(preorder[prelow]);
         int i=inlow;
         while(inorder[i]!=preorder[prelow]) i++; // to find root in inorder and its index
         int leftsize= i-inlow;
         root.left=construct(preorder,prelow+1, prelow+leftsize,inorder,inlow,i-1);
         root.right=construct(preorder,prelow+leftsize+1,prehi,inorder,i+1,inhi);
return root;

     }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= preorder.length;
        return construct(preorder,0,n-1,inorder,0,n-1);
    }
}