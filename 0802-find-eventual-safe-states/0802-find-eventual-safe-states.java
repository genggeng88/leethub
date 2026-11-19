class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] state = new int[n];
        for (int i = 0; i < n; i++ ) {
            if (dfs(i, graph, state)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int start, int[][] graph, int[] state) {
        if (state[start] == 1) return false;
        if (state[start] == 2) return true;
        
        state[start] = 1;
        for (int nei : graph[start]) {
            if (!dfs(nei, graph, state)) {
                return false;
            }
        }
        state[start] = 2;
        return true;
    }
}