import sys
sys.setrecursionlimit(10**6)

memo = {0:0, 1:1}
def f(n):
    if n not in memo:
        memo[n] = f(n-1) + f(n-2)
    
    return memo[n]

def solution(n):
    answer = 0
    answer = f(n) % 1234567
    return answer