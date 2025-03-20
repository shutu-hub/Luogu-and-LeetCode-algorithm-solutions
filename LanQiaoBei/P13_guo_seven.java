package LanQiaoBei;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P13_guo_seven {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        st.nextToken();
        int m=(int)st.nval;
        st.nextToken();
        int k=(int)st.nval;
        int[]weights=new int[n];
        int[]values=new int[n];
        for (int i = 0; i < n ; i++) {
            st.nextToken();
            weights[i]=(int)st.nval;
            st.nextToken();
            values[i]=(int)st.nval;
        }
        long[][]dp=new long[m+1][2];
        // dp[j][0] 容量为j时不使用魔法的最大价值 dp[j][1] 容量为j时使用魔法的最大价值
        for (int i = 0; i < n; i++) {
            for (int j = m; j >=weights[i]; j--) {
                // j是从m->weights[i]的所以足够放这个物品
                // 不使用魔法时 选和不选这个物品
                dp[j][0]=Math.max(dp[j][0],dp[j-weights[i]][0]+values[i]);
                // 使用魔法时 选和不选这个物品
                dp[j][1]=Math.max(dp[j][1],dp[j-weights[i]][1]+values[i]);
                // 使用魔法状态下 选择是否对当前物品使用魔法
                if (j-weights[i]-k>=0){
                    dp[j][1]=Math.max(dp[j][1],dp[j-weights[i]-k][0]+2*values[i]);
                }
            }
        }
        System.out.println(Math.max(dp[m][0],dp[m][1]));
    }
}
