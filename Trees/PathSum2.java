package Trees;
//https://leetcode.com/problems/path-sum-ii/
class Solution {
    static void addsum ( List<List<Integer>> ans,List<Integer> arr,TreeNode root, int sum){
        if(root==null) return;
        //if leaf node ,means path completed
        if(root.left==null && root.right==null){
            arr.add(root.val);
            if(root.val==sum) {
                List<Integer> fin = new ArrayList<>();
                fin.addAll(arr);
                ans.add(fin);
            }
            arr.remove(arr.size()-1); //backtracking
            return;
        }

        arr.add(root.val);
        addsum(ans,arr,root.left,sum-root.val);
        addsum(ans,arr,root.right,sum-root.val);

         arr.remove(arr.size()-1); //backtracking
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        addsum(ans,arr,root,targetSum);
        return ans;
    }
}