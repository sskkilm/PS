n, x = map(int, input().split())
arr = list(map(int, input().split()))

sum = 0
cnt = 1

for i in range(0, x):
    sum += arr[i]
tmp = sum

for i in range(1, len(arr)-x+1):
    sum += arr[i+x-1]
    sum -= arr[i-1]
    if sum > tmp:
        tmp = sum
        cnt = 1
    elif sum == tmp:
        cnt += 1

if tmp == 0:
    print("SAD")
else:
    print(tmp)
    print(cnt)



# m = max(tmp)
# if m == 0:
#     print("SAD")
# else:
#     print(m)
#     print(tmp.count(m))