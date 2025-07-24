package Optimize;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1886 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n= (int)st.nval;
        st.nextToken();
        int k= (int)st.nval;
        int[]number=new int[n];
        for (int i = 0; i <n ; i++) {
            st.nextToken();
            number[i]= (int)st.nval;
        }
        int[] min = getWindowValues(number, n, k, true);
        int[] max = getWindowValues(number, n, k, false);
        StringBuilder sb=new StringBuilder();
        for (int ele : min) {
            sb.append(ele).append(' ');
        }
        System.out.println(sb);
        sb=new StringBuilder();
        for (int ele : max) {
            sb.append(ele).append(' ');
        }
        System.out.println(sb);
    }

    private static int[] getWindowValues(int[] number, int n, int k, boolean isMin) {
        int[] result = new int[n - k + 1];
        int[] pos = new int[n];  // 存储下标
        int head = 0, tail = -1;

        for (int i = 0; i < n; i++) {
            // 维护队列单调性
            if (isMin) {
                // 当前值 <= 队列中最后一个的值 弹出队尾
                while (head <= tail && number[i] <= number[pos[tail]]) tail--;
            } else {
                // 当前值 >= 队列中最后一个的值 弹出队尾
                while (head <= tail && number[i] >= number[pos[tail]]) tail--;
            }
            pos[++tail] = i; // 存储下标

            // 移除过期元素 (超出窗口范围)
            while (pos[head] < i - k + 1) {
                head++;
            }

            // 窗口形成后记录结果
            if (i >= k - 1) {
                // 下标 k-1之后,队列长度都为k
                result[i - k + 1] = number[pos[head]];
            }
        }
        return result;
    }
}
