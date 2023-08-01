from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    maps = [[-1]*101 for _ in range(101)]
    
    for rect in rectangle:
        x1, y1, x2, y2, = map(lambda x: x*2, rect)
        for x in range(x1, x2+1):
            for y in range(y1, y2+1):
                if x>x1 and x<x2 and y>y1 and y<y2:
                    maps[x][y] = 0
                else:
                    if maps[x][y] != 0:
                        maps[x][y] = 1
    
    visited = [[False] * 101 for _ in range(101)]
    que = deque()
    que.append((characterX*2, characterY*2, 0))
    visited[characterX*2][characterY*2] = True
    
    delta = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while que:
        cur_x, cur_y, cur_len = que.popleft()
        if cur_x == itemX*2 and cur_y == itemY*2:
            answer = cur_len//2
            break
        
        for dx, dy in delta:
            next_x = cur_x + dx
            next_y = cur_y + dy
            
            if next_x < 1 or next_x > 100: continue
            if next_y < 1 or next_y > 100: continue
            
            if maps[next_x][next_y] == 1 and not visited[next_x][next_y]:
                que.append((next_x, next_y, cur_len+1))
                visited[next_x][next_y] = True
            
    return answer