class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = n;
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int pi = findParent(i, parent);
                    int pj = findParent(j, parent);

                    if (pi != pj) {
                        parent[pj] = pi;
                        provinces--;
                    }
                }
            }
        }

        return provinces;
    }

    private int findParent(int p, int[] parent) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}