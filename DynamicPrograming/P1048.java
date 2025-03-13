package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1048 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int t = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        int[]times=new int[m];
        int[]values=new int[m];
        for (int i = 0; i < m ; i++) {
            st.nextToken();
            times[i]=(int)st.nval;
            st.nextToken();
            values[i]=(int)st.nval;
        }
        int[][]dp=new int[m][t+1];
        for (int j = 1; j <=t ; j++) {
            if (times[0]<=j){
                dp[0][j]=values[0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <=t ; j++) {
                if (times[i]<=j){
                    // 可以采
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-times[i]]+values[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[m-1][t]);
    }
}
