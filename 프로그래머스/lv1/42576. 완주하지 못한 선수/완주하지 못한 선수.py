def solution(participant, completion):
    par_dict= {}
    for p in participant:
        par_dict[p] = 0
    for p in participant:
        if p in par_dict:
            par_dict[p] += 1
    for c in completion:
        if c in par_dict:
            par_dict[c] -= 1
    for p in par_dict:
        if par_dict[p] == 1:
            return p