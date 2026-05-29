from typing import Final


def check(x: float) -> bool:
    """ 检查 x 是否满足某种性质 """
    # return False
    return True

def bsearch(l: float, r: float) -> float:
    EPS: Final[float] = 1e-6
    while r - l > EPS:
        mid = (l + r) / 2
        if check(mid):
            r = mid
        else:
            l = mid
    return l