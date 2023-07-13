package Trees;// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree
import java.util.*;
// basic idea is using horizantal level order traversal and using a map to store the first element of each vertical level
class Solution {
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
    private static class Pair {
        Node node;
        int horizontalDistance;

        public Pair(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int horizontalDistance = pair.horizontalDistance;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, node.data);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, horizontalDistance - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, horizontalDistance + 1));
            }
        }

        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }
}