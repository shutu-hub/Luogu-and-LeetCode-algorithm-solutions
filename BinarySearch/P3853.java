package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P3853 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int l = (int)st.nval;
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int k = (int)st.nval;
        int[]array=new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            array[i]=(int)st.nval;
        }
        int left=0;int right=l;
        while(left<=right){
            int mid=(left+right)>>1;
            long count=0;
            for (int i = 0; i < n-1; i++) {
                int diff = array[i+1] - array[i];
                if (diff>mid){
                    // 需要插入路标
                    count+=(diff-1)/mid;
                }
            }
            if (count>k){
                // 最大距离太小
                left=mid+1;
            }else{
                // 最短距离过大
                right=mid-1;
            }
        }
        System.out.println(right+1);
    }
}
