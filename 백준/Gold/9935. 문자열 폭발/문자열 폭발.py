str1 = input()
str2 = input()

stack = []
for s in str1:
    stack.append(s)
    if s == str2[len(str2)-1]:
        if len(stack)-len(str2) >= 0 and ''.join(stack[len(stack)-len(str2):len(stack)])==str2:
            for _ in range(len(str2)):
                stack.pop()


if not stack:
    print("FRULA")
else: print(''.join(stack))