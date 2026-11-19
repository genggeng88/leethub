class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);

            int rootU = findParent(u, parent);
            int rootV = findParent(v, parent);

            if (rootU != rootV) {
                parent[rootV] = rootU;
            }
        }

        Map<Integer, List<Character>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = findParent(i, parent);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(s.charAt(i));
        }

        for (List<Character> chars : groups.values()) {
            Collections.sort(chars);
        }

        Map<Integer, Integer> positions = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int root = findParent(i, parent);

            int pos = positions.getOrDefault(root, 0);
            sb.append(groups.get(root).get(pos));

            positions.put(root, pos + 1);
        }

        return sb.toString();
    }

    private int findParent(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}