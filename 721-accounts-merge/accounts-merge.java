import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(10001); // Max possible emails based on constraints
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                emailToName.put(email, name);
                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = dsu.find(emailToId.get(email));
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Format the final result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> emails : components.values()) {
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(emails.get(0)));
            account.addAll(emails);
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }
}

class DSU {
    int[] parent;
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}