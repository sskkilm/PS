# computers = [
#     [1,1,0],
#     [1,1,0],
#     [0,0,1]
# ]
from collections import deque

def solution(n, computers):
    numberOfNetworks = 0
    
    visited = [False]*n
    
    def bfs(i):
        visited[i] = True
        que = deque()
        que.append(i)
        while que:
            cur_v = que.popleft()
            for j in range(len(computers[cur_v])):
                #if cur_v==j: continue
                if computers[cur_v][j]==1 and visited[j]==False:
                    visited[j] = True
                    que.append(j)
    
    for i in range(n):
        if visited[i]==False:
            bfs(i)    
            numberOfNetworks += 1
    
    return numberOfNetworks