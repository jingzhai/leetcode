public class Solution {
    public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int numpath[][] = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0 || j==0) numpath[i][j]=1;
                else {
                    numpath[i][j]=numpath[i-1][j]+numpath[i][j-1];
                }
            }
        }
        return numpath[m-1][n-1];
    }
}
