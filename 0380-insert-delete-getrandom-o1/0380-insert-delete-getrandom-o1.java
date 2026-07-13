class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        nums.add(val);
        map.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int last = map.size() - 1, idx = map.get(val);
        int lastVal = nums.get(last);
        nums.set(idx, lastVal);
        map.put(lastVal, idx);
        nums.remove(last);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int r = (int) (Math.random() * map.size());
        return nums.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */