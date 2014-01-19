public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] d = new int[word1.length()+1][word2.length()+1];
        for (int i=0;i<=word1.length();i++) {
            for (int j=0;j<=word2.length();j++) {
                if (i==0 || j==0) {
                    d[i][j]=(i==0)?j:i;
                } else {
                    if (word1.charAt(i-1)==word2.charAt(j-1)) {
                        d[i][j]=d[i-1][j-1];
                    } else {
                        d[i][j]=Math.min(Math.min(d[i-1][j],d[i][j-1]),d[i-1][j-1])+1;
                    }
                }
            }
        }
        return d[word1.length()][word2.length()];
    }
}
