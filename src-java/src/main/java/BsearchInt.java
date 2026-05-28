/**
 * ClassName: BsearchInt
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/5/28 20:22
 * @Version 1.0
 */
public class BsearchInt {
    public static void main(String[] args) {

    }

    static boolean check(int x) {
        /* 检查 x 是否满足某种性质 */
//        return false;
        return true;
    }

    /**
     * 区间 [l, r] 被划分成 [l, mid] 和 [mid + 1, r] 时使用
     * 即：查找第一个满足条件的元素（左边界）
     */
    static int bsearch_1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 区间 [l, r] 被划分成 [l, mid - 1] 和 [mid, r] 时使用
     * 即：查找最后一个满足条件的元素（右边界）
     */
    int bsearch_2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
