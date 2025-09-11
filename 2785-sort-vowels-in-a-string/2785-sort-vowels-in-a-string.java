class Solution {
    private Set<Character> vowels = new HashSet<>(
        Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

    public String sortVowels(String s) {
        List<Integer> idx = new ArrayList<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        char[] tmp = s.toCharArray();

        int n = s.length();
        for (int i=0; i<n; i++) {
            if (vowels.contains(tmp[i])) {
                idx.add(i);
                pq.offer(tmp[i]);
            }
        }
        for (int j : idx) {
            tmp[j] = pq.poll();
        }

        return new String(tmp);
    }
}