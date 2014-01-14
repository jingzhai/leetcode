public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int m=obstacleGrid.length;
        if (m==0) return 0;
        int n=obstacleGrid[0].length;
        int numpath[][] = new int[m][n];
        boolean firstRowBlocked = false;
        boolean firstColBlocked = false;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (obstacleGrid[i][j]==0) {
                    if (i==0 || j==0) {
                        numpath[i][j]=1;
                        if (i==0 && firstRowBlocked) numpath[i][j]=0;
                        if (j==0 && firstColBlocked) numpath[i][j]=0;
                    }
                    else {
                        numpath[i][j]=numpath[i-1][j]+numpath[i][j-1];
                    }
                } else {
                    numpath[i][j]=0;
                    if (i==0) firstRowBlocked=true;
                    if (j==0) firstColBlocked=true;
                }
            }
        }
        return numpath[m-1][n-1];
    }
}
