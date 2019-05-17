class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 行
        int[][] row = new int[board.length][board[0].length];
        // 列
        int[][] column = new int[board.length][board[0].length];
        // 块
        int[][] block = new int[board.length][board[0].length];
        int num = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                num = board[i][j] != '.' ? board[i][j] - '0' : 0;
                if(num == 0){
                    continue;
                }
                if(row[i][num - 1] == 0){
                    row[i][num - 1] = 1;
                }else {
                    return false;
                }
                if(column[j][num - 1] == 0){
                    column[j][num - 1] = 1;
                }else {
                    return false;
                }
                if(block[i/3*3+j/3][num - 1] == 0){
                    block[i/3*3+j/3][num - 1] = 1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
