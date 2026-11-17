class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int cnt = 0, i = 0, j = 0;
        while (i < arr.length) {
            Map<Character, Integer> subMap = new HashMap<>();
            j = i;
            while (j < arr.length) {
                if (!subMap.containsKey(arr[j])) {
                    subMap.put(arr[j], map.get(arr[j]));
                }
                subMap.put(arr[j], subMap.get(arr[j]) - 1);
                if (subMap.get(arr[j]) == 0) {
                    cnt++;
                }
                if (cnt == subMap.size()) {
                    res.add(j - i + 1);
                    cnt = 0;
                    j++;
                    break;
                }
                j++;
            }
            i = j;
        }
        return res;
    }
}