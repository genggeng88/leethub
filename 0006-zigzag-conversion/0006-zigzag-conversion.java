class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        int i=0, j=0, n=s.length();
        boolean reverse = false;
        String res = "";
        

        for (int k = 0; k < numRows; k++) {
            sbs[k] = new StringBuilder();
        }

        if (numRows == 1) return s;

        while (i < n) {
            char c = s.charAt(i);
            if (reverse) {
                sbs[numRows - 1 - j].append(c);
            } else {
                sbs[j].append(c);
            }
            j++;
            if (j == numRows) {
                j = 1;
                reverse = !reverse;
            }
            i++;
        }

        for (StringBuilder sb : sbs) {
            if (!sb.isEmpty()) {
                res += sb.toString();
            }
        }

        return res;
    }
}