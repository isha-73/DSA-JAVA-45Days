//https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList <Integer> ans = new ArrayList<>();
        
        int rowStart=0;
        int rowEnd=matrix.length-1;
        int colStart=0;
        int colEnd=matrix[0].length-1;
        
        while(rowStart<=rowEnd && colStart<=colEnd){
            // traverse right 
            
            for(int i=colStart;i<=colEnd;i++){
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            //traverse down
            for(int i=rowStart;i<=rowEnd;i++){
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            //traverse left
            if (rowStart <= rowEnd) {
            for(int i=colEnd;i>=colStart;i--){
                ans.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            }
            
            //trvaerse up
            if (colStart <= colEnd) {
            for(int i=rowEnd;i>=rowStart;i--){
                 ans.add(matrix[i][colStart]);
            }
            colStart++;
            }
        }
        
        return ans;
    }
}
