class FoodRatings {
    static class Node {
        String name;
        int rating;
        Node(String n, int r) {name = n; rating = r;}
    }

    Map<String, String> foodToCuisine = new HashMap<>();
    Map<String, Integer> foodToRating = new HashMap<>();
    Map<String, TreeSet<Node>> byCuisine = new HashMap<>();

    private static final Comparator<Node> CMP = (a, b) -> {
        if (a.rating != b.rating) return Integer.compare(b.rating, a.rating);
        return a.name.compareTo(b.name);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i<n; i++) {
            String f = foods[i], c = cuisines[i];
            int r = ratings[i];
            foodToCuisine.put(f, c);
            foodToRating.put(f, r);
            byCuisine.computeIfAbsent(c, k -> new TreeSet<>(CMP))
                     .add(new Node(f, r));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cu = foodToCuisine.get(food);
        int old = foodToRating.get(food);
        TreeSet<Node> set = byCuisine.get(cu);

        set.remove(new Node(food, old));
        set.add(new Node(food, newRating));
        foodToRating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        return byCuisine.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */