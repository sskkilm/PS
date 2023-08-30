board = [list(map(str, input().split())) for _ in range(5)]

answer = set()
delta = {(-1, 0), (1, 0), (0, -1), (0, 1)}

def dfs(x, y, num):
    if len(num) == 6:
        answer.add(num)
        return
    
    for dx, dy in delta:
        next_x = x + dx
        next_y = y + dy

        if next_x < 0 or next_x > 4: continue
        if next_y < 0 or next_y > 4: continue

        dfs(next_x, next_y, num + board[next_x][next_y])


for i in range(5):
    for j in range(5):
        dfs(i, j, board[i][j])
print(len(answer))