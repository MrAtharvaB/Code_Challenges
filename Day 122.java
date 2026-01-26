import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(0, arr, res);
        return res;
    }
    
    private static void backtrack(int idx, int[] arr, ArrayList<ArrayList<Integer>> res) {
        if (idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : arr) temp.add(x);
            res.add(temp);
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            backtrack(idx + 1, arr, res);
            swap(arr, idx, i);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
