class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        int coursesTaken = 0;

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int post = prerequisite[0];
            int prev = prerequisite[1];
            graph.get(prev).add(post);
            indegrees[post]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                coursesTaken++;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int post : graph.get(curr)) {
                indegrees[post]--;
                if (indegrees[post] == 0) {
                    coursesTaken++;
                    queue.offer(post);
                }
            }
        }
        return coursesTaken == numCourses;
    }
}