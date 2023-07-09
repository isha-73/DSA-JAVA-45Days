package Queue;
import java.util.*;
public class ReduceInterleaveQueue {
    public static void main(String[] args) {
        Queue <Integer> q = new LinkedList<>();
        Stack <Integer> st = new Stack<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        int n = q.size();

        // put the first half elemnts in stack
        for(int i = 0; i < n/2; i++) { // 11 12 13
            st.push(q.remove());
        }

        // enqueue back the stack elements
        while(!st.isEmpty()) { // 14 15 16 13 12 11
            q.add(st.pop());
        }

        // dequeue the first half elements of queue 
        for(int i = 0; i < n/2; i++) {
            st.push(q.remove()); 
            // 14 15 16
        } 
        
        // queue: 13 12 11
        // stack: 16 15 14
        // continue enquing stack elements and dequeuing-enquing queue elements
        // 
        while(!st.isEmpty()) {
            q.add(st.pop());
            q.add(q.remove());
        }
        // quueue : 16,13,15,12,14,11
        // reverse the queue
        for(int i = 0; i < n; i++) {
           st.push(q.remove());

        }
        while(!st.isEmpty()) {
            q.add(st.pop());
        }
        System.out.println(q);
        
    }
}
