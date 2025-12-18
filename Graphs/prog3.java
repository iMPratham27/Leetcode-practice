import java.util.*;

class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int dimensions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            time++;

            for(int i=0; i<size; i++){
                int curr[] = q.poll();
                
                for(int d[]: dimensions){
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];

                    if(ni >= 0 && nj >= 0 && 
                        ni < grid.length && nj < grid[0].length && 
                        grid[ni][nj] == 1){
                            grid[ni][nj] = 2;
                            fresh--;
                            q.add(new int[]{ni, nj});
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        
        int grid[][] = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int time = orangesRotting(grid);
        System.out.println(time);
    }
}
