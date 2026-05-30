import java.util.Scanner;

/**
 * ClassName: BoundedKnapSackProblem
 * Package: PACKAGE_NAME
 * Description:
 *          有 N 种物品和一个容量是 V 的背包。
 *
 *          第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 *
 *          求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 *          输出最大价值。
 * @Author AnXin
 * @Create 2026/5/30 21:04
 * @Version 1.0
 */
public class BoundedKnapSackProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }

        int ret = findMaxValue(n, m, v, w, s);

        System.out.println(ret);
    }

    public static int findMaxValue(int n, int m, int[] v, int[] w, int[] s) {
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        return f[n][m];
    }
}
