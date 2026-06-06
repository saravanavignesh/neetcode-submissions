class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] timeTaken = new int[n+1];
        Arrays.fill(timeTaken,Integer.MAX_VALUE);
        timeTaken[k]=0;

        int maxTime = Integer.MIN_VALUE;

        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int src = times[i][0], dest = times[i][1], time=times[i][2]; 
            adjList.get(src).add(new int[]{dest,time});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] currNode = pq.poll();
            int node = currNode[1], timeToReach = currNode[0];
            for(int[] nei: adjList.get(node)){
                if(timeTaken[nei[0]]< timeToReach+nei[1]) continue;

                pq.offer(new int[] {timeToReach+nei[1],nei[0]});
                
                timeTaken[nei[0]] = timeToReach+nei[1];
            }
        }

        for(int i=1;i<=n;i++){
            if(timeTaken[i]==Integer.MAX_VALUE) return -1;
            else{
                maxTime = Math.max(maxTime, timeTaken[i]);
            }
        }
        return maxTime;
    }
}
