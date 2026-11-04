class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int matchNeeded = map.size();
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    matchNeeded--;
                }
            }
            if (i > p.length() - 1) {
                char remove = s.charAt(i - p.length());
                if (map.containsKey(remove)) {
                    map.put(remove, map.get(remove) + 1);
                    if (map.get(remove) == 1) {
                        matchNeeded++;
                    }
                }
            }
            if (matchNeeded == 0) {
                res.add(i - p.length() + 1);
            }
            i++;
        }
        return res;
    }
}
