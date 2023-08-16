#import sys
from collections import deque



#input = sys.stdin.readline
F, S, G, U, D = map(int, input().split())
visited = [False] * (F+1)

def bfs(v):
    q = deque()
    q.append([v, 0])
    visited[v] = True
    delta = [U, -D]
    while q:
        v, cur_cnt = q.popleft()
        if v == G:
            return cur_cnt
        for dt in delta:
            next_v = v + dt
            if 0 < next_v <= F and not visited[next_v]:
                visited[next_v] = True
                q.append([next_v, cur_cnt+1])
    return -1

answer = bfs(S)
if answer == -1:
    print("use the stairs")
else:
    print(answer)