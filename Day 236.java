class Solution:
    def isProduct(self, arr, target):
        seen = set()

        for num in arr:
            if target == 0:
                if num == 0 and seen:
                    return True
                if num != 0 and 0 in seen:
                    return True
            else:
                if num != 0 and target % num == 0:
                    if (target // num) in seen:
                        return True

            seen.add(num)

        return False
