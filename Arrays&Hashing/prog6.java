class ValidSudoku {

    private static boolean isValidSudoku(char board[][]){

        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean boxes[][] = new boolean[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                char c = board[i][j];
                if(c == '.') continue;

                int num = c - '1';

                // row check
                if(row[i][num]) return false;
                row[i][num] = true;

                // col check
                if(col[j][num]) return false;
                col[j][num] = true;

                // boxes check
                int boxIdx = (i/3)*3 + (j/3);
                if(boxes[boxIdx][num]) return false;
                boxes[boxIdx][num] = true;

            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        }; 
        
        boolean ans = isValidSudoku(board);
        System.out.println(ans);
        
    }
}
