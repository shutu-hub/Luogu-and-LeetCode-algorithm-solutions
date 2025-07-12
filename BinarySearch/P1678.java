package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class P1678 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int m = (int)st.nval;
        st.nextToken();
        int n = (int)st.nval;
        int[]luquScores=new int[m];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            luquScores[i]= (int)st.nval;
        }
        int[]xueShengScores=new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            xueShengScores[i]= (int)st.nval;
        }
        Arrays.sort(luquScores);
        long count=0;
        for (int i = 0; i < n; i++) {
            int score = xueShengScores[i];
            int index = binarySearch(score, luquScores);
            // 找到时最小值为0 没找到时返回的是应该在的位置(可能是0 和 luquScores.length ) 而原这个位置值>其
            if (index>luquScores.length-1){
                // 最后 
                count+=score-luquScores[luquScores.length-1];
            }else if (index>0){
                int one = Math.abs(score - luquScores[index]);
                int two = Math.abs(score - luquScores[index-1]);
                count+=Math.min(one,two);
            }else{
                int one = Math.abs(score - luquScores[index]);
                count+=one;
            }
        }
        System.out.println(count);
    }
    // 1 3 5

    public static int binarySearch(int target,int[]array){
        int left=0;int right=array.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if (array[mid]<target){
                left=mid+1;
            }else if (array[mid]>target){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return left;
    }
}