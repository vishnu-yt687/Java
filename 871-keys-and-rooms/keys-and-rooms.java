import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Start with room 0
        visited[0] = true;
        queue.add(0);
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            count++; 
            
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }
        
        return count == n;
    }
}