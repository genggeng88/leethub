class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        int[] res = new int[numCourses];
        int p = 0;

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
            indegrees[course]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[p++] = curr;
            for (int post : graph.get(curr)) {
                indegrees[post]--;
                if (indegrees[post] == 0) queue.offer(post);
            }
        }
        if (p < numCourses) return new int[0];
        return res;
    }
}