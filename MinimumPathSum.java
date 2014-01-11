public class Solution {
    public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        int[][] sgrid = new int[m][n];
        sgrid[0][0]=grid[0][0];
        for (int i=1;i<m;i++) {
            sgrid[i][0]=sgrid[i-1][0]+grid[i][0];
        }
        for (int j=1;j<n;j++) {
            sgrid[0][j]=sgrid[0][j-1]+grid[0][j];
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                sgrid[i][j]=Math.min(sgrid[i-1][j],sgrid[i][j-1])+grid[i][j];
            }
        }
        return sgrid[m-1][n-1];
        
    }
}
