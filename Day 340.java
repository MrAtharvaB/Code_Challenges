class Solution {
    public int solve(int n, String s) {
        boolean[] using = new boolean[26];
        boolean[] rejected = new boolean[26];

        int available = n;
        int answer = 0;

        for (char c : s.toCharArray()) {
            int i = c - 'A';

            if (!using[i] && !rejected[i]) {
                // Arrival
                if (available > 0) {
                    using[i] = true;
                    available--;
                } else {
                    rejected[i] = true;
                    answer++;
                }
            } else {
                // Departure
                if (using[i]) {
                    using[i] = false;
                    available++;
                }
            }
        }

        return answer;
    }
}
