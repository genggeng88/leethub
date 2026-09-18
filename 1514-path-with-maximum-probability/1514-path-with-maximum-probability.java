class Solution {
    class Node {
        int to;
        double prob;

        public Node(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        if (start_node == end_node) return 0;
        double[] maxProbs = new double[n];
        maxProbs[start_node] = 1.0;

        List<List<Node>> graph = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>()); 
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            double prob = succProb[i];
            graph.get(from).add(new Node(to, prob));
            graph.get(to).add(new Node(from, prob));
        }

        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                return Double.compare(b.prob, a.prob);
            }
        });
        maxHeap.offer(new Node(start_node, 1.0));

        while (!maxHeap.isEmpty()) {
            Node curr = maxHeap.poll();
            if (curr.prob < maxProbs[curr.to]) continue; // check ==

            List<Node> neis = graph.get(curr.to);
            for (Node nei : neis) {
                double newProb = curr.prob * nei.prob;
                if (newProb > maxProbs[nei.to]) {
                    maxHeap.offer(new Node(nei.to, newProb));
                    maxProbs[nei.to] = newProb;
                }
            }
        }
        return maxProbs[end_node];
    }
}