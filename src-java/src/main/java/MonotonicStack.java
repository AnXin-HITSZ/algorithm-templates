import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * ClassName: MonotonicStack
 * Package: PACKAGE_NAME
 * Description:
 *          给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
 * @Author AnXin
 * @Create 2026/6/1 21:08
 * @Version 1.0
 */
public class MonotonicStack {

    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            while (!stack.isEmpty() && stack.peek() >= x) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                System.out.print(stack.peek() + " ");
            } else {
                System.out.print("-1 ");
            }

            stack.push(x);
        }
    }
}
