import java.util.*;

class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        ArrayList<Integer> leafLevels = new ArrayList<>();

        // Queue for level-order traversal
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        q.offer(root);
        levels.offer(1);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int level = levels.poll();

            // Leaf node
            if (curr.left == null && curr.right == null) {
                leafLevels.add(level);
            }

            if (curr.left != null) {
                q.offer(curr.left);
                levels.offer(level + 1);
            }

            if (curr.right != null) {
                q.offer(curr.right);
                levels.offer(level + 1);
            }
        }

        // Visit cheapest leaves first
        Collections.sort(leafLevels);

        int count = 0;

        for (int cost : leafLevels) {
            if (k >= cost) {
                k -= cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
