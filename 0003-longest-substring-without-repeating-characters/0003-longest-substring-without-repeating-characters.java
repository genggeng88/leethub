class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, globalMax = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            j++;
            globalMax = Math.max(globalMax, j - i);
        }
        return globalMax;
    }
}