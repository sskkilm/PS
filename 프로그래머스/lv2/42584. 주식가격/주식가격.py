def solution(prices):
    answer = [0] * len(prices)
    stack = []
    for idx, val in enumerate(prices):
        while stack and stack[-1][1] > val:
            t = stack.pop()
            dt = idx - t[0]
            answer[t[0]] = dt
        stack.append((idx, val))
    while stack:
        t = stack.pop()
        dt = len(prices) - t[0] - 1
        answer[t[0]] = dt
    return answer