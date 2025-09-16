class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> st = new ArrayDeque<>();
        for (int v : nums) {
            long x = v;
            st.addLast(x);
            // keep merging left while non-coprime
            while (st.size() >= 2) {
                long b = st.removeLast();    // top
                long a = st.peekLast();      // second top
                long g = gcd(a, b);
                if (g == 1) {                 // put b back; stop merging
                    st.addLast(b);
                    break;
                }
                st.removeLast();              // pop a
                long l = a / g * b;           // lcm without overflow
                st.addLast(l);
            }
        }
        // produce result (problem typically expects ints; values fit per constraints)
        List<Integer> res = new ArrayList<>(st.size());
        for (long val : st) res.add((int) val);
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}