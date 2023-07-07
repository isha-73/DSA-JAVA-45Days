import java.util.Stack;
//https://leetcode.com/problems/sliding-window-maximum
class Solution {
    public int[] maxSlidingWindow(int[] num, int k) {
        int n= num.length;
        Stack <Integer> st = new Stack<>();
        int [] ans = new int[n-k+1]; // n-(k-1) is size of max sliding windows for set k
        int [] nge= new int [n];

        // find out nge of elments
        // for nge
        st.push(n-1);
        nge[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && num[i]> num[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }else nge[i]=st.peek();

            st.push(i);
        }
            int j=0;
        for(int i=0;i<n-k+1;i++){
                   if(j>=(i+k)) j=i;
                    int max= num[j];
                    while(j<(i+k)){
                        max=num[j];
                        j=nge[j];
                    }

            ans[i]=max;
        }


        return ans;
    }
}