class Solution {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                if (!adjacent.containsKey(firstEmail)) {
                    adjacent.put(firstEmail, new ArrayList<>());
                }
                adjacent.get(firstEmail).add(email);
                if (!adjacent.containsKey(email)) {
                    adjacent.put(email, new ArrayList<>());
                }
                adjacent.get(email).add(firstEmail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            if (!visited.contains(firstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(name);

                dfs(mergedAccount, firstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }

    private void dfs(List<String> mergedAccount, String email) {
        mergedAccount.add(email);
        visited.add(email);
        if (!adjacent.containsKey(email)) return;

        for (String nei : adjacent.get(email)) {
            if (!visited.contains(nei)) {
                dfs(mergedAccount, nei);
            }
        }
    }
}