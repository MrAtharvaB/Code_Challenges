import java.util.*;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean[] visited = new boolean[V];
        int candidate = -1;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                candidate = i;
            }
        }
        
        Arrays.fill(visited, false);
        dfs(candidate, adj, visited);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        
        for (int i = 0; i < candidate; i++) {
            Arrays.fill(visited, false);
            dfs(i, adj, visited);
            
            boolean allReached = true;
            for (int j = 0; j < V; j++) {
                if (!visited[j]) {
                    allReached = false;
                    break;
                }
            }
            
            if (allReached) {
                return i;
            }
        }
        
        return candidate;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
