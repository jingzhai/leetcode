public class Solution {
    public int totalNQueens(int n) {
        if (n<=0) return 0;
        int[] q = new int[n];
        return solve(n, q, 0);
    }
    private int solve(int n, int[] q, int index) {
        int count=0;
        if (index==n) {
            return 1;
        }
        outer: for (int i=0;i<n;i++) {
            for (int j=0;j<index;j++) {
                if (q[j]==i || Math.abs(q[j]-i)==index-j) {
                    continue outer;
                }
            }
            q[index]=i;
            count+=solve(n, q, index+1);

        }
        return count;
    }
}
