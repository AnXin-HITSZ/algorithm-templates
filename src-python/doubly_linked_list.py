from typing import TypeVar, Generic


E = TypeVar('E')


class DoublyLinkedList(Generic[E]):

    class _Node:
        def __init__(self, data: E | None):
            self.data: E = data
            self.prev: DoublyLinkedList._Node | None = None
            self.next: DoublyLinkedList._Node | None = None

    def __init__(self):
        self._dummy_head = self._Node(None)
        self._size = 0

    def insert(self, index: int, e: E) -> None:
        if index < 0 or index > self._size:
            raise IndexError("索引越界")

        prev: DoublyLinkedList._Node = self._dummy_head
        for _ in range(0, index):
            prev = prev.next

        new_node: DoublyLinkedList._Node = self._Node(e)
        new_node.prev = prev
        new_node.next = prev.next
        if prev.next is not None:
            prev.next.prev = new_node
        prev.next = new_node
        self._size += 1

    def remove(self, index: int) -> E:
        if index < 0 or index >= self._size:
            raise IndexError("索引越界")

        prev: DoublyLinkedList._Node = self._dummy_head
        for _ in range(0, index):
            prev = prev.next

        del_node: DoublyLinkedList._Node = prev.next
        prev.next = del_node.next
        if del_node.next is not None:
            del_node.next.prev = prev
        del_node.prev = None
        del_node.next = None
        self._size -= 1

        return del_node.data

    def print_doubly_linked_list(self):
        cur: DoublyLinkedList._Node = self._dummy_head.next
        while cur is not None:
            print(cur.data, end="")
            if cur.next is not None:
                print(" <-> ", end="")
            cur = cur.next

if __name__ == "__main__":
    linked_list = DoublyLinkedList[int]()
    linked_list.insert(0, 0)
    linked_list.insert(1, 1)
    linked_list.insert(2, 2)
    linked_list.insert(3, 3)
    linked_list.insert(4, 4)
    linked_list.insert(5, 5)
    linked_list.insert(6, 6)
    linked_list.insert(7, 7)
    linked_list.insert(8, 8)
    linked_list.insert(9, 9)
    linked_list.print_doubly_linked_list()