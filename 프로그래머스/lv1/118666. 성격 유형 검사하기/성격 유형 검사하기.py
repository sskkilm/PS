def solution(survey, choices):
    answer = ''
    
    my_dict = {}
    my_arr = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    
    for v in my_arr:
        my_dict[v] = 0
        
    for s, c in zip(survey, choices):
        score = c - 4
        if score < 0:
            my_dict[s[0]] += -score
        if score > 0:
            my_dict[s[1]] += score
    
    tuples = []
    for key, val in my_dict.items():
        tuples.append((key, val))

    for i in range(0, 8, 2):
        tmp = [tuples[i], tuples[i+1]]
        tmp.sort(key = lambda x:(-x[1], x[0]))
        answer += tmp[0][0]

    return answer