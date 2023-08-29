def solution(cap, n, deliveries, pickups):
    answer = 0

    copy_del = deliveries.copy()[::-1]
    copy_pic = pickups.copy()[::-1]

    d = 0
    p = 0

    for i in range(n):
        d += copy_del[i]
        p += copy_pic[i]

        while d > 0 or p > 0:
            d -= cap
            p -= cap
            answer += (n-i) * 2


    return answer