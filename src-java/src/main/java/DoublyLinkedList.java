import org.w3c.dom.Node;

/**
 * ClassName: DoublyLinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/5/31 16:30
 * @Version 1.0
 */
public class DoublyLinkedList<E> {

    private Node dummyHead;
    private int size;

    DoublyLinkedList() {
        this.dummyHead = new Node(null, null, null);
        this.size = 0;
    }

    private class Node {
        E data;
        Node prev;
        Node next;

        Node() {

        }

        Node(E data) {
            this.data = data;
        }

        Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node newNode = new Node(e);
        newNode.prev = prev;
        newNode.next = prev.next;
        if (prev.next != null) {
            prev.next.prev = newNode;
        }
        prev.next = newNode;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        if (delNode.next != null) {
            delNode.next.prev = prev;
        }
        delNode.prev = null;
        delNode.next = null;
        size--;

        return delNode.data;
    }

    public void printDoublyLinkedList() {
        Node cur = dummyHead.next;
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) {
                System.out.print(" <-> ");
            }
            cur = cur.next;
        }
    }
}
