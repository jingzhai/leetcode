public class Solution {
    public int numDistinct(String S, String T) {
        if (S.length()<T.length()) return 0;
        int[][] match = new int[T.length()+1][S.length()+1];
        for (int i=0;i<=T.length();i++) {
            for (int j=0;j<=S.length();j++) {
                if (i==0) match[i][j]=1;
                else match[i][j]=0;
            }
        }
        for (int i=1;i<=T.length();i++) {
            for (int j=1;j<=S.length();j++) {
                match[i][j]=match[i][j-1];
                if (T.charAt(i-1)==S.charAt(j-1)) {
                    match[i][j]+=match[i-1][j-1];
                }
            }
        }
        return match[T.length()][S.length()];
    }
}
