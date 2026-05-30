"""
有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。

第 i 件物品的体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值。
"""

def find_max_value(n: int, m: int, v: list[int], w: list[int]) -> int:
    f: list[list[int]] = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(0, m + 1):
            f[i][j] = f[i - 1][j]
            if j >= v[i]:
                f[i][j] = max(f[i][j], f[i - 1][j - v[i]] + w[i])
    return f[n][m]

if __name__ == '__main__':
    n: int
    m: int
    v: list[int] = [0]
    w: list[int] = [0]
    n, m = tuple(map(int, input().split()))
    for i in range(1, n + 1):
        vi, wi = tuple(map(int, input().split()))
        v.append(vi)
        w.append(wi)

    ret = find_max_value(n, m, v, w)
    print(ret)