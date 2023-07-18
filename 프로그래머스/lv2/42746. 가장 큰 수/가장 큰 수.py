def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(key = lambda x: x*3, reverse = True)
    for number in numbers:
        answer += number
    return str(int(answer))