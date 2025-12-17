
class NumOfIslands {

    public static int numIslands(char grid[][]){
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char grid[][], int i, int j){

        if(i < 0 || j < 0 || 
            i >= grid.length || j >= grid[0].length || 
            grid[i][j] == '0'){
                return;
        }

        grid[i][j] = '0';  // marked as visited

        dfs(grid, i-1, j); // top
        dfs(grid, i+1, j); // bottom
        dfs(grid, i, j-1); // left
        dfs(grid, i, j+1); // right
    }

    public static void main(String[] args) {
        
        char grid[][] = {
            {'1','1','0','0'},
            {'1','0','0','1'},
            {'0','0','1','1'},
            {'0','0','0','0'}
        };

        int islands = numIslands(grid);
        System.out.println(islands);
    }
}