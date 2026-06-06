class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int courseTaken=0;
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                courseTaken++;
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            for(int adj:adjList.get(course)){
                indegree[adj]--;
                if(indegree[adj]==0){
                    q.add(adj);
                    courseTaken++;
                }
            }
        }
        return courseTaken==numCourses ? true : false;

    }
}
