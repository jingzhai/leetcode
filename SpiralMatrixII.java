public class Solution {
    public int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        int minrow=0;
        int mincol=0;
        int maxrow=n-1;
        int maxcol=n-1;
        int[][] matrix = new int[n][n];
        int count=1;
        int size=n*n;
        
        while(count<=size) {
            for (int i=mincol;i<=maxcol;i++) {
                matrix[minrow][i]=count;
                count++;
            }
            minrow++;
            if (count>size) break;
            for (int i=minrow;i<=maxrow;i++) {
                matrix[i][maxcol]=count;
                count++;
            }
            maxcol--;
            if (count>size) break;
            for (int i=maxcol;i>=mincol;i--) {
                matrix[maxrow][i]=count;
                count++;
            }
            maxrow--;
            if (count>size) break;
            for (int i=maxrow;i>=minrow;i--) {
                matrix[i][mincol]=count;
                count++;
            }
            mincol++;
        }
        return matrix;

    }
}
