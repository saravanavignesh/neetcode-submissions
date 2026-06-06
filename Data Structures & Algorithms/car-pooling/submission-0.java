
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int n = trips.length;
        int i = 0;
        while (i < n) {
            int start = trips[i][1];
            int end = trips[i][2];
            int passengers = trips[i][0];
            int j = i + 1;
            // Merge all overlapping trips
            while (j < n && trips[j][1] < end) {
                if (trips[j][1] < end) {
                    end = Math.max(end, trips[j][2]);
                    passengers += trips[j][0];
                }
                j++;
            }
            if (passengers > capacity) return false;
            i = j;
        }
        return true;
    }
}