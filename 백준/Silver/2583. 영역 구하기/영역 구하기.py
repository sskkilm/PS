import sys
sys.setrecursionlimit(10**6)

M, N, K = map(int, input().split())
maps = [[0] * (N) for _ in range(M)]

for _ in range(K):
    y1, x1, y2, x2 = map(int, input().split())
    for x in range(x1, x2):
        for y in range(y1, y2):
            maps[x][y] = 1

visited = [[False] * N for _ in range(M)]
delta = [(0, -1), (0, 1), (-1, 0), (1, 0)]
cnt = 0

def DFS(x, y):
    global cnt
    visited[x][y] = True
    cnt += 1

    for dx, dy in delta:
        next_x = x + dx
        next_y = y + dy

        if next_x < 0 or next_x > M-1: continue
        if next_y < 0 or next_y > N-1: continue

        if maps[next_x][next_y] == 0 and not visited[next_x][next_y]:
            DFS(next_x, next_y)

answer = []

for x in range(M):
    for y in range(N):
        if maps[x][y] == 0 and not visited[x][y]:
            DFS(x, y)
            answer.append(cnt)
            cnt = 0

answer.sort()
print(len(answer))
print(" ".join(map(str, answer)))