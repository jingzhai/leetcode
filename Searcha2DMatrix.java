public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (matrix.length==0) return false;
        
        for (int i=0,j=matrix[0].length-1;i<matrix.length&&j>=0;) {
            if (matrix[i][j]==target) return true;
            if (matrix[i][j]>target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}

