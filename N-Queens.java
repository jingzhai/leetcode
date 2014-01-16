public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        if (n<=0) return null;
        int[] q = new int[n];
        return solve(n, q, 0);
    }
    private ArrayList<String[]> solve(int n, int[] q, int index) {
        ArrayList<String[]> list = new ArrayList<String[]>();
        if (index==n) {
            list.add(new String[n]);
            return list;
        }
        outer: for (int i=0;i<n;i++) {
            for (int j=0;j<index;j++) {
                if (q[j]==i || Math.abs(q[j]-i)==index-j) {
                    continue outer;
                }
            }
            q[index]=i;
            for (String[] s : solve(n, q, index+1)) {
                s[index]="";
                for (int k=0;k<n;k++) {
                    s[index]+=(k==i)?"Q":".";
                }
                list.add(s);
            }
        }
        return list;
    }
}
