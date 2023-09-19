def solution(s):
    answer = ""
    arr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    
    for idx, val in enumerate(arr):
        if val in s:
            s = s.replace(val, str(idx))
        answer = s
    
    return int(answer)