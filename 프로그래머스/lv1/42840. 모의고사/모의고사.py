def solution(answers):
    answer = []
    p = []
    p.append([1,2,3,4,5])
    p.append([2,1,2,3,2,4,2,5])
    p.append([3,3,1,1,2,2,4,4,5,5])
    cnt = [0]*3
    for i in range(len(answers)):
        if answers[i]==p[0][i%len(p[0])]:
            cnt[0] += 1
        if answers[i]==p[1][i%len(p[1])]:
            cnt[1] += 1
        if answers[i]==p[2][i%len(p[2])]:
            cnt[2] += 1
            
    for i in range(3):
        if cnt[i] == max(cnt):
            answer.append(i+1)
    return answer