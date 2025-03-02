package Optimize;

import java.util.Scanner;

public class P1115 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n+1];
        for (int i = 1; i <= n; i++) {
            array[i]=scanner.nextInt();
        }
        long maxSum=Integer.MIN_VALUE;
        long nowSum=0;
        for (int i = 1; i <= n; i++) {
            nowSum+=array[i];
            // 先比较较大值 如果此时maxSum<0 那么把nowSum赋值为0 会将最大值的结果赋值为0 但实际上是个负数
            maxSum=Math.max(maxSum,nowSum);
            if (nowSum<0){
                nowSum=0;
            }
        }
        System.out.println(maxSum);
    }
}
