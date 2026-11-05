class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) return 0;
        if (position.length == 1) return 1;
        int n = position.length;
        
        int[] cp = new int[n], cs = new int[n];
        sort(0, n - 1, position, speed, cp, cs);
        
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) (target - position[i]) / speed[i];
        }

        int i = 0, j = 1, cnt = 1;
        while (j < position.length) {
            if (times[j] <= times[i]) {
                j++;
            }
            else {
                i = j;
                j++;
                cnt++;
            }
        }
        return cnt;
    }

    private void sort(int l, int r, int[] position, int[] speed, int[] cp, int[] cs) {
        if (l >= r) return;
        int m = l + (r - l)/2;
        sort(l, m, position, speed, cp, cs);
        sort(m+1, r, position, speed, cp, cs);
        merge(l, m, r, position, speed, cp, cs);
    }

    private void merge(int l, int m, int r, int[] position, int[] speed, int[] cp, int[] cs) {
        for (int i = l; i <=r; i++) {
            cp[i] = position[i];
            cs[i] = speed[i];
        }
        int f = l, s = m+1, k = l;
        while (f <= m && s <= r) {
            if (cp[f] > cp[s]) {
                position[k] = cp[f];
                speed[k++] = cs[f++];
            }
            else {
                position[k] = cp[s];
                speed[k++] = cs[s++];
            }
        }
        while (f <= m) {
            position[k] = cp[f];
            speed[k++] = cs[f++];
        }
    }
}