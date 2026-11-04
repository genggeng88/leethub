class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int cand = 0;
        for (int pile : piles) {
            cand = Math.max(cand, pile);
        }
        if (piles.length == h) return cand;
        
        int l = 1, r = cand;     // l, r, m are eating speed
        while (l < r) {
            int m = l + (r - l)/2;
            // can finish in h hours, try lower speed
            if (valid(piles, h, m)) {
                r = m;
            }
            // can't finish in h hours, need to speed up
            else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean valid(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                hours += pile / k;
            }
            else {
                hours += pile / k + 1;
            }
        }
        if (hours <= h) return true;
        return false;
    }
}

// k = max(piles);
// decrement k => sum(ceil(pile / k)) <= h => update res = k

// nlogn + n*k

// dp[i][h] koko can eat all piles with i speed in h hours?