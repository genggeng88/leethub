class Solution {
    class Task {
        char ch;
        int cnt;
        int cooldown;

        public Task(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
            this.cooldown = 0;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t2.cnt, t1.cnt);
            }
        });

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : map.keySet()) {
            pq.offer(new Task(ch, map.get(ch)));
        }

        Queue<Task> queue = new ArrayDeque<>();
        int interval = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && interval >= queue.peek().cooldown) {
                pq.offer(queue.poll());
            }
            if (!pq.isEmpty()) {
                Task t = pq.poll();
                t.cnt--;
                if (t.cnt > 0) {
                    t.cooldown = interval + n + 1;
                    queue.offer(t);
                }
            }
            interval++;  // add task t or idle if pq is empty
        }
        return interval;
    }
}