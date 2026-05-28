/**
 * ClassName: BsearchDouble
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/5/28 21:45
 * @Version 1.0
 */
public class BsearchDouble {
    public static void main(String[] args) {

    }

    static boolean check(double x) {
        /* 检查 x 是否满足某种性质 */
//        return false;
        return true;
    }

    static double bsearch(double l, double r) {
        final double EPS = 1e-6;
        while (r - l > EPS) {
            double mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
