def solution(today, terms, privacies):
    answer = []
    term_dict = {}
    for term in terms:
        a, b = term.split()
        term_dict[a] = int(b)
        y2, m2, d2 = map(int, today.split("."))
    for i in range(len(privacies)):
        tmp1, tmp2 = privacies[i].split()
        y1, m1, d1 = map(int, tmp1.split("."))
        k1 = y1*12*28 + (m1+term_dict[tmp2])*28 + d1 - 1
        k2 = y2*12*28 + m2*28 + d2
        
        if k2 > k1:
            answer.append(i+1)
                
    answer.sort()
    
    return answer