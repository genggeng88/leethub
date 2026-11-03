class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) return res;
        if (strs.length == 1) {
            res.add(Arrays.asList(strs));
            return res;
        }

        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (char ch : str.toCharArray()) {
                arr[ch - 'a']++;
            }
            List<Integer> key = new ArrayList<>();
            for (int num : arr) {
                key.add(num);
            }
            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(str);
        }
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}