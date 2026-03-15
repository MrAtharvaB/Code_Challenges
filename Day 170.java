class Solution {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null)
                queue.offer(new Pair(node.left, hd - 1));

            if (node.right != null)
                queue.offer(new Pair(node.right, hd + 1));
        }

        for (ArrayList<Integer> list : map.values()) {
            result.add(list);
        }

        return result;
    }
}
