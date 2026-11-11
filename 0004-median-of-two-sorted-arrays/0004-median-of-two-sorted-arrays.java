class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n, idx = 0;
        int[] nums = new int[total];
        int[] buffer = new int[total];

        for (int num : nums1) nums[idx++] = num;
        for (int num : nums2) nums[idx++] = num;

        mergeSort(0, total - 1, nums, buffer);
        if (total % 2 != 0) {
            return (double) nums[total/2];
        } else {
            return ((double) nums[total/2 - 1] + nums[total/2]) / 2;
        }
    }

    private void mergeSort(int l, int r, int[] nums, int[] buffer) {
        if (l >= r) return;
        int m = l + (r - l)/2;
        mergeSort(l, m, nums, buffer);
        mergeSort(m+1, r, nums, buffer);
        merge(l, m, r, nums, buffer);
    }

    private void merge(int l, int m, int r, int[] nums, int[] buffer) {
        for (int i = l; i <= r; i++) {
            buffer[i] = nums[i];
        }
        int k = l, p = m+1;
        while (l <= m && p <= r) {
            if (buffer[l] <= buffer[p]) {
                nums[k++] = buffer[l++];
            }
            else {
                nums[k++] = buffer[p++];
            }
        }
        while (l <= m) nums[k++] = buffer[l++];
    }
}