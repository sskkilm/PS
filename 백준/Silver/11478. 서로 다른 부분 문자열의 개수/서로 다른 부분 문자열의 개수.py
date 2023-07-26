str = input()

str_dict = {}
for i in range(len(str)):
    tmp = ""
    for j in range(i, len(str)):
        tmp += str[j]
        if tmp not in str_dict:
            str_dict[tmp] = 1

print(len(str_dict))
