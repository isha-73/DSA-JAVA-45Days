// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        //approach: 
        /*
        -> inorder to find the maximum area of rectangle, first we will find out the possible 
        rectangles and then thier areas.
        -> Using stack we will fnd previous smaller height and next smaller height from the current heigth.
        -> Then based on the nse and pse, we will calculate area (max);
        */
    int n = heights.length;
    Stack <Integer> st = new Stack<>();
    int [] pse = new int [n]; //only contains index
    int [] nse = new int [n];

    // to calculate pse:(starting from first element) we will push element and pop from stack when element is greater than equal to current

    pse[0]=-1;  // as first element dont have prev element;
    st.push(0);
    for(int i=1;i<=n-1;i++){
        
        while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
            st.pop();
        }

        if(st.isEmpty()){
            pse[i]=-1;
        }
        else{
            pse[i]=st.peek();
        }

        st.push(i);
    }





    // to calculate nse:(starting from last element) we will push element and pop from stack when element is greater than equal to current

    nse[n-1]=n;  // as first element dont have prev element;
    st.push(n-1);
    for(int i=n-2;i>0;i--){
        
        while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
            st.pop();
        }

        if(st.isEmpty()){
            nse[i]=n;
        }
        else{
            nse[i]=st.peek();
        }

        st.push(i);
    }
       for(int i=0;i<n;i++){
        System.out.println(nse[i]);
        System.out.println(pse[i]);

    }

    //find the max area;
    int max=-1;
    for(int i=0;i<n;i++){
        int area= heights[i]*(nse[i]-pse[i]-1);
        max=Math.max(max,area);
    }
        return max;

    }
}