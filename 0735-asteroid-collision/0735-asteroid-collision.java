class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return new int[0];
        List<Integer> tmp = new ArrayList<>();

        int left = asteroids[0], j = 1;
        tmp.add(asteroids[0]);
        while (j < asteroids.length) {
            if (tmp.size() > 0 && left > 0 && asteroids[j] < 0) {
                if (left > Math.abs(asteroids[j])) {    // j explode, j++;
                    j++;
                }
                else if (left == Math.abs(asteroids[j])) { // both explode
                    tmp.remove(tmp.size() - 1);
                    if (tmp.size() > 0) left = tmp.get(tmp.size() - 1); 
                    j++;
                }
                else {       // explode left
                    tmp.remove(tmp.size() - 1);
                    if (tmp.size() > 0) left = tmp.get(tmp.size() - 1); 
                }
            }
            else {
                left = asteroids[j];
                j++;
                tmp.add(left);
            }
        }

        int[] res = new int[tmp.size()];
        for (int k = 0; k < tmp.size(); k++) {
            res[k] = tmp.get(k);
        }
        return res;
    }
}