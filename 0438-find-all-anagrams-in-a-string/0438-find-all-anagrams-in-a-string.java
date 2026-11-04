class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        char[] chars = new char[26];
        for (char ch : p.toCharArray()) {
            chars[ch - 'a']++;
        }
        String keyWant = String.valueOf(chars);

        char[] sub = new char[26];
        int i = 0, j = 0;
        while (j < s.length()) {
            if (j <= p.length() - 1) {
                sub[s.charAt(j) - 'a']++;
                j++;
            }
            else {
                sub[s.charAt(i) - 'a']--; i++; 
                sub[s.charAt(j) - 'a']++; j++; 
            }
            if (j > p.length() - 1) {
                String keyHave = String.valueOf(sub);
                if (keyWant.equals(keyHave)) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}

// char[] chars = new char[26];
// int i = 0, j = 0;
// if (j <= p.length() - 1)
//     construct char[] sub = new char[26] [0, j] j = p.length() - 1;
// if (j > p.length() - 1) {
//     i++, sub[s[i] - 'a']--;
//     j++; sub[s[j] - 'a']++;
// }
// if (j >= p.length() - 1)
//     if key == chars, add i