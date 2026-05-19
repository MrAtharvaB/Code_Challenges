from collections import deque

class Solution:
    def minSteps(self, arr, start, end):

        if start == end:
            return 0

        dist = [-1] * 1000

        q = deque([start])
        dist[start] = 0

        while q:
            node = q.popleft()

            for num in arr:
                new_node = (node * num) % 1000

                if dist[new_node] == -1:
                    dist[new_node] = dist[node] + 1

                    if new_node == end:
                        return dist[new_node]

                    q.append(new_node)

        return -1
