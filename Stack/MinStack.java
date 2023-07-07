import java.util.Stack;

class MinStack { // leetcode
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE; // Set initial minimum to the maximum possible value
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            min = (long) val;
        } else if (val >= min) {
            st.push((long) val);
        } else {
            st.push(2L * val - min); // Store the "adjusted" value on the stack
            min = val; // Update the minimum
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        long top = st.pop();
        if (top < min) {
            min = 2 * min - top; // Restore the previous minimum value
        }
    }

    public int top() {
        if (st.isEmpty()) {
            return -1; // Stack is empty
        }
        long top = st.peek();
        if (top < min) {
            return (int) min; // Minimum value is at the top of the stack
        } else {
            return (int) top; // Top value is greater than or equal to the minimum
        }
    }

    public int getMin() {
        return (int) min;
    }
}