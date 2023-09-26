def issosu(n):
    if n == 0 or n == 1:
        return False
    
    for i in range(2,int(n ** 0.5) + 1): # 소수찾기
        if n % i == 0:
            return False
        
    return True

def solution(n, k):
    answer = 0
    
    word = ""
    while n:
        word = str(n%k) + word
        n //= k
        
    word_list = word.split('0')
    
    for word in word_list:
        if word.isdigit() and issosu(int(word)):
            answer += 1
    return answer