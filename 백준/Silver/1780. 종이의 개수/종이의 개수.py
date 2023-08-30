N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

def dfs(x, y, k):
    tmp = board[x][y]
    for i in range(x, x+k):
        for j in range(y, y+k):
            if board[i][j] != tmp:
                for a in range(3):
                    for b in range(3):
                        dfs(x+a*(k//3), y+b*(k//3), k//3)
                return
    
    if tmp == -1:
        answer[0] += 1
    if tmp == 0:
        answer[1] += 1
    if tmp == 1:
        answer[2] += 1        


answer = [0, 0, 0]
dfs(0, 0, N)
for ans in answer:
    print(ans)