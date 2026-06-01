from collections import deque
from typing import Any


class MyQueue:
    def __init__(self):
        self.queue: deque = deque()

    def append(self, item) -> None:
        self.queue.append(item)

    def popleft(self) -> Any:
        return self.queue.popleft()

    def peek(self) -> Any:
        return self.queue[0]