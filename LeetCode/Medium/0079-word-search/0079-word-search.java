class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                boolean visited[][]=new boolean[board.length][board[0].length];
                if(isValid(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if(index==word.length()) {
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return false;
        }
        if(visited[i][j] || word.charAt(index)!=board[i][j]) {
            return false;
        }
        visited[i][j]=true;
        if(
        isValid(board, word, visited, i+1, j, index+1) ||
        isValid(board, word, visited, i-1, j, index+1) ||
        isValid(board, word, visited, i, j+1, index+1) ||
        isValid(board, word, visited, i, j-1, index+1)) 
        {
            return true;
        }
        visited[i][j]=false;
        return false;
    }
}