class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0, matchNeeded = map.size();
        String cand = "";
        while (j < s.length()) {
            char curr = s.charAt(j);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    matchNeeded--;
                }
            }
            while (matchNeeded == 0) {
                if (cand == "" || j - i + 1 < cand.length()) {
                    cand = s.substring(i, j+1);
                }
                char remove = s.charAt(i);
                if (map.containsKey(remove)) {
                    map.put(remove, map.get(remove) + 1);
                    if (map.get(remove) == 1) {
                        matchNeeded++;
                    }
                }
                i++;
            }
            j++;
        }
        return cand;
    }
}

// "ADOBECODEBANC"
//           i
//              j
// "ABC"