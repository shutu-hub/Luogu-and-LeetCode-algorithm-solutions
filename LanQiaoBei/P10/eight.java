package LanQiaoBei.P10;

import java.util.Arrays;
import java.util.Scanner;

public class eight {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[]array=new long[n+m+1];
        long sum=0;
        for (int i = 0; i < n+m+1; i++) {
            array[i]=scanner.nextLong();
            sum+=array[i];
        }
        Arrays.sort(array);
        for (int i = 0; i < m; i++) {
            sum=sum-array[i]*2;
        }
        System.out.println(sum);
    }
}
