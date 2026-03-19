class Solution {

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int largestBst(Node root) {
        return solve(root).size;
    }

    static Info solve(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min) {

            int size = left.size + right.size + 1;
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(true, size, min, max);
        }

        return new Info(false,
                        Math.max(left.size, right.size),
                        0, 0);
    }
}
