class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int drink = numBottles;

        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange;
            numExchange++;
            emptyBottles += 1;
            drink++;
        }

        return drink;
    }
}