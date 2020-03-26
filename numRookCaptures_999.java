/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。

车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、
到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。

返回车能够在一次移动中捕获到的卒的数量。
 */


//考察coding
class numRookCaptures_999 {
    public int numRookCaptures(char[][] board) {
        int num = 0;
        int[][] f = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R' || board[i][j] == 'r') {
                    int saveI = i, saveJ = j;
                    for (int m = 0; m < f.length; m++) {
                        i = saveI;
                        j = saveJ;
                        int newI = i + f[m][0], newJ = j + f[m][1];
                        while (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                            if (board[newI][newJ] == '.') {
                                newI += f[m][0];
                                newJ += f[m][1];
                                continue;
                            }
                            else if ((board[saveI][saveJ] == 'R' && board[newI][newJ] == 'p')
                                    || (board[saveI][saveJ] == 'r' && board[newI][newJ] == 'P')) {
                                    num++;
                                    break;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    break;
                } 
            }
        }
        return num;
    }
}