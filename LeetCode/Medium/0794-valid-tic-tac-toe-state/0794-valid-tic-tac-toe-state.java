class Solution {

    public char[][] makeArray(String[] board) {
        char[][] moves=new char[3][3];
        int row=0;
        for(String move : board) {
            int col=0;
            for(char ch : move.toCharArray()) {
                moves[row][col++]=ch;
            }
            row++;
        }
        return moves;
    }

    public boolean isWinPossible(char[][] b, char ch) {
        if(b[0][0]==ch && b[0][1]==ch && b[0][2]==ch) {
            return true;
        }
        if(b[1][0]==ch && b[1][1]==ch && b[1][2]==ch) {
            return true;
        }
        if(b[2][0]==ch && b[2][1]==ch && b[2][2]==ch) {
            return true;
        }
        if(b[0][0]==ch && b[1][0]==ch && b[2][0]==ch) {
            return true;
        }
        if(b[0][1]==ch && b[1][1]==ch && b[2][1]==ch) {
            return true;
        }
        if(b[0][2]==ch && b[1][2]==ch && b[2][2]==ch) {
            return true;
        }
        if(b[0][0]==ch && b[1][1]==ch && b[2][2]==ch) {
            return true;
        }
        if(b[0][2]==ch && b[1][1]==ch && b[2][0]==ch) {
            return true;
        }
        return false;
    }

    public boolean validTicTacToe(String[] board) {
        int countX=0, countO=0;
        for(String move : board) {
            for(char ch : move.toCharArray()) {
                if(ch=='X') {
                    countX++;
                }
                else if(ch=='O') {
                    countO++;
                }
            }
        }
        char[][] moves=makeArray(board);
        boolean xWin=isWinPossible(moves, 'X');
        boolean oWin=isWinPossible(moves, 'O');
        System.out.println(xWin+" "+oWin);
        if(xWin && oWin) {
            return false;
        }
        if(countX-countO>=2) {
            return false;
        }
        if(countO>countX) {
            return false;
        }
        if(xWin && countO>=countX) {
            return false;
        }
        if(oWin && countO<countX) {
            return false;
        }

        return true;
    }
}