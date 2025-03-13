package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P2196 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[] number = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // 初始化dp数组为-1，不过后续会被覆盖

        for (int i = 0; i < n; i++) {
            st.nextToken();
            number[i] = (int) st.nval;
        }

        int[][] adv = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                st.nextToken();
                adv[i][j] = (int) st.nval; // 仅设置单向通道i->j
            }
        }
        int[] path = new int[n];
        Arrays.fill(path, -1); // 使用-1表示无前驱
        long max = dp[0];
        int maxIndex = 0;
        for (int j = 0; j < n; j++) {
            // 初始化dp数组为每个地窖本身的地雷数
            dp[j]=number[j];
            for (int i = 0; i < j; i++) {
                if (adv[i][j] != 0) { // 存在i到j的通道
                    if (dp[i] + number[j] > dp[j]) {
                        dp[j] = dp[i] + number[j];
                        path[j] = i;
                    }
                }
            }
            // 更新最大值和对应的索引
            if (dp[j] > max) {
                max = dp[j];
                maxIndex = j;
            }
        }

        // 构建路径
        ArrayList<Integer> pathList = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            pathList.add(current + 1);
            current = path[current];
        }
        Collections.reverse(pathList); // 反转得到从起点到终点的顺序

        // 输出路径
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pathList.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(pathList.get(i));
        }
        System.out.println(sb);
        System.out.println(max);
    }
}