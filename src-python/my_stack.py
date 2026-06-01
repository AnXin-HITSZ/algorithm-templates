from typing import Any


class MyStack:
    def __init__(self):
        self.stack: list = []

    def append(self, item) -> None:
        self.stack.append(item)

    def pop(self) -> Any:
        return self.stack.pop()

    def peek(self) -> Any:
        return self.stack[-1]