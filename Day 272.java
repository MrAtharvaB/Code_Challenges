class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }

        if (n > 10) return ans;

        generate(n, 0, 1, ans);
        return ans;
    }

    static void generate(int n, int num, int start, ArrayList<Integer> ans) {
        if (n == 0) {
            ans.add(num);
            return;
        }

        for (int d = start; d <= 9; d++) {
            generate(n - 1, num * 10 + d, d + 1, ans);
        }
    }
}
