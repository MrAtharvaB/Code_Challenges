import java.util.*;

public class Solution {

    static class Node {
        int freq;
        int minIndex;   
        Node left, right;

        Node(int f, int idx) {
            freq = f;
            minIndex = idx;
        }

        Node(Node l, Node r) {
            left = l;
            right = r;
            freq = l.freq + r.freq;
            minIndex = Math.min(l.minIndex, r.minIndex);
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public static ArrayList<String> huffmanCodes(String s, int[] f) {
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();

        // Edge case: only one character
        if (n == 1) {
            ans.add("0");
            return ans;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) return a.freq - b.freq;
            return a.minIndex - b.minIndex;
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new Node(f[i], i));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.offer(new Node(left, right));
        }

        Node root = pq.poll();
        buildCodes(root, new StringBuilder(), ans);
        return ans;
    }

    private static void buildCodes(Node node, StringBuilder path, ArrayList<String> ans) {
        if (node == null) return;

        if (node.isLeaf()) {
            ans.add(path.toString());
            return;
        }

        path.append('0');
        buildCodes(node.left, path, ans);
        path.deleteCharAt(path.length() - 1);

        path.append('1');
        buildCodes(node.right, path, ans);
        path.deleteCharAt(path.length() - 1);
    }
}
