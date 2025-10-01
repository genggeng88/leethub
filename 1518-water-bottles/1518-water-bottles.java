class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int exchange = empty / numExchange;
            int res = empty % numExchange;
            drink += exchange;
            empty = exchange + res;
        }

        return drink;
    }
}