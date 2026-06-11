class Solution:
    def findIndex(self, s):
        n = len(s)
        
        openLeft = 0
        closeRight = s.count(')')
        
        for k in range(n + 1):
            if openLeft == closeRight:
                return k
            
            if k < n:
                if s[k] == '(':
                    openLeft += 1
                else:
                    closeRight -= 1
