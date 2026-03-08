import java.util.*;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int x : arr){
            set.add(x);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int sum = arr[i]*arr[i] + arr[j]*arr[j];
                int c = (int)Math.sqrt(sum);
                
                if(c*c == sum && set.contains(c)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
