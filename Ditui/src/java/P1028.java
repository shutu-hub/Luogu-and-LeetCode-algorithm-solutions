package Ditui.src.java;
import java.util.Scanner;

public class P1028 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        // 使用数组记录中间1-n每个数可以构造的数列个数 避免重复计算
        int[]array=new int[n+1];
        // 得出每一位的个数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                array[i]+=array[j];
            }
            array[i]++;
        }
        System.out.println(array[n]);
    }



}
