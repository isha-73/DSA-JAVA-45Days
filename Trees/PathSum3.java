package Trees;
//https://leetcode.com/problems/path-sum-iii

class Solution {
    static int totalPaths(TreeNode root, long target){
        if(root==null) return 0;
        int count=0;

        if((long)root.val==target) count++;

        return count + totalPaths(root.left,target-(long)root.val)+ totalPaths(root.right,target-(long)root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int count = totalPaths(root,(long)targetSum);
        count+= (pathSum(root.left,targetSum)+pathSum(root.right,targetSum));
        return count;
    }
}