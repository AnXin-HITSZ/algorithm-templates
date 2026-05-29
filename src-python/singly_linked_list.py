from typing import TypeVar, Generic


E = TypeVar('E')


class SingleLinkedList(Generic[E]):

    class _Node:
        def __init__(self, data: E | None):
            self.data = data
            self.next: SingleLinkedList._Node | None = None

    def __init__(self):
        self._dummyHead = self._Node(None)
        self._size = 0

    def add(self, index: int, e: E) -> None:
        if index < 0 or index > self._size:
            raise IndexError("索引越界")

        prev = self._dummyHead
        for _ in range(index):
            prev = prev.next

        new_node = self._Node(e)
        new_node.next = prev.next
        prev.next = new_node
        self._size += 1

    def remove(self, index: int) -> E:
        if index < 0 or index >= self._size:
            raise IndexError("索引越界")

        prev = self._dummyHead
        for _ in range(index):
            prev = prev.next

        del_node = prev.next
        prev.next = del_node.next
        del_node.next = None
        self._size -= 1
        return del_node.data

    def print_singly_linked_list(self) -> None:
        cur = self._dummyHead.next
        while cur.next is not None:
            print(cur.data, end=" -> ")
            cur = cur.next
        print(cur.data)

if __name__ == '__main__':
    list = SingleLinkedList()
    list.add(0, 0)
    list.add(1, 1)
    list.add(2, 2)
    list.add(3, 3)
    list.add(4, 4)
    list.add(5, 5)
    list.add(6, 6)
    list.add(7, 7)
    list.add(8, 8)
    list.add(9, 9)
    list.print_singly_linked_list()