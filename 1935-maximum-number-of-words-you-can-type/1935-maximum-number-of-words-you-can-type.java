class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        int cnt = 0;

        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }

        String[] words = text.split(" ");
        for (String word : words) {
            if (containsBroken(word, broken)) continue;
            cnt++;
        } 
        return cnt;
    }

    private boolean containsBroken(String word, Set<Character> broken) {
        for (char ch : word.toCharArray()) {
            if (broken.contains(ch)) return true;
        }
        return false;
    }
}