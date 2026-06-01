import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: MyQueue
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/6/1 20:45
 * @Version 1.0
 */
public class MyQueue<E> {
    Queue<E> myQueue = new ArrayDeque<>();

    public boolean offer(E e) {
        return myQueue.offer(e);
    }

    public E poll() {
        return myQueue.poll();
    }

    public E peek() {
        return myQueue.peek();
    }
}
