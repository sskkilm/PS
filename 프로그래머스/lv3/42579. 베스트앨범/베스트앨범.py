def solution(genres, plays):
    answer = []
    
    d = {}
    total = {}
    
    for i, (genre,play) in enumerate(zip(genres, plays)):
        if genre not in d:
            d[genre] = [(i, play)]
        else:
            d[genre].append((i, play))
        
        if genre not in total:
            total[genre] = play
        else:
            total[genre] += play
            
    for (k, v) in sorted(total.items(), key = lambda x:x[1], reverse = True):
        for (i, play) in sorted(d[k], key = lambda x:x[1], reverse = True)[:2]:
            answer.append(i)
    
    return answer