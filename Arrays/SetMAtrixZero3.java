class Solution {
    // Space O(m+n)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList <Integer> r= new ArrayList<>();
        ArrayList <Integer> c= new ArrayList<>();

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    r.add(i);
                    c.add(j);
                }
            }
        }
        System.out.println(r);
        System.out.println(c);
        // // make row zero

        for(int row:r){
            for(int j=0;j<m;j++){
                matrix[row][j]=0;
            }
        }

        // // make column zero

        for(int col:c){
            for(int j=0;j<n;j++){
                matrix[j][col]=0;
            }
        }
      
        
    }
}
