class SinglyLinkedListArray:
    def __init__(self):
        self._MAX_SIZE = 10000
        self._SENTINEL = 0

        self._e: list[int] = [0 for _ in range(0, self._MAX_SIZE)]
        self._ne: list[int] = [0 for _ in range(0, self._MAX_SIZE)]
        self._ne[self._SENTINEL] = -1
        self._idx: int = 1
        self._size: int = 0

    def insert(self, index: int, value: int) -> None:
        if index < 0 or index > self._size:
            raise IndexError("索引越界")

        prev: int = self._SENTINEL
        for _ in range(0, index):
            prev = self._ne[prev]

        self._e[self._idx] = value
        self._ne[self._idx] = self._ne[prev]
        self._ne[prev] = self._idx
        self._idx += 1
        self._size += 1

    def remove(self, index: int) -> int:
        if index < 0 or index >= self._size:
            raise IndexError("索引越界")

        prev: int = self._SENTINEL
        for _ in range(0, index):
            prev = self._ne[prev]

        del_node: int = self._ne[prev]
        self._ne[prev] = self._ne[del_node]
        self._size -= 1

        return self._e[del_node]

    def print_singly_linked_list_array(self) -> None:
        cur: int = self._ne[self._SENTINEL]
        while cur != -1:
            print(self._e[cur], end="")
            if self._ne[cur] != -1:
                print(" -> ", end="")
            cur = self._ne[cur]
        print()

if __name__ == '__main__':
    list = SinglyLinkedListArray()
    list.insert(0, 0)
    list.insert(1, 1)
    list.insert(2, 2)
    list.insert(3, 3)
    list.insert(4, 4)
    list.insert(5, 5)
    list.insert(6, 6)
    list.insert(7, 7)
    list.insert(8, 8)
    list.insert(9, 9)
    list.print_singly_linked_list_array()