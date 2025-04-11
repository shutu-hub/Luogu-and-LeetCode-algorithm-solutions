package Prefix;

import java.util.Scanner;

public class P8218 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n+1];
        int[]prefix=new int[n+1];
        for (int i = 1; i <= n; i++) {
            array[i]=scanner.nextInt();
            prefix[i]=prefix[i-1]+array[i];
        }
        int m=scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            System.out.println(prefix[r]-prefix[l]+array[l]);
        }
    }
}
