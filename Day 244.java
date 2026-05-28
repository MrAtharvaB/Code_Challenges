class Solution {

    void solve(Node root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;

        map.put(hd, map.getOrDefault(hd, 0) + root.data);

        solve(root.left, hd - 1, map);
        solve(root.right, hd + 1, map);
    }

    public ArrayList<Integer> verticalSum(Node root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        solve(root, 0, map);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int sum : map.values()) {
            ans.add(sum);
        }

        return ans;
    }
}
