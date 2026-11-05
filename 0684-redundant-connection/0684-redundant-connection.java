class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n+1];

            // check if u and v already connected
            if (dfs(u, v, graph, visited)) {
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return edges[0];
    }

    private boolean dfs(int node, int target, List<List<Integer>> graph, boolean[] visited) {
        if (node == target) return true;

        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, target, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}