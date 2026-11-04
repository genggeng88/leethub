class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxFreq = 0, cnt = 0;
        for (Integer freq : map.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
                cnt = 1;
            }
            else if (freq == maxFreq) {
                cnt++;
            }
        }

        int res = Math.max(tasks.length, (maxFreq - 1) * (n + 1) + cnt);
        return res;
    }
}