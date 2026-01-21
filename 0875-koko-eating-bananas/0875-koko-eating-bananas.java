class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int p : piles) {
            r = Math.max(p, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canFinish(piles, mid, h)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int cnt = 0;
        for (int p : piles) {
            cnt += (p + k - 1) / k;
        }
        return cnt <= h;
    }
}