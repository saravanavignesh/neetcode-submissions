class Solution {
    private int[] row = {-1,1,0,0};
    private int[] col = {0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int minutes = -1;
        int freshFruits=0;
        int rottenFruits=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    rottenFruits++;
                }else if(grid[i][j]==1){
                    freshFruits++;
                }
            }
        }

        while(!q.isEmpty()){
            minutes++;
            int size = q.size();
            for(int s=0; s<size;s++){
                int[] pos = q.poll();
                for(int i=0;i<4;i++){
                    int rowDir = pos[0] + row[i];
                    int colDir = pos[1] + col[i];
                    if(rowDir<0 || rowDir>=grid.length || colDir<0 || colDir>=grid[0].length || grid[rowDir][colDir]==0 || grid[rowDir][colDir]==2){
                        continue;
                    }
                    q.add(new int[]{rowDir,colDir});
                    freshFruits--;
                    grid[rowDir][colDir]=2;
                }
            }
        }
        if (freshFruits > 0) return -1;
        return minutes == -1 ? 0 : minutes; 
    }

}
