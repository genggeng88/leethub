class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) return 0;
        if (position.length == 1) return 1;
        int n = position.length;
        
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        int i = 0, j = 1, cnt = 1;
        while (j < n) {
            if (times[j] > times[i]) {
                i = j;
                cnt++;
            }
            j++;
        }
        return cnt;
    }
}