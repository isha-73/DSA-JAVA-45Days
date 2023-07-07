/*
 * 
 * https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621
 */

import java.util.Stack;

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
         int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Push the first day index onto the stack
        stack.push(0);
        spans[0] = 1;
        
        for (int i = 1; i < n; i++) {
            // Pop elements from the stack while the current price is greater than the price at the top of the stack
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            
            // Calculate the span by subtracting the index of the previous largest element from the current index
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            
            // Push the current index onto the stack
            stack.push(i);
        }
        return spans;
    }
    
}