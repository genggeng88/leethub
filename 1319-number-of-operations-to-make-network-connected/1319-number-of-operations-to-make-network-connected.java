class Solution {
    public int makeConnected(int n, int[][] connections) {
        int disconnected = n, extraConnections = 0;
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
            } else {
                extraConnections++;
            }
        }
        return disconnected <= extraConnections + 1 ? disconnected - 1 : -1;
    }

    private int findParent(int p, int[] parent) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}