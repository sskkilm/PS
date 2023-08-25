from collections import defaultdict

def solution(N, number):
    memo = defaultdict(set)
    memo[1].add(N)
    for i in range(2, 9):
        memo[i].add(int(str(N)*i))
        for k in range(1, i):
            for a in memo[k]:
                for b in memo[i-k]:
                    memo[i].add(a+b)
                    memo[i].add(a-b)
                    memo[i].add(a*b)
                    if b != 0:
                        memo[i].add(a/b)

    for i in range(1, 9):
        if number in memo[i]:
            return i

    return -1