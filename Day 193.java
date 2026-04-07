import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] partnerOfWoman = new int[n];
        Arrays.fill(partnerOfWoman, -1);

        int[] partnerOfMan = new int[n];
        Arrays.fill(partnerOfMan, -1);

        int[] nextProposal = new int[n];

        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][nextProposal[m]];
            nextProposal[m]++;

            if (partnerOfWoman[w] == -1) {
                partnerOfWoman[w] = m;
                partnerOfMan[m] = w;
            } else {
                int m2 = partnerOfWoman[w];

                if (rank[w][m] < rank[w][m2]) {
                    partnerOfWoman[w] = m;
                    partnerOfMan[m] = w;

                    partnerOfMan[m2] = -1;
                    freeMen.add(m2);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return partnerOfMan;
    }
}
