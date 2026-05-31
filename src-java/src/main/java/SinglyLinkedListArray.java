/**
 * ClassName: SinglyLinkedListArray
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/5/29 20:37
 * @Version 1.0
 */
public class SinglyLinkedListArray {

    private static final int MAX_SIZE = 10000;
    private static final int SENTINEL = 0;

    int[] e = new int[MAX_SIZE];
    int[] ne = new int[MAX_SIZE];
    int idx;
    int size;

    SinglyLinkedListArray() {
        ne[SENTINEL] = -1;
        idx = 1;
        size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        int prev = SENTINEL;
        for (int i = 0; i < index; i++) {
            prev = ne[prev];
        }

        e[idx] = value;
        ne[idx] = ne[prev];
        ne[prev] = idx;
        idx++;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }

        int prev = SENTINEL;
        for (int i = 0; i < index; i++) {
            prev = ne[prev];
        }

        int delNode = ne[prev];
        ne[prev] = ne[delNode];
        size--;

        return e[delNode];
    }

    public void printSinglyLinkedList() {
        int cur = ne[SENTINEL];
        while (cur != -1) {
            System.out.print(e[cur]);
            if (ne[cur] != -1) {
                System.out.print(" -> ");
            }
            cur = ne[cur];
        }
    }
}
