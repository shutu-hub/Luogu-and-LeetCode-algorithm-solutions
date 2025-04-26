package LanQiaoBei.P9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class five {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        int[]ai=new int[n];
        for(int i=0;i<n;i++){
            st.nextToken();
            ai[i]=(int)st.nval;
        }
        int[]bi=new int[n];
        for(int i=0;i<n;i++){
            st.nextToken();
            bi[i]=(int)st.nval;
        }
        int[]ci=new int[n];
        for(int i=0;i<n;i++){
            st.nextToken();
            ci[i]=(int)st.nval;
        }
        Arrays.sort(ai);
        Arrays.sort(ci);
        long sum=0;
        long cLenth=ci.length;
        for (int i = 0; i < bi.length; i++) {
            // 找到bi中>ai的下标
            int lastIndex = one(ai, bi[i]);
            // 找到bi中<ci的下标
            int lastIndexTwo = two(ci, bi[i]);
            sum+=(lastIndex+1)*(cLenth-lastIndexTwo);
        }
        System.out.println(sum);
    }
    // 找到小于bi的最大索引数
    public static int one(int[] array,int target){
        int l=0;int r=array.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (array[mid]>target){
                r=mid-1;
            }else if (array[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if (l-1<0){
            return -1;
        }else{
            return l-1;
        }
    }
    // 找到大于bi的最小索引数
    public static int two(int[] array,int target){
        int l=0;int r=array.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (array[mid]>target){
                r=mid-1;
            }else if (array[mid]<target){
                l=mid+1;
            }else{
                l=mid+1;
            }
        }
        if (r+1>array.length-1){
            return array.length;
        }else{
            return r+1;
        }
    }
}
