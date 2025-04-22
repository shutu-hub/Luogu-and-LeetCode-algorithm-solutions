package DynamicPrograming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class P2196 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[]number=new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            number[i]=(int) st.nval;
        }
        int[][]adj=new int[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                st.nextToken();
                adj[i][j]=(int) st.nval;
            }
        }
        int[]dp=new int[n];
        int[]prev=new int[n];
        int max=-1;
        int maxIndex=-1;
        // 初始化所有前驱路径为-1 假设不存在
        Arrays.fill(prev,-1);
        for (int i = 0; i < n; i++) {
            // 遍历所有点 初始化每个点的值
            dp[i]=number[i];
            for (int j = 0; j < i; j++) {
                // 遍历其所有连通点 因为是往下的 所以连通点小于i
                if (adj[j][i]!=0){
                        // 连通
                    if (dp[j]+number[i]>dp[i]){
                        dp[i]=dp[j]+number[i];
                        prev[i]=j;
                    }
                }
            }
            if (dp[i]>max){
                // max指向最大值的终点
                max=dp[i];
                maxIndex=i;
            }
        }
        // 输出到max点的路径
        int current=maxIndex;
        ArrayList<Integer>lists=new ArrayList<>();
        while (current!=-1){
            // 继续找前驱
           lists.add(current+1);
           current=prev[current];
        }
        for (int i = lists.size()-1; i >=0 ; i--) {
            System.out.print(lists.get(i)+" ");
        }
        System.out.println();
        System.out.println(max);
    }
}




