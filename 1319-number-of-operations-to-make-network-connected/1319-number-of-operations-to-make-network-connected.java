class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int disconnected = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] conn : connections) {
            int p1 = findParent(conn[0], parent);
            int p2 = findParent(conn[1], parent);

            if (p1 != p2) {
                parent[p2] = p1;
                disconnected--;
            } 
        }
        return disconnected - 1;
    }

    private int findParent(int p, int[] parent) {
        if (p != parent[p]) {
            parent[p] = findParent(p, parent);
        }
        return parent[p];
    }
}