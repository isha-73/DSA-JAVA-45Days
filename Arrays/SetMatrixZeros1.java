// space O(m*n)
// Link= https://leetcode.com/problems/set-matrix-zeroes/
class Solution { 
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] grid= new int [n][m];

           for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    grid[i][j]=matrix[i][j];
            }
            }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(matrix[i][j]==0){
                    modify(grid,i,j);
                    
                }
            }
        }

             for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    matrix[i][j]=grid[i][j];
            }
            }
    }

    static void modify(int [][]arr, int row,int col){
      
        int n=arr.length;
        int m=arr[0].length;
        // 0 in row
        for(int i=0;i<m;i++){
            arr[row][i]=0;
        }
         // 0 in col
        for(int i=0;i<n;i++){
            arr[i][col]=0;
        }
    
    }
}