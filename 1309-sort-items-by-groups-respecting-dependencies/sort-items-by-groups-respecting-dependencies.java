import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Step 1: Give each -1 group a unique group ID
        int groupCount = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupCount++;
            }
        }

        // Step 2: Initialize graphs and in-degrees
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());
        for (int i = 0; i < groupCount; i++) groupGraph.add(new ArrayList<>());

        int[] itemInDegree = new int[n];
        int[] groupInDegree = new int[groupCount];

        // Step 3: Build the graphs
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemInDegree[i]++;

                if (group[prev] != group[i]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupInDegree[group[i]]++;
                }
            }
        }

        // Step 4: Topological Sort
        List<Integer> itemOrder = topoSort(itemGraph, itemInDegree, n);
        List<Integer> groupOrder = topoSort(groupGraph, groupInDegree, groupCount);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) return new int[0];

        // Step 5: Group items by their group ID
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemOrder) {
            groupToItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        // Step 6: Assemble the result based on group order
        int[] result = new int[n];
        int idx = 0;
        for (int grp : groupOrder) {
            List<Integer> items = groupToItems.getOrDefault(grp, new ArrayList<>());
            for (int item : items) {
                result[idx++] = item;
            }
        }

        return result;
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] inDegree, int count) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.add(next);
            }
        }

        return order.size() == count ? order : new ArrayList<>();
    }
}