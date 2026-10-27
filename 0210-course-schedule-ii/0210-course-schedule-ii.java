class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        List<Integer> tmp = new ArrayList<>();
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
            tmp.add(curr);
            for (int post : graph.get(curr)) {
                indegrees[post]--;
                if (indegrees[post] == 0) queue.offer(post);
            }
        }
        if (tmp.size() < numCourses) return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}