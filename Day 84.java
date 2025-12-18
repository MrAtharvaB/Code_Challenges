import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        
        for (int num : arr) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);
        
        int index = 0;
        for (int num : odd) {
            arr[index++] = num;
        }
        for (int num : even) {
            arr[index++] = num;
        }
    }
}
