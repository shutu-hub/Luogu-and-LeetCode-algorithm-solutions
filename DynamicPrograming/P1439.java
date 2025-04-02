package DynamicPrograming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1439 {
    public static void main(String[] args) throws IOException {
//        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        st.nextToken();
//        int n = (int)st.nval;
//        int[]a1=new int[n+1];
//        int[]a2=new int[n+1];
//        for (int i = 1; i <= n; i++) {
//            st.nextToken();
//            a1[i]=(int)st.nval;
//        }
//        for (int i = 1; i <= n; i++) {
//            st.nextToken();
//            a2[i]=(int)st.nval;
//        }
//        int[][]dp=new int[2][n+1];
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=n ; j++) {
//                int index = i % 2;
//                if (a1[index]==a2[j]){
//                    dp[index][1]=dp[i-1][j-1]+1;
//                }else{
//                    dp[index][1]=Math.max(dp[i-1][1],dp[i][1]);
//                }
//            }
//        }
//        System.out.println(dp[n][1]);
    }
}
