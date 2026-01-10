class Solution {
    public int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private int atMostK(String s, int k) {
        if (k < 0) return 0;

        int[] freq = new int[26];
        int left = 0, distinct = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (freq[c - 'a'] == 0) distinct++;
            freq[c - 'a']++;

            while (distinct > k) {
                char l = s.charAt(left);
                freq[l - 'a']--;
                if (freq[l - 'a'] == 0) distinct--;
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
