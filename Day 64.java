class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int total;
        int mod = n & 3;
        if (mod == 0) total = n;
        else if (mod == 1) total = 1;
        else if (mod == 2) total = n + 1;
        else total = 0;

        if (total == n) {
            for (int i = 1; i <= n; i++) result.add(i);
            return result;
        }

        int x = total ^ n;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            result.add(i);
        }
        return result;
    }
}
