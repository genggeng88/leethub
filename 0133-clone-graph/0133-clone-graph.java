/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        // map.put(node, new Node(node.val));
        dfs(node, map);
        return map.get(node);
    }

    private void dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return;
        }
        map.put(node, new Node(node.val));
        List<Node> copyNeis = new ArrayList<>();
        for (Node nei : node.neighbors) {
            dfs(nei, map);
            copyNeis.add(map.get(nei));
        }
        map.get(node).neighbors = copyNeis;
    }
}