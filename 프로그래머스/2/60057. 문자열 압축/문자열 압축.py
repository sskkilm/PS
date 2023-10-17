def solution(s):
    answer = len(s)
    
    if answer == 1:
        return 1
    
    for i in range(1, len(s)//2 + 1):
        compressed = ''
        prev = s[0:i]
        cnt = 1
        for j in range(i, len(s), i):
            next = s[j:j+i]
            if prev == next:
                cnt += 1
            else:
                if cnt >= 2:
                    compressed += str(cnt) + prev
                else:
                    compressed += prev
                prev = next
                cnt = 1

        if cnt >= 2:
                    compressed += str(cnt) + prev
        else:
            compressed += prev
        answer = min(answer, len(compressed))
    
    return answer