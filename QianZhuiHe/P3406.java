package QianZhuiHe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class P3406 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int m= (int)st.nval;
        int[]array=new int[m+2];
        int[][]price=new int[n][3];
        for (int i = 1; i <=m ; i++) {
            st.nextToken();
            array[i]=(int)st.nval;
        }
        for (int i = 1; i < n; i++) {
            st.nextToken();
            int ai = (int)st.nval;
            st.nextToken();
            int bi = (int)st.nval;
            st.nextToken();
            int ci = (int)st.nval;
            price[i][0]= ai;
            price[i][1]= bi;
            price[i][2]= ci;
        }
        // 统计要走每个铁路的次数 铁路总数为n-1 前边开一个 后边开一个
        int[]flags=new int[n+1];
        for (int i = 1; i <m; i++) {
            if (array[i]>array[i+1]){
                // 例如 城市3->城市1 要走铁路2和铁路1 差分数组要正序打标记 即区间1-2
                flags[array[i+1]]++;
                flags[array[i]]--;
            }else{
               // 城市1->城市3 要走铁路1和铁路2
                flags[array[i]]++;
                flags[array[i+1]]--;
            }
        }
        int sum=0;
        for (int i = 1; i <n; i++) {
            sum+=flags[i];
            flags[i]=sum;
        }
        long payMoney=0;
        for (int i = 1; i <n; i++) {
            int count = flags[i];
            long zhiPiao = (long)count * price[i][0];
            long IC = (long)count * price[i][1]+price[i][2];
            payMoney+=Math.min(zhiPiao,IC);
        }
        System.out.println(payMoney);
    }
}
