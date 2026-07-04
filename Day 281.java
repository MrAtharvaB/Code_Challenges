class Solution {
    
    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countSubstring(String s) {
        int n = s.length();

        int offset = n + 2;            
        Fenwick ft = new Fenwick(2 * n + 5);

        int prefix = 0;
        long ans = 0;

        ft.update(prefix + offset, 1);

        for (char c : s.toCharArray()) {
            if (c == '1')
                prefix++;
            else
                prefix--;

            int idx = prefix + offset;

            ans += ft.query(idx - 1);

            ft.update(idx, 1);
        }

        return (int) ans;
    }
}
