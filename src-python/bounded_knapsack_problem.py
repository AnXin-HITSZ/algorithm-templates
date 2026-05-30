"""
有 N 种物品和一个容量是 V 的背包。

第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。
"""

def find_max_value(n: int, m: int, v: list[int], w: list[int], s: list[int]) -> int:
    f: list[list[int]] = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(0, m + 1):
            valid_ks = (k for k in range(0, s[i] + 1) if k * v[i] <= j)
            for k in valid_ks:
                f[i][j] = max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i])
    return f[n][m]

if __name__ == '__main__':
    n: int
    m: int
    v: list[int] = [0]
    w: list[int] = [0]
    s: list[int] = [0]
    n, m = tuple(map(int, input().split()))
    for i in range(1, n + 1):
        vi, wi, si = tuple(map(int, input().split()))
        v.append(vi)
        w.append(wi)
        s.append(si)

    ret = find_max_value(n, m, v, w, s)
    print(ret)