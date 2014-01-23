public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length();
        int n=s2.length();
        if (m+n!=s3.length()) return false;
        boolean[] M = new boolean[n+1];
        M[n]=true;
        for (int i=n-1;i>=0;i--) {
            M[i] = s3.charAt(m+i)==s2.charAt(i) && M[i+1];
        }
        for (int i=m-1; i >=0; i--) {
            for (int j=n; j>=0; j--) {
                if (( s3.charAt(i+j) == s1.charAt(i) && M[j]) ||
                    ( j<n && s3.charAt(i+j) == s2.charAt(j) && M[j+1]))
                    M[j] = true;      
                else
                    M[j] = false;
            }
        }
        return M[0];
    }
}
