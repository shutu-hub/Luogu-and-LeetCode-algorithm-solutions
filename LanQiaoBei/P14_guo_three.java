package LanQiaoBei;

import java.util.Arrays;
import java.util.Scanner;

public class P14_guo_three {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int length = 2 * n;
        int[]wi=new int[length];
        for (int i = 0; i < length ; i++) {
            wi[i]=scanner.nextInt();
        }
        Arrays.sort(wi);
        int minIndex=0;
        int maxIndex=length-1;
        long sum=0;
       while(minIndex<=maxIndex){
           sum+=(long)wi[minIndex]*wi[maxIndex];
           minIndex++;
           maxIndex--;
       }
        System.out.println(sum);
    }
}
