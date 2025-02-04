package TanXin;

import java.util.Scanner;

public class P3817 {
    public static void main(String[] args) {
        // 相邻的盒子糖数和 <=x
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long x=scanner.nextLong();
        long[]array=new long[n];
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextLong();
        }
        long sum=0;
        if (array[0]>x){
            // 将第一个吃到x最优
            long diff=array[0]-x;
            array[0]-=diff;
            sum+=diff;
        }
        // 每次吃糖果时 选择右边的 可以在两轮中起到作用
        for (int i = 0; i < n-1; i++) {
            long after = array[i]+array[i+1];
            if (after>x){
               long diff=after-x;
               array[i+1]-=diff;
               sum+=diff;
            }
        }
        System.out.println(sum);
    }
}
