class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = arr.length - 1;
        while (l < r-1) {
            int m = l + (r - l) / 2;
            if (arr[m] <= x) l = m;
            else r = m;
        }
        while (k > 0 && l >= 0 && r < arr.length) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                res.add(arr[l--]);
            }
            else {
                res.add(arr[r++]);
            }
            k--;
        }
        while (k > 0 && l >= 0) {
            res.add(arr[l--]);
            k--;
        }
        while (k > 0 && r < arr.length) {
            res.add(arr[r++]);
            k--;
        }
        Collections.sort(res);
        return res;
    }
}