def solution(n, results):
    answer = 0
    board = [[0] * n for _ in range(n)]
    
    for a, b in results:
        board[a-1][b-1] = 1
        board[b-1][a-1] = -1

    for i in range(n):
        for j in range(n):
            for k in range(n):
                if board[j][i] == 0:
                    continue

                if board[j][i] == board[i][k]:
                    board[j][k] = board[j][i]
                    board[k][j] = -board[j][k]

    for i in range(n):
        if board[i].count(0) == 1:
            answer += 1

    return answer