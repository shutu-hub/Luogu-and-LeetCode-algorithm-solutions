package DynamicPrograming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1216 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int r = (int)st.nval;
        int[][]array=new int[r][r+1];
        for (int i = 0; i < r ; i++) {
            for (int j = 1; j <= i+1; j++) {
                    st.nextToken();
                    array[i][j]=(int)st.nval;
            }
        }
        int[][]dp=new int[r][r+1];
        dp[0][1]=array[0][1];
        long max=dp[0][1];
        for (int i = 1; i < r; i++) {
            for (int j = 1; j <=i+1 ; j++) {
                dp[i][j]=Math.max(dp[i-1][j]+array[i][j],dp[i-1][j-1]+array[i][j]);
                max=Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
