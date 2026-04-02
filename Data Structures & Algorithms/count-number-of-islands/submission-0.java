class Solution {
    char[][] grid;

    public int numIslands(char[][] grid) 
    {
        /*  
            Strategy: Count the number of times you preform DFS:
        */
        this.grid = grid;

        int count = 0;

        // y
        for (int i = 0; i < grid.length; i++)
        {
            // x
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    dfs(i, j);
                    
                }

            }
        }

        return count;


        
    }

    boolean is_safe(int y, int x)
    {
        return ( 
            ( y < grid.length) && ( y >= 0 ) &&
            (x < grid[0].length) && ( x >= 0) 
                );
    }

    void dfs(int y, int x)
    {
        if (!is_safe(y, x) || grid[y][x] != '1')
        {
            return;
        }

        this.grid[y][x] = '0';
        dfs(y - 1, x);
        dfs(y, x + 1);
        dfs(y + 1, x);
        dfs(y, x - 1);
     
    }
}
