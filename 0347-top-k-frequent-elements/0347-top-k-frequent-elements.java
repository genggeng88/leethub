class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(map.get(a), map.get(b));
            }
        });

        for (int key : map.keySet()) {
            if (minHeap.size() < k) minHeap.offer(key);
            else {
                if (map.get(key) > map.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}