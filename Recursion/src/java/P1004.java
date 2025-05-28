package Recursion.src.java;

import java.util.Scanner;

public class P1004 {
    public static void main(String[] args) {
            // 操作数序列 123
            // 123 132 213 231 321
        //
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long[]array=new long[n+1];
        array[0]=1;
        array[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                // 1-n 每个节点都当一次跟节点
                array[i]+=array[j-1]*array[i-j];
            }
        }
        System.out.println(array[n]);
    }
}
