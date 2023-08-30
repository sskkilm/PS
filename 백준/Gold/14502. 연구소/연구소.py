import sys
import copy
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(N)]

q = deque()
delta = [(0, 1), (0, -1), (-1, 0), (1, 0)]

def bfs():
    global ans
    w = copy.deepcopy(map)
    for i in range(N):
        for j in range(M):
            if w[i][j]==2:
                q.append([i,j])

    while q:
        x, y = q.popleft()
        for dx, dy in delta:
            nx = x + dx
            ny = y + dy

            if nx < 0 or nx > N-1: continue
            if ny < 0 or ny > M-1: continue

            if w[nx][ny]==0:
                w[nx][ny] = 2
                q.append([nx,ny])

    cnt = 0
    for i in w:
        cnt+=i.count(0)
    ans = max(ans,cnt)

def wall(x):
    if x==3:
        bfs()
        return
    
    for i in range(N):
        for j in range(M):
            if map[i][j]==0:
                map[i][j]=1
                wall(x+1)
                map[i][j]=0

ans = 0
wall(0)
print(ans)