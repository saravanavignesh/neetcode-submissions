class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        
        // {queryValue, originalIndex}
        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        // {intervalLength, intervalEnd}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int intervalIdx = 0;

        for (int[] query : q) {
            int queryValue = query[0];
            int originalIndex = query[1];

            // Add all intervals whose start <= query
            while (intervalIdx < intervals.length &&
                   intervals[intervalIdx][0] <= queryValue) {

                int start = intervals[intervalIdx][0];
                int end = intervals[intervalIdx][1];
                int length = end - start + 1;

                pq.offer(new int[]{length, end});
                intervalIdx++;
            }

            // Remove intervals that cannot cover query
            while (!pq.isEmpty() && pq.peek()[1] < queryValue) {
                pq.poll();
            }

            ans[originalIndex] =
                    pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return ans;
    }
}