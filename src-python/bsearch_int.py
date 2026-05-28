def check(x: int) -> bool:
    """ 检查 x 是否满足某种性质 """
    # return False
    return True

def bsearch_1(l: int, r: int) -> int:
    """
    区间 [l, r] 被划分成 [l, mid] 和 [mid + 1, r] 时使用
    即：查找第一个满足条件的元素（左边界）
    """
    while l < r:
        mid = l + r >> 1
        if check(mid):
            r = mid
        else:
            l = mid + 1
    return l

def bsearch_2(l: int, r: int) -> int:
    """
    区间 [l, r] 被划分成 [l, mid - 1] 和 [mid, r] 时使用
    即：查找最后一个满足条件的元素（右边界）
    """
    while l < r:
        mid = l + r + 1 >> 1
        if check(mid):
            l = mid
        else:
            r = mid - 1
    return l