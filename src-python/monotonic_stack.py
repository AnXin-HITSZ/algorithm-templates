"""
给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
"""


def monotonic_stack() -> None:
    stack: list[int] = []

    n: int = int(input())
    xs: list[int] = list(map(int, input().split()))
    for x in xs:
        while len(stack) != 0 and stack[-1] >= x:
            stack.pop()
        if len(stack) != 0:
            print(stack[-1], end=" ")
        else:
            print("-1", end=" ")

        stack.append(x)

if __name__ == "__main__":
    monotonic_stack()