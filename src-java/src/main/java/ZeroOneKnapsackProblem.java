import java.util.Scanner;

/**
 * ClassName: ZeroOneKnapsackProblem
 * Package: PACKAGE_NAME
 * Description:
 *          有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 *          第 i 件物品的体积是 vi，价值是 wi。
 *
 *          求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 *          输出最大价值。
 * @Author AnXin
 * @Create 2026/5/30 17:19
 * @Version 1.0
 */
public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        int ret = findMaxValue(n, m, v, w);

        System.out.println(ret);

        scan.close();
    }

    public static int findMaxValue(int n, int m, int[] v, int[] w) {
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        return f[n][m];
    }
}
