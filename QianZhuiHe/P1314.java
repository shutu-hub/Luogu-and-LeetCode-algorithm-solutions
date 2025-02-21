package QianZhuiHe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1314 {
    public static int n;

    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int)st.nval;
        st.nextToken();
        int m = (int)st.nval;
        st.nextToken();
        long s = (long) st.nval;
        int[][]array=new int[n+1][2];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            st.nextToken();
            int w = (int)st.nval;
            st.nextToken();
            int v = (int)st.nval;
            array[i][0]=w;
            array[i][1]=v;
            if (w>max)max=w;
            if (w<min)min=w;
        }
        int[][]query=new int[m][2];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int li =(int)st.nval;
            st.nextToken();
            int ri = (int)st.nval;
            query[i][0]=li;
            query[i][1]=ri;
        }
        // 二分查找w
        int l=min;int r=max;
        int mid=0;
        long minDiff=Long.MAX_VALUE;
        while(l<=r){
            mid=(l+r)>>1;
            long y = judge(mid, array, query);
            if (Math.abs(s-y)<minDiff)minDiff=Math.abs(s-y);
            if (s>y){
                 r=mid-1;
            }else if (s<y){
                l=mid+1;
            }else{
                break;
            }
        }
        System.out.println(minDiff);
    }

    public static long judge(int w,int[][]array,int[][]query){
        long[]prefix_w=new long[n+1];
        long[]prefix_wv=new long[n+1];
        for (int i = 1; i <=n ; i++) {
            int wi = array[i][0];
            int vi = array[i][1];
            if (wi>=w){
                prefix_w[i]=prefix_w[i-1]+1;
                prefix_wv[i]=prefix_wv[i-1]+vi;
            }else{
                prefix_w[i]=prefix_w[i-1];
                prefix_wv[i]=prefix_wv[i-1];
            }
        }
        long sum=0;
        for (int[] ints : query) {
            int li = ints[0];
            int ri = ints[1];
            long sumWi=prefix_w[ri]-prefix_w[li];
            long sumWVi=prefix_wv[ri]-prefix_wv[li];
            if (array[li][0]>=w){
                sumWi+=1;
                sumWVi+=array[li][1];
            }
            long yi = sumWi*sumWVi;
            sum+=yi;
        }
        return sum;
    }
}
