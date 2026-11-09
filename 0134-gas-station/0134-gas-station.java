class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, tank = 0, idx = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            
            total += diff;
            tank += diff;

            if (tank < 0) {
                idx = i+1;
                tank = 0;
            }
        }

        return total >= 0 ? idx : -1;
    }
}