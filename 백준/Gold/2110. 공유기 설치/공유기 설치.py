import sys
input = sys.stdin.readline

N, C = map(int,input().split())
array = [int(input()) for _ in range(N)]
array.sort() # 오름차순 정렬

start = 1 # 모든 집은 다른 좌표에 있으므로 최소 공유기 거리는 1
end = array[-1] - array[0] # 최대 공유기 거리는 맨 끝 집 - 맨 첫 집
answer = 0

while start <= end :
  cur = array[0]
  cnt = 1 # 항상 1번째 집에 공유기를 설치
  mid = (start+end) // 2
  for i in range(1,N) :
    if array[i] - cur >= mid :
      cnt += 1
      cur = array[i] # i번째 인덱스에 공유기 설치
  if cnt >= C :
    if answer < mid : 
      answer = mid
    start = mid + 1
  else :
    end = mid - 1

print(answer)