import java.util.*;

class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] out = new int[V];
        
        for (int i = 0; i < V; i++) out[i] = -1;
        
        for (int[] e : edges) {
            out[e[0]] = e[1];
        }

        boolean[] visited = new boolean[V];
        int ans = -1;

        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;

            int curr = i;
            int step = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            while (curr != -1 && !visited[curr]) {
                visited[curr] = true;
                map.put(curr, step++);
                curr = out[curr];

                if (curr != -1 && map.containsKey(curr)) {
                    int cycleLen = step - map.get(curr);
                    ans = Math.max(ans, cycleLen);
                    break;
                }
            }
        }

        return ans;
    }
}
