import java.util.Locale;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> lowerToWord = new HashMap<>();
        Map<String, String> devowelToWord = new HashMap<>();

        for (String w : wordlist) {
            exact.add(w);
            String lo = w.toLowerCase(Locale.ROOT);
            lowerToWord.putIfAbsent(lo, w);
            devowelToWord.putIfAbsent(devowel(lo), w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            // 1) exact
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }

            String lo = q.toLowerCase(Locale.ROOT);

            // 2) case-insensitive
            String cand = lowerToWord.get(lo);
            if (cand != null) {
                ans[i] = cand;
                continue;
            }

            // 3) vowel-error
            cand = devowelToWord.get(devowel(lo));
            ans[i] = cand == null ? "" : cand;
        }

        return ans;
    }

    private static String devowel(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(isVowel(c) ? '*' : c);
        }
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}