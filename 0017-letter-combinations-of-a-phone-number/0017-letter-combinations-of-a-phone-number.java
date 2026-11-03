class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(0, digits, res, new StringBuilder());
        return res;
    }

    private void dfs(int idx, String digits, List<String> res, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String nums = getNums(digits.charAt(idx));
        if (nums.length() == 0) {
            dfs(idx+1, digits, res, sb);
        }
        else {
            for (char ch : nums.toCharArray()) {
                sb.append(ch);
                dfs(idx+1, digits, res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private String getNums(char ch) {
        switch (ch) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}