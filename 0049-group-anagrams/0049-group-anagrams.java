class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                List<String> tmp = new LinkedList<>();
                tmp.add(str);
                map.put(key, tmp);
            }
        }
        for (List<String> list : map.values()) {
            results.add(list);
        }
        return results;
    }
}