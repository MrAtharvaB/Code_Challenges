import java.util.*;

class Solution {

    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        // Build adjacency list using flat primitive arrays
        int[] head = new int[n + 1];
        Arrays.fill(head, -1);
        int[] to = new int[2 * n];
        int[] next = new int[2 * n];
        int edgeCount = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            to[edgeCount] = v;
            next[edgeCount] = head[u];
            head[u] = edgeCount++;

            to[edgeCount] = u;
            next[edgeCount] = head[v];
            head[v] = edgeCount++;
        }

        // 1. Calculate max depths for Red nodes within Red components
        int[] maxRedDepth = computeComponentMaxDepths(s, n, head, to, next, 'R');

        // 2. Calculate max depths for Blue nodes within Blue components
        int[] maxBlueDepth = computeComponentMaxDepths(s, n, head, to, next, 'B');

        int maxPath = 0;

        // Find max pure Red diameter
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'R') {
                maxPath = Math.max(maxPath, maxRedDepth[i]);
            }
        }

        // Find max pure Blue diameter
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'B') {
                maxPath = Math.max(maxPath, maxBlueDepth[i]);
            }
        }

        // 3. Check every Red -> Blue edge boundary
        for (int u = 1; u <= n; u++) {
            if (s.charAt(u - 1) == 'R') {
                for (int e = head[u]; e != -1; e = next[e]) {
                    int v = to[e];
                    if (s.charAt(v - 1) == 'B') {
                        int currentPath = maxRedDepth[u] + maxBlueDepth[v];
                        maxPath = Math.max(maxPath, currentPath);
                    }
                }
            }
        }

        return maxPath;
    }

    private int[] computeComponentMaxDepths(String s, int n, int[] head, int[] to, int[] next, char targetColor) {
        int[] maxDepth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // Reusable primitive arrays for BFS to avoid GC overhead
        int[] q = new int[n + 1];
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        int[] compNodes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == targetColor && !visited[i]) {
                int compSize = 0;

                // Step A: Collect all nodes in this monochromatic component
                int headQ = 0, tailQ = 0;
                q[tailQ++] = i;
                visited[i] = true;

                while (headQ < tailQ) {
                    int curr = q[headQ++];
                    compNodes[compSize++] = curr;

                    for (int e = head[curr]; e != -1; e = next[e]) {
                        int neighbor = to[e];
                        if (s.charAt(neighbor - 1) == targetColor && !visited[neighbor]) {
                            visited[neighbor] = true;
                            q[tailQ++] = neighbor;
                        }
                    }
                }

                if (compSize == 0) continue;

                // Step B: Find furthest node A in component starting from component root
                int nodeA = compNodes[0];
                int maxD = 0;

                headQ = 0; tailQ = 0;
                q[tailQ++] = nodeA;
                distA[nodeA] = 1;

                while (headQ < tailQ) {
                    int curr = q[headQ++];
                    if (distA[curr] > maxD) {
                        maxD = distA[curr];
                        nodeA = curr;
                    }
                    for (int e = head[curr]; e != -1; e = next[e]) {
                        int neighbor = to[e];
                        if (s.charAt(neighbor - 1) == targetColor && distA[neighbor] == 0) {
                            distA[neighbor] = distA[curr] + 1;
                            q[tailQ++] = neighbor;
                        }
                    }
                }

                // Reset distA ONLY for nodes in this component (avoid O(N) array fill)
                for (int k = 0; k < compSize; k++) {
                    distA[compNodes[k]] = 0;
                }

                // Step C: BFS from node A to get distA for all nodes and find node B
                int nodeB = nodeA;
                maxD = 0;

                headQ = 0; tailQ = 0;
                q[tailQ++] = nodeA;
                distA[nodeA] = 1;

                while (headQ < tailQ) {
                    int curr = q[headQ++];
                    if (distA[curr] > maxD) {
                        maxD = distA[curr];
                        nodeB = curr;
                    }
                    for (int e = head[curr]; e != -1; e = next[e]) {
                        int neighbor = to[e];
                        if (s.charAt(neighbor - 1) == targetColor && distA[neighbor] == 0) {
                            distA[neighbor] = distA[curr] + 1;
                            q[tailQ++] = neighbor;
                        }
                    }
                }

                // Step D: BFS from node B to get distB for all nodes
                headQ = 0; tailQ = 0;
                q[tailQ++] = nodeB;
                distB[nodeB] = 1;

                while (headQ < tailQ) {
                    int curr = q[headQ++];
                    for (int e = head[curr]; e != -1; e = next[e]) {
                        int neighbor = to[e];
                        if (s.charAt(neighbor - 1) == targetColor && distB[neighbor] == 0) {
                            distB[neighbor] = distB[curr] + 1;
                            q[tailQ++] = neighbor;
                        }
                    }
                }

                // Step E: Longest path passing through node x in component is max(distA[x], distB[x])
                // Clean up distA and distB array for component nodes only
                for (int k = 0; k < compSize; k++) {
                    int node = compNodes[k];
                    maxDepth[node] = Math.max(distA[node], distB[node]);
                    distA[node] = 0;
                    distB[node] = 0;
                }
            }
        }

        return maxDepth;
    }
}
