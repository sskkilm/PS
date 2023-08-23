import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

visited = [False] * 100001
queue = deque()
queue.append((N, 0))

prev = [-1] * 100001

while queue:
    cur_x, cur_t = queue.popleft()
    if cur_x == K:
        answer = []
        while cur_x != N:
            answer.append(cur_x)
            cur_x = prev[cur_x]
        answer.append(N)
        answer.reverse()
        print(cur_t)
        print(' '.join(map(str, answer)))
        break

    for next_x in [cur_x-1, cur_x+1, 2*cur_x]:
        if 0 <= next_x < 100001:
            if not visited[next_x]:
                queue.append((next_x, cur_t+1))
                visited[next_x] = True
                prev[next_x] = cur_x
                
