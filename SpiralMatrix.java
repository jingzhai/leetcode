public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m=matrix.length;
        if (m==0) return list;
        int n=matrix[0].length;
        
        int u=0;
        int l=0;
        int d=m-1;
        int r=n-1;
        
        while(list.size()<m*n) {
            for (int i=l;i<=r;i++) {
                list.add(matrix[u][i]);
            }
            u++;
            if (list.size()>=m*n) break;
            for (int i=u;i<=d;i++) {
                list.add(matrix[i][r]);
            }
            r--;
            if (list.size()>=m*n) break;
            for (int i=r;i>=l;i--) {
                list.add(matrix[d][i]);
            }
            d--;
            if (list.size()>=m*n) break;
            for (int i=d;i>=u;i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }
}
