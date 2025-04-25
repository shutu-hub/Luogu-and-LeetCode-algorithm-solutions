package LanQiaoBei;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class P11_eight {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        int[][]arr=new int[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i+1 ; j++) {
                st.nextToken();
                arr[i][j]=(int)st.nval;
            }
        }
        long[][]dp=new long[n][n+1];
        dp[0][1]=arr[0][1];
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= i+1 ; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+arr[i][j];
            }
        }
        long max=0;
        if ((n&1)==0){
            // 偶数行 会走奇数步 左右之间差1
            int mid=n/2;
            max=Math.max(dp[n-1][mid],dp[n-1][mid+1]);
        }else{
            // 奇数
            max=dp[n-1][n/2+1];
        }
        System.out.println(max);
    }
}
