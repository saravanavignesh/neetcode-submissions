class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        for (int[] pre : prerequisites) adjList.get(pre[0]).add(pre[1]);
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(bfs(adjList, q[0], q[1], numCourses));
        }
        return res;
    }

    private boolean bfs(List<List<Integer>> adjList, int start, int end, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == end) return true;
            for (int next : adjList.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }
}