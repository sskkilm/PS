from collections import deque

class TreeNode:
    def __init__(self, val, level, left=None, right=None):
        self.val = val
        self.level = level
        self.left = left
        self.right = right

def func1(root, arr):
    if root.level == len(arr): return
    
    n = arr[root.level]
    root.left = TreeNode(val = root.val + n, level = root.level+1)
    root.right = TreeNode(val = root.val - n, level = root.level+1)
    func1(root.left, arr)
    func1(root.right, arr)

def func2(root, target, arr):
    if root.level == len(arr):
        if root.val == target:
            return 1
        return 0
    
    l = func2(root.left, target, arr)
    r = func2(root.right, target, arr)
    return l + r



def solution(numbers, target):
    answer = 0
    root = TreeNode(val = 0, level = 0)
    func1(root=root, arr=numbers)
    cnt = func2(root, target, numbers)
    
    return cnt