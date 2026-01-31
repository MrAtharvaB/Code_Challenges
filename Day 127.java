import java.util.Arrays;

class kQueues {

    private int[] arr;
    private int[] next;
    private int[] front;
    private int[] rear;
    private int free;
    private int n, k;

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;

        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];

        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);

        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        free = 0;
    }

    void enqueue(int x, int i) {
        if (isFull()) return;

        int idx = free;
        free = next[idx];

        if (front[i] == -1) {
            front[i] = idx;
        } else {
            next[rear[i]] = idx;
        }

        next[idx] = -1;
        rear[i] = idx;
        arr[idx] = x;
    }

    int dequeue(int i) {
        if (isEmpty(i)) return -1;

        int idx = front[i];
        int result = arr[idx];

        front[i] = next[idx];

        if (front[i] == -1) {
            rear[i] = -1;
        }

        next[idx] = free;
        free = idx;

        return result;
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return free == -1;
    }
}
