class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);

        for (int i=0; i<n; i++) {
            long spell = (long) spells[i];
            long need = (success + spell - 1) / spell;
            int idx = smallestLargerThanOrEqualToTarget(potions, 0, m-1, need);

            pairs[i] = idx == -1 ? 0 : m-idx;
        }
        return pairs;
    }

    public int smallestLargerThanOrEqualToTarget(int[] array, int l, int r, long target) {
        while(l < r) {
            int mid = l + (r - l) / 2;
            if ((long)array[mid] >= target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return array[l] >= target ? l : -1;
    }
}