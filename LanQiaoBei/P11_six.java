package LanQiaoBei;

import java.util.Scanner;

public class P11_six {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int max=-1;
        int min=Integer.MAX_VALUE;
        long sum=0;
        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            max=Math.max(max,score);
            min=Math.min(min,score);
            sum+=score;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f",(double)sum/n);
    }
}
