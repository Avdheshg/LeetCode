class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 0) {
                        q.offer(new int[]{i,j});
                    } else {
                        mat[i][j] = -1;
                    }
                }
            }

            int dirs[][] = {{1,0},{-1,0}, {0,1},{0,-1}};

            int len = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                len++;
                for (int i = 0; i < size; i++) {
                    int cell[] = q.poll();
                    for (int dir[] : dirs) {
                        int r = cell[0] + dir[0];
                        int c = cell[1] + dir[1];

                        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != -1) {
                            continue;
                        }

                        mat[r][c] = len;
                        q.offer(new int[]{r,c});
                    }
                }
            }

            return mat;
    }
}