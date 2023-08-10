N = int(input())
board = []
for _ in range(N):
    tmp = []
    str = input()
    for s in str:
        if s == '0':
            tmp.append(0)
        if s == '1':
            tmp.append(1)
    board.append(tmp)

cnt = 0
visited = [[False] * N for _ in range(N)]
delta = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def DFS(x, y):
    global cnt
    visited[x][y] = True
    cnt += 1

    for dx, dy in delta:
        next_x = x + dx
        next_y = y + dy

        if next_x < 0 or next_x > N-1: continue
        if next_y < 0 or next_y > N-1: continue

        if board[next_x][next_y] == 1 and not visited[next_x][next_y]:
            DFS(next_x, next_y)


answer = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 1 and not visited[i][j]:
            DFS(i, j)
            answer.append(cnt)
            cnt = 0

answer.sort()
print(len(answer))
for ans in answer:
    print(ans)