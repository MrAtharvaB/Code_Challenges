import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] degree = new int[V];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            
            degree[u]++;
            degree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        
        int remainingNodes = V;
        
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        return result;
    }
}
