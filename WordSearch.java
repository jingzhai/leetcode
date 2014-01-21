public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if (m==0) return false;
        int n=board[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (board[i][j]!=word.charAt(0)) continue;
                if (word.length()==1) return true;
                boolean visited[][] = new boolean[m][n];
                visited[i][j]=true;
                if (exist(board, word.substring(1), visited,i,j)) return true;
            }
        }
        return false;
    }
    private boolean exist(char[][] board, String word, boolean[][] visited, int i, int j) {
        boolean result=false;
        //i-1,j;i+1,j;i,j-1;i.j+1
        if (i>0) {
            if (!visited[i-1][j] && board[i-1][j]==word.charAt(0)) {
                visited[i-1][j]=true;
                result|=(word.length()==1)?true:exist(board,word.substring(1),visited,i-1,j);
                if (result) return true;
                visited[i-1][j]=false;
            }
        }
        if (j>0) {
            if (!visited[i][j-1] && board[i][j-1]==word.charAt(0)) {
                visited[i][j-1]=true;
                result|=(word.length()==1)?true:exist(board,word.substring(1),visited,i,j-1);
                if (result) return true;
                visited[i][j-1]=false;
            }
        }
        if (i<board.length-1) {
            if (!visited[i+1][j] && board[i+1][j]==word.charAt(0)) {
                visited[i+1][j]=true;
                result|=(word.length()==1)?true:exist(board,word.substring(1),visited,i+1,j);
                if (result) return true;
                visited[i+1][j]=false;
            }
        }
        if (j<board[0].length-1) {
            if (!visited[i][j+1] && board[i][j+1]==word.charAt(0)) {
                visited[i][j+1]=true;
                result|=(word.length()==1)?true:exist(board,word.substring(1),visited,i,j+1);
                if (result) return true;
                visited[i][j+1]=false;
            }
        }
        return false;
    }
}
