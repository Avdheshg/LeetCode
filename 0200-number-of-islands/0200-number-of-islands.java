class Solution {
    
    // // BFS ---------------------------------------------------------------------------------
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                    count++;
                    bfs(grid, q, visited);
                }
            }
        }
        return count;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void bfs(char[][] grid, Queue<int[]> q, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int dir[] : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] == true || grid[x][y] == '0') {
                    continue;
                }

                visited[x][y] = true;
                q.offer(new int[]{x,y});
            }
        }
    }
    
    
    
    // // DFS ---------------------------------------------------------------------------------
//     public int numIslands(char[][] grid) {
        
//         if(grid==null || grid.length==0) return 0;
            
//         int count = 0;
        
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[i].length; j++) {
//                 if (grid[i][j] == '1') {
//                     clearRestOfLand(grid, i, j);
//                     count++;
//                 }
//             }
//         }
        
//         return count;
//     }
    
//     public void clearRestOfLand(char[][] grid, int i, int j) {
//         if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
//             return;
//         }
        
//         // clear the current land
//         grid[i][j] = '0';
        
//         // recur for neighbours
//         clearRestOfLand(grid, i+1, j);  // right
//         clearRestOfLand(grid, i-1, j);  // left
//         clearRestOfLand(grid, i, j+1);  // top
//         clearRestOfLand(grid, i, j-1);  // bottom
//     }
}