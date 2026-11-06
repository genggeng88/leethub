class Solution {
    public String multiply(String num1, String num2) {
        int n1 = 0, n2 = 0;

        int m = num1.length(), n = num2.length();
        int[] res = new int[m+n];
        for (int i = m-1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int prod = a * b + res[i + j + 1];

                res[i + j] += prod / 10;
                res[i + j + 1] = prod % 10;
            }
        }
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i < res.length && res[i] == 0) i++;
        while (i < res.length) sb.append(res[i++]);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}