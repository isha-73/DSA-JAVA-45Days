package Trees; // https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree
import java.util.*;
class Solution
{
     static class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
    static class Pair{
        Node node;
        int verticalLevel;
        Pair(Node node, int i){
            this.node=node;
            verticalLevel=i;
        }
    }
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Queue <Pair> q = new LinkedList<>();
        TreeMap <Integer, Integer> map = new TreeMap<>();
        
        q.add(new Pair(root,0)); // root has vertical level 0
        
        while(!q.isEmpty()){
            
            Pair pair = q.remove();
            Node node = pair.node;
            int level = pair.verticalLevel;
            
            map.put(level,node.data); // if we put condition on it like if anyone with same vertical level exist then don add , this is solution of top view
            if(node.left!=null) q.add(new Pair(node.left,level-1));
            if(node.right!=null) q.add(new Pair(node.right,level+1));
            
        }
          for (int value : map.values()) {
            ans.add(value);
        }
        return ans;
    }
}