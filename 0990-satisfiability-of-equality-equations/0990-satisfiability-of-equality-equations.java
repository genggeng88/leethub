class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int u = equation.charAt(0) - 'a';
                int v = equation.charAt(3) - 'a';
                int rootU = findParent(u, parent);
                int rootV = findParent(v, parent);
                if (rootU != rootV) parent[rootV] = rootU;
            }
            
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int u = equation.charAt(0) - 'a';
                int v = equation.charAt(3) - 'a';
                int rootU = findParent(u, parent);
                int rootV = findParent(v, parent);
                if (rootU == rootV) return false;
            }
            
        }
        return true;
    }

    private int findParent(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}