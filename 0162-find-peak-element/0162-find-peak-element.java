class Solution {
    public int findPeakElement(int[] arr) {
        if (arr == null || arr.length == 0)  return -1;
        if (arr.length == 1) return 0;
        int n = arr.length;

        int i = 0, j = n-1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > arr[mid+1]) j = mid;
            else i = mid+1;
        }
        // if (i > 0 && arr[i] > arr[i-1] && i < n-1 && arr[i] > arr[i+1]) return i;
        return i;
    }
}