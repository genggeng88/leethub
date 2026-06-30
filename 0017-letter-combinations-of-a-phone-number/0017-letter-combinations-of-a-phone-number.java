class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(res, digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, String digits, int idx, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = getString(digits.charAt(idx) - '0');
        if (str.equals("")) dfs(res, digits, idx+1, sb);
        else {
            for (char ch : str.toCharArray()) {
                sb.append(ch);
                dfs(res, digits, idx+1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private String getString(int digit) {
        switch (digit) {
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
            default: return "";
        }
    }
}