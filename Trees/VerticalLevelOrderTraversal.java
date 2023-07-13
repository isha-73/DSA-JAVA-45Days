package Trees;
    import java.util.*;
public class VerticalLevelOrderTraversal {

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
            this.horizontalDistance = horizontalDistance;// horizontal distance is basically the level of the node vertically
        }
    }

    static List<List<Integer>> verticalLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Map<Integer, LinkedHashSet<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int horizontalDistance = pair.horizontalDistance;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, new LinkedHashSet<>());
            }

            map.get(horizontalDistance).add(node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, horizontalDistance - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, horizontalDistance + 1));
            }
        }

        for (LinkedHashSet<Integer> levelNodes : map.values()) {
            result.add(new ArrayList<>(levelNodes));
        }

        return result;
    }
    public static void main(String[] args) {
        //create a tree 
        Node root = new Node(1);
        root.left = new Node(2);

        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.right.left = new Node(6);


        //print the vertical level order traversal of the tree
        System.out.println(verticalLevelOrder(root));
    }
}

