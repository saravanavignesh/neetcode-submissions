class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int[] lastInterval = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(lastInterval[1]<intervals[i][0]){
                result.add(lastInterval);
                lastInterval = intervals[i];
            }else if(intervals[i][1]<lastInterval[0]){
                result.add(intervals[i]);
            }else{
                lastInterval[0] = Math.min(lastInterval[0],intervals[i][0]);
                lastInterval[1] = Math.max(lastInterval[1],intervals[i][1]);
            }
        }
        result.add(lastInterval);
        return result.toArray(new int[result.size()][]);
    }
}
