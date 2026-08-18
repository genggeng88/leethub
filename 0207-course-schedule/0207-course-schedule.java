class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCourses = new int[numCourses];   // cnt of preCourses 
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            int pre = prereq[0];
            int needPre = prereq[1];
            graph.get(pre).add(needPre);
            preCourses[needPre]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preCourses[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            for (int needCurrCourse : graph.get(currCourse)) {
                preCourses[needCurrCourse]--;
                if (preCourses[needCurrCourse] == 0) {
                    queue.offer(needCurrCourse);
                }
            }
        }

        for (int num : preCourses) {
            if (num > 0) return false;
        }
        return true;
    }
}