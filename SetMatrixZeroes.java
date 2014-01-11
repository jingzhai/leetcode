public class Solution {
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = matrix.length;
        if (m==0) return;
        int n = matrix[0].length;
        
                
        boolean colzero=false;
        for (int j=0;j<n;j++) {
            if (matrix[0][j]==0) {
                colzero = true;
                break;
            }
        }
        boolean rowzero=false;
        for (int i=0;i<m;i++) {
            if (matrix[i][0]==0) {
                rowzero = true;
                break;
            }
        }

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        } 
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        
        if (colzero) {
            for (int j=0;j<n;j++) {
                matrix[0][j]=0;
            }
        }
        
        if (rowzero) {
            for (int i=0;i<m;i++) {
                matrix[i][0]=0;
            }
        }

    }
}
