package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1873 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        long m = (long)st.nval;
        int[]heights=new int[n];
        int r=0;
        for (int i = 0; i <n; i++) {
            st.nextToken();
            heights[i]=(int)st.nval;
            r=Math.max(r,heights[i]);
        }
        int l=0;r=r-1;
        // 二分 查找应该选择的砍伐高度
        while(l<=r) {
            // 统计木材数量 找到>该高度的木材下标
            int mid=l+r>>1;
            long count=0;
            for (int i = 0; i <=n-1; i++) {
                if (heights[i]>mid){
                    count+=heights[i]-mid;
                }
            }
            if (count>=m){
                // 要找到最大的砍伐高度 l继续向右走
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(l-1);
    }



}
