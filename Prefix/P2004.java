package Prefix;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P2004 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int m = (int)st.nval;
        st.nextToken();
        int c = (int)st.nval;
        int[][]array=new int[n+1][m+1];
        long[][]prefix=new long[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                st.nextToken();
                array[i][j]=(int)st.nval;
                prefix[i][j]=prefix[i][j-1]+prefix[i-1][j]-prefix[i-1][j-1]+array[i][j];
            }
        }
        long maxValue=0;
        int xx=-1;
        int yy=-1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                int x=i+c-1;int y=j+c-1;
                if (x>n || y>m){
                    break;
                }
                long value  = prefix[x][y] - prefix[x][j - 1] - prefix[i - 1][y] + prefix[i - 1][j - 1];
                if (maxValue<value){
                    maxValue=value;
                    xx=i;yy=j;
                }
            }
        }
        System.out.println(xx+" "+yy);
    }
}
