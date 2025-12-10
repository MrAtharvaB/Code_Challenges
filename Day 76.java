class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        long S = (long)n * (n + 1) / 2;
        long P = (long)n * (n + 1) * (2 * n + 1) / 6;

        long S1 = 0, P1 = 0;
        
        for (int x : arr) {
            S1 += x;
            P1 += (long)x * x;
        }
        
        long diff = S1 - S;
        long sqDiff = P1 - P;
        
        long sum = sqDiff / diff;
        
        long R = (diff + sum) / 2;
        long M = R - diff;
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)R);
        ans.add((int)M);
        return ans;
    }
}
