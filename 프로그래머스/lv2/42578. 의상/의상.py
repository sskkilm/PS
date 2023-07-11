def solution(clothes):
    answer = 1
    
    d = {}
    for [name, kind] in clothes:
        if kind not in d:
            d[kind] = 1
        else:
            d[kind] += 1
   
    for key in d:
        answer *= d[key]+1
    
    return answer - 1