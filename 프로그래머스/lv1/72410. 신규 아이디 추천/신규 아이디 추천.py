def solution(new_id):
    answer = ''
    
    print(new_id)

    # 1단계
    new_id = new_id.lower()
    # 2단계
    for word in new_id:
        if word.isalnum() or word in '-_.':
            answer += word
    # 3단계
    while '..' in answer:
        answer = answer.replace('..', '.')
    # 4단계
    answer = answer.strip('.')
    # 5단계
    if answer == '':
        answer = 'a'
    # 6단계
    if len(answer) >= 16:
        answer = answer[:15]
        answer = answer.strip('.')
    # 7단계
    while len(answer) <= 2:
        answer += answer[-1]
    
    return answer