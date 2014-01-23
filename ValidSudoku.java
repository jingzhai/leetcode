public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n=board.length;
        if (n==0 || n%3!=0) return false;
        if (board[0].length!=n) return false;
        for (int i=0;i<n;i++) {
            int check=0;
            for (int j=0;j<n;j++) {
                if (board[i][j]!='.') {
                    int val = 1<<Character.getNumericValue(board[i][j]);
                    if ((check&val)!=0) return false;
                    check=check+val;
                }
            }
        }
        for (int i=0;i<n;i++) {
            int check=0;
            for (int j=0;j<n;j++) {
                if (board[j][i]!='.') {
                    int val = 1<<Character.getNumericValue(board[j][i]);
                    if ((check&val)!=0) return false;
                    check=check+val;
                }
            }
        }
        for (int i=0;i<n;i=i+3) {
            for (int j=0;j<n;j=j+3) {
                int check=0;
                for (int k=0;k<3;k++) {
                    for (int l=0;l<3;l++) {
                        if (board[i+k][j+l]!='.') {
                            int val = 1<<Character.getNumericValue(board[i+k][j+l]);
                            if ((check&val)!=0) return false;
                            check=check+val;
                        }
                    }
                }
            }
        }
        return true;
    }
}
