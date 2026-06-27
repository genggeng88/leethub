class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        if (t == null || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cntNeeded = map.size(), i = 0, j = 0;
        String res = "";

        while (j < s.length()) {
            if (cntNeeded > 0) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        cntNeeded--;
                    }
                }
                j++;
            }
            else if (cntNeeded == 0) {
                if (res == "" || j - i < res.length()) {
                    res = s.substring(i, j);
                }
                char c2 = s.charAt(i);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) == 1) {
                        cntNeeded++;
                    }
                }
                i++;
            }
        }

        while (i < s.length() && cntNeeded == 0) {
            if (res == "" || j - i < res.length()) {
                res = s.substring(i, j);
            }
            char c2 = s.charAt(i);
            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2) + 1);
                if (map.get(c2) == 1) {
                    cntNeeded++;
                }
            }
            i++;
        }
        return res;
    }
}

//     0 1 2 3 4 5 6 7 8 9 10 11 12
// s = A D O B E C O D E B A  N  C    res => sihh substring(4, 8)
//                 i
//                                 j         
                
// t = A B C           
// map: {A, 0>, <B, 0>, <C, 0>}
// needed:0                        res = substring(0, 6) => ADOBED










