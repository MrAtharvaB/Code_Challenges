class Solution:
    def maxSubstring(self, s):
        max_sum = -1
        curr_sum = 0

        for ch in s:
            val = 1 if ch == '0' else -1
            curr_sum = max(val, curr_sum + val)
            max_sum = max(max_sum, curr_sum)

        return max_sum
