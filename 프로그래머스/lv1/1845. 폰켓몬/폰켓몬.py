def solution(nums):
    answer = 0
    nums_set = set(nums)
    a = len(nums_set)
    b = len(nums)/2
    if a>b:
        return b
    else: return a