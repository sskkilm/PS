import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())

visited = [0] * 100001
queue = deque()
queue.append(n)

ans_count = 0
ans_way = 0
while queue:
    x = queue.popleft()
    count = visited[x]
    if x == k:
        ans_count = count
        ans_way += 1
        continue

    for next_x in [x-1, x+1, 2*x]:
        if 0 <= next_x < 100001:
            if visited[next_x] == 0 or visited[next_x] == visited[x] + 1:
                queue.append(next_x)
                visited[next_x] = count + 1
                

print(ans_count)
print(ans_way)