package Queue;
//https://leetcode.com/problems/implement-stack-using-queues
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue <Integer> q;
    public MyStack() {
        q= new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
          for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());
        }
        int val= q.remove();
        return val;
    }
    
    public int top() {
        // peek
        //loop till ast element of the queue which will shift first n-1 elements at bak of last one

        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());
        }
        int val= q.peek();
        q.add(q.remove());
        return val;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */