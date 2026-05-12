class Solution {
    
    class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new long[4 * n];
            build(0, 0, n - 1, arr);
        }

        void build(int node, int start, int end, int[] arr) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;

            build(2 * node + 1, start, mid, arr);
            build(2 * node + 2, mid + 1, end, arr);

            tree[node] = lcm(tree[2 * node + 1], tree[2 * node + 2]);
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node + 1, start, mid, idx, val);
            else
                update(2 * node + 2, mid + 1, end, idx, val);

            tree[node] = lcm(tree[2 * node + 1], tree[2 * node + 2]);
        }

        long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 1;

            if (l <= start && end <= r)
                return tree[node];

            int mid = (start + end) / 2;

            long left = query(2 * node + 1, start, mid, l, r);
            long right = query(2 * node + 2, mid + 1, end, l, r);

            return lcm(left, right);
        }

        long gcd(long a, long b) {
            while (b != 0) {
                long temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }

        long lcm(long a, long b) {
            return (a / gcd(a, b)) * b;
        }
    }

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {

        ArrayList<Long> ans = new ArrayList<>();

        SegmentTree st = new SegmentTree(arr);

        for (int[] q : queries) {

            if (q[0] == 1) {
                int index = q[1];
                int value = q[2];

                st.update(0, 0, arr.length - 1, index, value);
            } 
            else {
                int l = q[1];
                int r = q[2];

                ans.add(st.query(0, 0, arr.length - 1, l, r));
            }
        }

        return ans;
    }
}
