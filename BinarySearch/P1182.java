package BinarySearch;

import java.util.Scanner;

public class P1182 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[]array=new int[n];
        int max=0;
        long sum=0;
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
            if (array[i]>max){
                max=array[i];
            }
            sum+=array[i];
        }
        long l=max;long r=sum;
        while (l<=r){
            long mid=(l+r)>>1;
            long count = check(mid, array);
            if (count>m){
                // 分段多 每段和最大值偏小
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(r+1);
    }

    public static long check(long mid,int[]array) {
        // 统计有多少段
        long top=0;
        long count=1;
        for (int i = 0; i < array.length; i++) {
            if (top+array[i]<=mid){
                // 可以放到一段
                top+=array[i];
            }else{
                // 放不到一段
                count++;
                top=array[i];
            }
        }
        return count;
    }
}
