class Solution {
    public int maxFreqSum(String s) {
        int[] times = new int[26];
        int maxVowel = 0, maxConsonant = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (char c : s.toCharArray()) {
            times[c - 'a']++;
            if (vowels.contains(c)) {
                if (times[c - 'a'] > maxVowel) {
                    maxVowel = times[c - 'a'];
                }
            }
            else {
                if (times[c - 'a'] > maxConsonant) {
                    maxConsonant = times[c - 'a'];
                }
            }
        }

        return maxVowel + maxConsonant;
    }
}