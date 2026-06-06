class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int rowLen = heights.length;
        int colLen = heights[0].length;
        int[][] dist = new int[rowLen][colLen];
        for(int[] rows: dist){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] currCell = pq.poll();
            int diff = currCell[0], row = currCell[1], col = currCell[2];
            if(row==rowLen-1 && col==colLen-1) return diff;
            if(dist[row][col]<diff) continue;

            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= rowLen || newCol >= colLen) continue;
                
                int newDiff = Math.max(diff, Math.abs(heights[row][col] - heights[newRow][newCol]));
                if(newDiff < dist[newRow][newCol]){
                    dist[newRow][newCol]=newDiff;
                    pq.offer(new int[]{newDiff,newRow,newCol});
                }
            }

        }

        return 0;

    }

}