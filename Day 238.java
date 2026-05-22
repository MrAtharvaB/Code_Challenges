class Solution:
    def cntOnes(self, grid):
        n = len(grid)
        m = len(grid[0])

        visited = [[False] * m for _ in range(n)]

        def dfs(r, c):
            stack = [(r, c)]
            visited[r][c] = True

            while stack:
                x, y = stack.pop()

                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    nx, ny = x + dx, y + dy

                    if (0 <= nx < n and 0 <= ny < m and
                        grid[nx][ny] == 1 and not visited[nx][ny]):

                        visited[nx][ny] = True
                        stack.append((nx, ny))

        for i in range(n):
            if grid[i][0] == 1 and not visited[i][0]:
                dfs(i, 0)

            if grid[i][m - 1] == 1 and not visited[i][m - 1]:
                dfs(i, m - 1)

        for j in range(m):
            if grid[0][j] == 1 and not visited[0][j]:
                dfs(0, j)

            if grid[n - 1][j] == 1 and not visited[n - 1][j]:
                dfs(n - 1, j)

        count = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1 and not visited[i][j]:
                    count += 1

        return count
