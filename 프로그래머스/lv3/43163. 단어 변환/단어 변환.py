from collections import deque

def solution(begin, target, words):
    answer = 0
    n = len(words)
    visited = [False] * (n+1)
    
    def strcmp(a, b):
        cnt = 0
        for i in range(len(a)):
            if a[i] == b[i]:
                cnt += 1
        if cnt == len(a)-1:
            return True
        else: return False
    
    que = deque()
    que.append((begin, 0))
    visited[0] = True

    while que:
        cur_v, cur_len = que.popleft()
        if cur_v == target:
            answer = cur_len
            break

        for i in range(len(words)):
            if strcmp(cur_v, words[i]) and not visited[i+1]:
                que.append((words[i], cur_len+1))
                visited[i+1] = True        
    
    return answer