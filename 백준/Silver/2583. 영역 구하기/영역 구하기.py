from collections import deque

M, N, K = map(int, input().split())
maps = [[0] * (N) for _ in range(M)]

for _ in range(K):
    y1, x1, y2, x2 = map(int, input().split())
    for x in range(x1, x2):
        for y in range(y1, y2):
            maps[x][y] = 1

visited = [[False] * N for _ in range(M)]
delta = [(0, -1), (0, 1), (-1, 0), (1, 0)]
cnt1 = 0
def BFS(x, y):
    cnt2 = 1
    que = deque()
    que.append((x,y))
    visited[x][y] = True
    while que:
        cur_x, cur_y= que.popleft()

        for dx, dy in delta:
            next_x = cur_x + dx
            next_y = cur_y + dy

            if next_x < 0 or next_x > M-1: continue
            if next_y < 0 or next_y > N-1: continue

            if maps[next_x][next_y] == 0 and not visited[next_x][next_y]:
                que.append((next_x, next_y))
                cnt2 += 1
                visited[next_x][next_y] = True
    return cnt2

answer = []

for x in range(M):
    for y in range(N):
        if maps[x][y] == 0 and not visited[x][y]:
            answer.append(BFS(x, y))
            cnt1 += 1
answer.sort()
print(cnt1)
print(" ".join(map(str, answer)))