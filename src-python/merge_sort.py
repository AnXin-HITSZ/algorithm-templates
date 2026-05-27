def merge_sort(q: list[int], l: int, r: int) -> None:
    if l >= r:
        return

    mid = l + r >> 1
    merge_sort(q, l, mid)
    merge_sort(q, mid + 1, r)

    i = l
    j = mid + 1
    tmp: list[int] = []
    while i <= mid and j <= r:
        if q[i] <= q[j]:
            tmp.append(q[i])
            i = i + 1
        else:
            tmp.append(q[j])
            j = j + 1

    while i <= mid:
        tmp.append(q[i])
        i = i + 1
    while j <= r:
        tmp.append(q[j])
        j = j + 1

    i = l
    for item in tmp:
        q[i] = item
        i = i + 1

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    merge_sort(arr, 0, len(arr) - 1)
    print(arr)