package Trees;
import java.util.*;
//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected

 //Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
public class AverageTimetoIgnite {
    static TreeNode findNode(TreeNode root, int start){
        if(root==null) return null;
        if(root.val==start) return root;
        TreeNode left = findNode(root.left,start);
        TreeNode right = findNode(root.right,start);
        if(left==null) return right;
        else return left;
    }


    static void preorder(TreeNode root, Map<TreeNode,TreeNode> parent){ // child - parent
    if(root==null) return;
    if(root.left!=null) parent.put(root.left,root);
    if(root.right!=null) parent.put(root.right,root);

    preorder(root.left,parent);
    preorder(root.right,parent);
    }


    public int amountOfTime(TreeNode root, int start) {
        TreeNode node = findNode(root,start);
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        preorder(root,parent);
        //bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        Map<TreeNode,Integer> v = new HashMap<>(); // will consist of nodes who are ignited
        v.put(node,0); // 0 is time in min -> level

        while(q.size()>0){
            TreeNode temp = q.poll();
            int level = v.get(temp); 
            // node will ignite to its connected ones, ways to check ->
            if(temp.left!=null && !v.containsKey(temp.left)){ 
                q.add(temp.left);
                v.put(temp.left,level+1);
            }
              if(temp.right!=null && !v.containsKey(temp.right)){
                q.add(temp.right);
                v.put(temp.right,level+1);
            }
            if(parent.containsKey(temp)&& !v.containsKey(parent.get(temp))){
            //check parent status
             q.add(parent.get(temp));
                v.put(parent.get(temp),level+1);
            }
        }

    int max = -1;
    for(int val : v.values()){
        max=Math.max(max,val);
       
    }

    return max;
    }
}