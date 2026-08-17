class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int N = n * n;
        int[] jump = new int[N + 1];

        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[N + 1];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cell = curr[0];
            int throwsCount = curr[1];

            if (cell == N) {
                return throwsCount;
            }

            for (int dice = 1; dice <= 6 && cell + dice <= N; dice++) {
                int next = cell + dice;

                if (jump[next] != 0) {
                    next = jump[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, throwsCount + 1});
                }
            }
        }

        return -1;
    }
}
