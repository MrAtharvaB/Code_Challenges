class Solution {
    public void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int front = q.poll();
        reverseQueue(q);
        q.offer(front);
    }
}
