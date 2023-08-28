def solution(m, n, puddles):
    answer = 0
    board = [[0] * m for _ in range(n)]

    for y, x in puddles:
        board[x-1][y-1] = -1

    for y in range(m):
        for x in range(n):
            if board[x][y] == -1:
                board[x][y] = 0
            else:
                if x==0 and y==0:
                    board[x][y] = 1
                elif x-1<0:
                    board[x][y] = board[x][y-1]
                elif y-1<0:
                    board[x][y] = board[x-1][y]
                else:
                    board[x][y] = board[x-1][y] + board[x][y-1]

                
    answer = board[n-1][m-1] % 1000000007
    
    return answer