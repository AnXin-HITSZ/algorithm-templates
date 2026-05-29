/**
 * ClassName: SinglyLinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/5/29 15:53
 * @Version 1.0
 */
public class SinglyLinkedList<E> {

    private final Node dummyHead;
    private int size;

    public SinglyLinkedList() {
        dummyHead = new Node(null);
        size = 0;
    }

    private class Node {
        E data;
        Node next;

        Node() {

        }

        Node(E data) {
            this.data = data;
            this.next = null;
        }

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node newNode = new Node(e);
        newNode.next = prev.next;
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
        delNode.next = null;
        size--;
        return delNode.data;
    }

    public void printSinglyLinkedList() {
        Node cur = dummyHead.next;
        while (cur.next != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}
