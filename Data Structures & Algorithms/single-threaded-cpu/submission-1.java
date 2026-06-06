class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = tasks[i][0]; // enqueueTime
            sorted[i][1] = tasks[i][1]; // processingTime
            sorted[i][2] = i;           // original index
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]
        );

        int time = sorted[0][0], idx = 0, resIdx = 0;
        int[] result = new int[n];
        while (resIdx < n) {
            while (idx < n && sorted[idx][0] <= time) {
                pq.offer(sorted[idx]);
                idx++;
            }
            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                time += curr[1];
                result[resIdx++] = curr[2];
            }else{
                 time = sorted[idx][0];
            }
        }
        return result;
    }
}