//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        //two pointer aproach
        long [] leftMax= new long [n];
        long [] rightMax= new long [n];
        
        leftMax[0]=arr[0];
        rightMax[n-1]=arr[n-1]; //genral case
        
        //to find left and rigth max of each element
        
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],arr[i]);
        }
        long ans=0; 
        // to find water to be filled (count the gaps or differnce 
        // between min of left and roght elements and that num iself)
        
        //as we will not consider filling up first and last blocks
        
        for(int j=1;j<n-1;j++){
            ans=ans+ Math.min(leftMax[j],rightMax[j])-arr[j];
        }
        return ans;
    } 
}
