public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board.length;j++) {
                if (board[i][j]!='.') continue;
                for (int k=1;k<=9;k++) {
                    board[i][j]=(char)(k+'0');
                    if (isValid(board, i, j)&&solve(board)) return true;
                }
                board[i][j]='.';
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int i, int j) {
        char num=board[i][j]; 
        for (int k=0;k<board.length;k++) {
            if (k!=j && board[i][k]!='.' && num==board[i][k]) return false;
        }
        for (int k=0;k<board.length;k++) {
            if (k!=i && board[k][j]!='.' && num==board[k][j]) return false;
        }
        for (int k=i-i%3;k<i-i%3+3;k++) {
            for (int l=j-j%3;l<j-j%3+3;l++) {
                if (k!=i && l!=j && board[k][l]!='.' && num==board[k][l]) return false;
            }
        }
        return true;
    }
}
