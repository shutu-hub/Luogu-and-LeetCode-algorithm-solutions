package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P2367 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int p = (int)st.nval;
        int[]array=new int[n+2];
        // 用该数组标记区间的变化情况
        int[]flags=new int[n+2];
        for (int i = 1; i < n+1; i++) {
            st.nextToken();
            array[i]=(int)st.nval;
        }
        for (int i = 0; i < p; i++) {
            st.nextToken();
            int start = (int)st.nval;
            st.nextToken();
            int end = (int)st.nval;
            st.nextToken();
            int count = (int)st.nval;
            // 起点
            flags[start]+=count;
            // 终点之后打个补丁
            flags[end+1]-=count;
        }
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < n+1 ; i++) {
            sum+=flags[i];
            array[i]+=sum;
            if (array[i]<min){
                min=array[i];
            }
        }
        System.out.println(min);
    }
}
