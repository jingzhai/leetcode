// 3 dimensional dynamic programming: f(i, j, n) = || ((f(i, j, m) && f(i + m, j + m, n - m)) || f(i, j + n - m, m) && f(i + m, j, n - m)) for 1 < m < n where f(i, j, n) is true iff substring starts at s1[i] and substring starts at s2[j] both with length n are scrambled

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        boolean[][][] scrambled = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++){
                scrambled[i][j][0] = true; 
                scrambled[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
    
        for(int i = s1.length() - 1; i >= 0 ; i--)
            for(int j = s2.length() - 1; j >= 0; j--)
                for(int n = 2; n <= Math.min(s1.length() - i, s2.length() - j); n ++)
                    for(int m = 1; m < n; m++){
                        scrambled[i][j][n] |= scrambled[i][j][m] && scrambled[i + m][j + m][n - m] ||
                                scrambled[i][j + n - m][m] && scrambled[i + m][j][n - m];
                        if(scrambled[i][j][n])  break;
                    }
        return scrambled[0][0][s1.length()]; 
    }
}
