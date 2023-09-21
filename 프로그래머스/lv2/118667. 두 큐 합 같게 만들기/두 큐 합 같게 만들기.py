from collections import deque

def solution(queue1, queue2):
    answer = 0
    que1 = deque(queue1)
    que2 = deque(queue2)
    sum1 = sum(que1)
    sum2 = sum(que2)
    tot = sum1 + sum2
    
    if tot % 2 == 1:
        return -1
    
    for _ in range(300000):
        if sum1 > sum2:
            tmp = que1.popleft()
            que2.append(tmp)
            sum1 -= tmp
            sum2 += tmp
            answer += 1
        elif sum1 < sum2:
            tmp = que2.popleft()
            que1.append(tmp)
            sum1 += tmp
            sum2 -= tmp
            answer += 1
        else:
            return answer
            
    return -1