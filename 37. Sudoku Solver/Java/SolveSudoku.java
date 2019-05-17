class Solution {
    public void solveSudoku(char[][] board) {
        // 行
        boolean[][] row = new boolean[9][10];
        // 列
        boolean[][] column = new boolean[9][10];
        // 块
        boolean[][] block = new boolean[9][10];
        int num = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                num = board[i][j] != '.' ? board[i][j] - '0' : 0;
                if(num == 0){
                    continue;
                }
                row[i][num] = true;
                column[j][num] = true;
                block[i/3*3+j/3][num] = true;
            }
        }
        dfs(row, column, block, board, 0, 0);
        StringBuilder sb;
        for(int i = 0;i < board.length;i++){
            sb = new StringBuilder();
            for(int j = 0;j < board[i].length;j++){
                sb.append(board[i][j]).append(",");
            }
            System.out.println(sb.toString());
        }
    }

    private boolean dfs(boolean[][] row, boolean[][] column, boolean[][] block, char[][] board, int rowNum, int columNum){
        while (board[rowNum][columNum] != '.'){
            if(columNum != 8){
                columNum++;
                continue;
            }else if(rowNum != 8){
                rowNum++;
                columNum = 0;
                continue;
            }
            return true;
        }
        int blockIndex = rowNum/3*3+columNum/3;
        for(int num = 1;num <= 9;num++){
            if(!row[rowNum][num] && !column[columNum][num] && !block[blockIndex][num]){
                row[rowNum][num] = true;
                column[columNum][num] = true;
                block[blockIndex][num] = true;
                board[rowNum][columNum] = (char)(num + '0');
                if(dfs(row, column, block, board, rowNum, columNum)){
                    return true;
                }else{
                    row[rowNum][num] = false;
                    column[columNum][num] = false;
                    block[blockIndex][num] = false;
                    board[rowNum][columNum] = '.';
                }
            }
        }
        return false;
    }
}
