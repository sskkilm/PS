from collections import deque

def solution(maps):
    answer = -1
    n = len(maps)
    m = len(maps[0])
    visited = [[False]*m for _ in range(n)]

    que = deque()
    que.append((0,0,1))
    visited[0][0] = True

    delta = [(-1,0),(0,-1),(0,1),(1,0)]

    while que:
        cur_x, cur_y, cur_len = que.popleft()
        if cur_x == n-1 and cur_y == m-1:
            answer = cur_len
            break

        for dx, dy in delta:
            next_x = cur_x + dx
            next_y = cur_y + dy

            if next_x < 0 or next_x > n-1: continue
            if next_y < 0 or next_y > m-1: continue

            if maps[next_x][next_y]==1 and not visited[next_x][next_y]:
                que.append((next_x, next_y, cur_len+1))
                visited[next_x][next_y] = True
    
    return answer