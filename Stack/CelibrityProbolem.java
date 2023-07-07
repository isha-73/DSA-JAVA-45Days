//https://practice.geeksforgeeks.org/problems/the-celebrity-problem

import java.util.Stack;

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int m[][], int n)
    {
    	// code here 
    	Stack <Integer> st= new Stack<>();
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	while(st.size()>1){
    	    int p1=st.pop();
    	    int p2=st.pop();
    	    if(m[p1][p2]==0){
    	        st.push(p1); // possible that p1 is celebrity and discard p2;
    	    }else if(m[p2][p1]==0){
    	        st.push(p2); // possible that p2 is celebrity and discard p1;
    	    }
    	}
    	if(st.isEmpty()) return -1;
    	int p = st.pop();
    	// check rowsise if the person in stack knows anyone , if yes return else continue
    	for(int j=0;j<n;j++){
    	    if(m[p][j]==1) return -1;
    	}
    	//check column wisse, if anyone dont know p, return
    	
    	for (int i=0;i<n;i++){
    	    if(p==i) continue;
    	    if(m[i][p]==0){
    	        return -1;
    	    }
    	}
    	return p;
    	
    }
}