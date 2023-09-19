def solution(numbers, hand):
    answer = ''
    pos_dict = {0:(0,0), 7:(-1,1), 8:(0,1), 9:(1,1), 4:(-1,2), 5:(0,2), 6:(1,2), 1:(-1, 3), 2:(0, 3), 3:(1,3)}
    pos_left = (-1, 0)
    pos_right = (1, 0)
    left = [1, 4, 7]
    right = [3, 6, 9]
    for number in numbers:
        if number in left:
            answer += 'L'
            pos_left = pos_dict[number]
        elif number in right:
            answer += 'R'
            pos_right = pos_dict[number]
        else:
            x, y = pos_dict[number]
            x1, y1 = pos_left
            x2, y2 = pos_right
            dist1 = abs(x-x1) + abs(y-y1)
            dist2 = abs(x-x2) + abs(y-y2)
            if dist1 < dist2:
                answer += 'L'
                pos_left = (x, y)
            elif dist2 < dist1:
                answer += 'R'
                pos_right = (x, y)
            else:
                if hand == 'left':
                    answer += 'L'
                    pos_left = (x, y)
                else:
                    answer += 'R'
                    pos_right = (x, y)
    return answer