from collections import deque

def solution(priorities, location):
    arr = []
    que = deque((idx, val) for idx, val in enumerate(priorities))
    while que:
        check = 0
        k = que.popleft()
        for i in range(0, len(que)):
            if k[1] < que[i][1]:
                que.append(k)
                check = 1
                break
        if check == 0:
            arr.append(k)
    for i in range(len(arr)):
        if arr[i][0] == location:
            return i+1