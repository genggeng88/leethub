class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
                if (!dfs(i, graph, map)) {
                    return false;
                }
            } 
        }
        return true;
    }

    private boolean dfs(int i, int[][] graph, Map<Integer, Integer> map) {
        int wantColor = 1 - map.get(i);
        
        for (int nei : graph[i]) {
            if (!map.containsKey(nei)) {
                map.put(nei, wantColor);
                if (!dfs(nei, graph, map)) return false;
            }
            if (map.get(nei) != wantColor) return false;
        }
        return true;
    }
}