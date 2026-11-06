class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            int replacements = getReplacements(map, i, j);
            if (replacements <= k) {
                res = Math.max(res, j - i + 1);
            }
            else {
                while (replacements > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    replacements = getReplacements(map, ++i, j);
                }
            }
            j++;
        }
        return res;
    }

    private int getReplacements(Map<Character, Integer> map, int i, int j) {
        int maxCnt = 0;
        for (int cnt : map.values()) {
            maxCnt = Math.max(maxCnt, cnt);
        }
        return j - i + 1 - maxCnt;
    }
}