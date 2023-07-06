from collections import deque

def solution(progresses, speeds):
    answer = []
    q1 = deque(progresses)
    q2 = deque(speeds)
    while True:
        if not q1: break
        
        tmp = []
        for i in range(len(q1)):
            q1[i] += q2[i]
        while q1 and q1[0] >= 100:
            tmp.append(q1.popleft())
            q2.popleft()
        if tmp:
            answer.append(len(tmp))
    return answer