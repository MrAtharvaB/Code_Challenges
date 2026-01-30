import java.util.*;

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        if (q == null || q.size() <= 1) return;

        int n = q.size();
        int half = n / 2;

        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < half; i++) {
            firstHalf.offer(q.poll());
        }

        while (!firstHalf.isEmpty()) {
            q.offer(firstHalf.poll());
            q.offer(q.poll());
        }
    }
}
