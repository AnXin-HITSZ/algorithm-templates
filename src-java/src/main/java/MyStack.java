import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: MyStack
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/6/1 20:41
 * @Version 1.0
 */
public class MyStack<E> {
    Deque<E> stack = new ArrayDeque<>();

    public void push(E e) {
        stack.push(e);
    }

    public E pop() {
        return stack.pop();
    }

    public E peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
