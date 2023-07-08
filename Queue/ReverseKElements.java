package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void main(String[] args) {
        Queue <Integer> q = new LinkedList<>();
        Stack <Integer> st = new Stack<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        int k = 3;

        for(int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        while(!st.isEmpty()) {
            q.add(st.pop());
        }
        for(int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
        System.out.println(q);
        

    }
}
