class Solution {
    
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        if (n == 0) return 0;

        int pivot = findPivot(arr);
        int count = 0;

        if (pivot > 0 && arr[0] <= x) {
            count += upperBound(arr, 0, pivot - 1, x);
        }

        if (arr[pivot] <= x) {
            count += upperBound(arr, pivot, n - 1, x);
        }

        return count;
    }

    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int upperBound(int[] arr, int low, int high, int x) {
        int l = low, r = high;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - low;
    }
}
