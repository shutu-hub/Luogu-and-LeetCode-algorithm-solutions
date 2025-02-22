package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class P1102 {
    public static long count=0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        st.nextToken();
        long c=(int)st.nval;
        long[]array=new long[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            array[i]= (long)st.nval;
        }
        Arrays.sort(array);
        // 法1:使用map数组映射每个数字出现的次数
        // Map<Long,Long>map=new HashMap<>();
//        for (long ele : array) {
//           map.put(ele,map.getOrDefault(ele,0L)+1);
//        }
//        for (int i = 0; i < n; i++) {
//            // B+C>0  A一定为正数 去找A
//            if (map.containsKey(array[i] + c)){
//               count+=map.get(array[i] + c);
//           }
//        }
//        System.out.println(count);
        // 法2:使用二分查找，将查找一个数的复杂度从O(n)降低到O(logn) 查找一个数出现的次数 可以将数组排序 然后找到该值最大和最小的索引
        for (int i = 0; i < n; i++) {
            int upperIndex = upper_number(array[i] - c, array);
            int lowerIndex = lower_number(array[i] - c, array);
            if (upperIndex==-1){
                continue;
            }
            count+=upperIndex-lowerIndex+1;
        }
        System.out.println(count);
    }

    public static int upper_number(long target,long[]array) {
        int left=0;int right=array.length-1;
        int index=-1;
        while(left<=right){
            int mid=left+right>>1;
            if (array[mid]<target){
                left=mid+1;
            }else if (array[mid]==target){
                left=mid+1;
                index=mid;
            }else{
                right=mid-1;
            }
        }
        return index;
    }

    public static int lower_number(long target,long[]array) {
        int left=0;int right=array.length-1;
        int index=-1;
        while(left<=right){
            int mid=left+right>>1;
            if (array[mid]<target){
                left=mid+1;
            }else if (array[mid]==target){
                right=mid-1;
                index=mid;
            }else{
                right=mid-1;
            }
        }
        return index;
    }

}
// Map<Long,Long>map=new HashMap<>();
//        for (long ele : array) {
//           map.put(ele,map.getOrDefault(ele,0L)+1);
//        }
//        for (int i = 0; i < n; i++) {
//            // B+C>0  A一定为正数 去找A
//            if (map.containsKey(array[i] + c)){
//               count+=map.get(array[i] + c);
//           }
//        }
//        System.out.println(count);