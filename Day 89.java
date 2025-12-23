import java.util.*;

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        
        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);
            result.add(right - left);
        }
        
        return result;
    }
    
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
