class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op2 = stack.pollFirst();
                int op1 = stack.pollFirst();
                int res = operate(op1, op2, token);
                stack.offerFirst(res);
            }
            else {
                stack.offerFirst(Integer.parseInt(token));
            }
        }
        return stack.pollFirst();
    }

    private int operate(int op1, int op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
            default:
                return 0;
        }
    }
}