class Solution {
    private int[] rowDir = {-1, 1, 0, 0};
    private int[] colDir = {0, 0, -1, 1};

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Add all treasure chests to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            for (int k = 0; k < 4; k++) {
                int nRow = row + rowDir[k], nCol = col + colDir[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == Integer.MAX_VALUE) {
                    grid[nRow][nCol] = grid[row][col] + 1;
                    q.offer(new int[]{nRow, nCol});
                }
            }
        }
    }
}