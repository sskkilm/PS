n, s = map(int, input().split())
arr = list(map(int, input().split()))

i = 0
j = 0
sum = arr[i]
cnt = 1
tmp = []

while True:
    if sum < s:
        j += 1
        if j >= n: break
        sum += arr[j]
        cnt += 1
    else:
        tmp.append(cnt)
        sum -= arr[i]
        i += 1
        cnt -= 1

if len(arr)==cnt and sum<s:
    print(0)
else:
    print(min(tmp))

