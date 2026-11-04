class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : map.keySet()) {
            pq.offer(map.get(ch));
        }

        // queue stores <cnt, cooldown>, when cooldown == 0, put cnt into pq
        Queue<int[]> queue = new ArrayDeque<>();
        int interval = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && interval >= queue.peek()[1]) {
                pq.offer(queue.poll()[0]);
            }
            if (!pq.isEmpty()) {
                int freq = pq.poll();
                freq--;
                if (freq > 0) {
                    queue.offer(new int[]{freq, interval + n + 1});
                }
            }
            interval++;  // add task t or idle if pq is empty
        }
        return interval;
    }
}