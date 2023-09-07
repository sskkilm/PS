from collections import defaultdict

def solution(id_list, report, k):
    answer = []
    
    # 피신고자 -> 신고자
    my_dict = defaultdict(set)
    # 결과
    result_dict = dict.fromkeys(id_list, 0)

    for r in report:
        a, b = r.split()
        my_dict[b].add(a)

    for key in my_dict.keys():
        if len(my_dict[key]) >= k:
            for v in list(my_dict[key]):
                result_dict[v] += 1

    answer = list(result_dict.values())

    return answer