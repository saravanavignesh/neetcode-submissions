class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adjList.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int courseTaken = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int course = q.poll();
            courseTaken++;
            for (int next : adjList.get(course)) {
                if (--indegree[next] == 0) q.offer(next);
            }
        }
        return courseTaken == numCourses;
    }
}