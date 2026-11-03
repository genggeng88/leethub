class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();  // pre : posts
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];           // # of pres needed
        Queue<Integer> queue = new ArrayDeque<>();
        for (int[] prerequisite : prerequisites) {
            int post =  prerequisite[0];
            int prev = prerequisite[1];
            graph.get(prev).add(post);
            indegrees[post]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int post : graph.get(course)) {
                indegrees[post]--;
                if (indegrees[post] == 0) {
                    queue.offer(post);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] != 0) {
                return false;
            }
        }
        return true;
    }
}