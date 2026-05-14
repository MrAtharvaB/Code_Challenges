class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int n = a.length;
        int m = b.length;
        
        if (m > n) return ans;
        
        int[] lps = new int[m];
        buildLPS(b, lps);
        
        int i = 0;
        int j = 0;
        
        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }
            
            if (j == m) {
                ans.add(i - j);
                j = lps[j - 1];
            }
            else if (i < n && a[i] != b[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return ans;
    }
    
    private void buildLPS(int[] pat, int[] lps) {
        int len = 0;
        int i = 1;
        
        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
