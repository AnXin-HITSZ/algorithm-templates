def quick_sort(q: list[int], l: int, r: int) -> None:
    if l >= r:
        return

    i = l - 1
    j = r + 1
    x = q[l + r >> 1]
    while i < j:
        i = i + 1
        while q[i] < x:
            i = i + 1
        j = j - 1
        while q[j] > x:
            j = j - 1
        if i < j:
            q[i], q[j] = q[j], q[i]
    quick_sort(q, l, j)
    quick_sort(q, j + 1, r)

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    quick_sort(arr, 0, len(arr) - 1)
    print(arr)