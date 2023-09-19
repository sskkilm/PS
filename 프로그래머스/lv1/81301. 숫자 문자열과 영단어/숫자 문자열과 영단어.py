def solution(s):
    answer = ""
    
    my_dict = {"zero":'0', "one":'1', "two":'2', "three":'3', "four":'4', "five":'5', "six":'6', "seven":'7', "eight":'8', "nine":'9'}
    
    tmp = ""
    for word in s:
        if word.isdigit():
            answer += word
        else:
            tmp += word
            if tmp in my_dict:
                answer += my_dict[tmp]
                tmp = ""
    
    answer = int(answer)
    
    return answer