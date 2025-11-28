class Solution {
    class Pair {
        char ch;
        int cnt;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) {
            return s;
        }
        Deque<Pair> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            if (!stack.isEmpty() && stack.peekFirst().ch == s.charAt(i)) {
                stack.peekFirst().cnt++;
            }
            else {
                stack.offerFirst(new Pair(s.charAt(i), 1));
            }
            if (stack.peekFirst().cnt == k) {
                stack.pollFirst();
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair tmp = stack.pollLast();
            for (int j=0; j<tmp.cnt; j++) {
                sb.append(tmp.ch);
            }
        }
        return sb.toString();
    }
}