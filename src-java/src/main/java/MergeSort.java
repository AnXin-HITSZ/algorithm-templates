import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: MergeSort
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author AnXin
 * @Create 2026/5/27 22:20
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] tmp = new int[n];
        mergeSort(arr, 0, n - 1, tmp);

        StringBuilder sb = new StringBuilder();
        for (int num: arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);

        br.close();
    }

    static void mergeSort(int[] q, int l, int r, int[] tmp) {
        if (l >= r) {
            return;
        }

        int mid = l + r >> 1;
        mergeSort(q, l, mid, tmp);
        mergeSort(q, mid + 1, r, tmp);

        int k = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = q[i++];
        }
        while (j <= r) {
            tmp[k++] = q[j++];
        }

        System.arraycopy(tmp, 0, q, l, r - l + 1);
    }
}
