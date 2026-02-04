package TanXin;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class P1223 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[][]array=new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            array[i][0]=i;
            array[i][1]=scanner.nextInt();
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        // 每个人的等待时间
        long sum=0;
        // 所有人的等待时间
        long total=0;
        System.out.print(array[1][0]+" ");
        for (int i = 2; i <=n ; i++) {
            sum+=array[i-1][1];
            total+=sum;
            System.out.print(array[i][0]+" ");
        }
        double result=total*1.0/n;
        System.out.println();
        System.out.printf("%.2f",result);
        // 0 1 1+12 1+12+33 1+12+33+55 1+12+33+55+56 1+12+33+55+56+99 1+12+33+55+56+99+99 1+12+33+55+56+99+234 1+12+33+55+56+99+234+1000
        // sum 1 13  46 101
        // total 1 14 60 161



    }
}
