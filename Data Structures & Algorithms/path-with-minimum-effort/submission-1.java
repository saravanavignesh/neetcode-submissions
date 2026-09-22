class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        effort[0][0] = 0;
        pq.offer(new int[]{0,0,0});

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        while(!pq.isEmpty()){
            int[] state = pq.poll();
            int currEffort = state[0];
            int row = state[1];
            int col = state[2];

            if (currEffort > effort[row][col]) {
                continue;
            }

            if (row == rows - 1 && col == cols - 1) {
                return currEffort;
            }
            for(int i=0;i<4;i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                if (nextRow < 0 || nextRow >= rows ||
                    nextCol < 0 || nextCol >= cols) {
                    continue;
                }
                int edgeEffort = Math.abs(
                    heights[row][col] - heights[nextRow][nextCol]
                );
                int candidate = Math.max(currEffort, edgeEffort);
                if (candidate < effort[nextRow][nextCol]) {
                    effort[nextRow][nextCol] = candidate;
                    pq.offer(new int[] {candidate, nextRow, nextCol});
                }

            }
        }
        return 0;
    }
}