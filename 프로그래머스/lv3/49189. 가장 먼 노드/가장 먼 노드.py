from collections import deque

def solution(n, edge):
    answer = 0
    memo = {}
    for e in edge:
        if e[0] not in memo:
            memo[e[0]] = [e[1]]
        else:
            memo[e[0]].append(e[1])

        if e[1] not in memo:
            memo[e[1]] = [e[0]]
        else:
            memo[e[1]].append(e[0])
    
    visited = [False] * n
    
    que = deque()
    que.append((1, 0))
    visited[0] = True
    max_len = 0
    vertex_list = []
    while que:
        cur_v, cur_len = que.popleft()
        vertex_list.append([cur_v, cur_len])
        max_len = max(max_len, cur_len)
        for next_v in memo[cur_v]:
            if not visited[next_v-1]:
                que.append((next_v, cur_len+1))
                visited[next_v-1] = True
    
    for i in range(len(vertex_list)):
        if vertex_list[i][1] == max_len:
            answer += 1
    
    return answer