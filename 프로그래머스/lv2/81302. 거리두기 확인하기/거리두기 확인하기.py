from collections import deque
def bfs(place, x, y):
    visited = [[False]*5 for _ in range(5)]
    queue = deque()
    queue.append((x, y, 0))
    visited[x][y] = True
    delta = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    while(queue):
        cur_x, cur_y, cur_dist = queue.popleft()
        
        if cur_dist > 2: continue
        if cur_dist != 0 and place[cur_x][cur_y] == 'P':
            return False
        
        for dx, dy in delta:
            next_x = cur_x + dx
            next_y = cur_y + dy
            
            if next_x < 0 or next_x > 4: continue
            if next_y < 0 or next_y > 4: continue
            
            if place[next_x][next_y] != 'X' and not visited[next_x][next_y]:
                queue.append((next_x, next_y, cur_dist+1))
                visited[next_x][next_y]
    return True

def check(place):
    for i in range(5):
        for j in range(5):
            if place[i][j] == 'P':
                if not bfs(place, i, j):
                    return False
    return True

def solution(places):
    answer = []
    for place in places:
        if check(place):
            answer.append(1)
        else:
            answer.append(0)
    return answer