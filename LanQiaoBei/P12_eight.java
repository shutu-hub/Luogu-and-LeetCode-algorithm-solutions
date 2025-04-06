package LanQiaoBei;

import java.util.Scanner;

public class P12_eight {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long n = scanner.nextLong();
        int[][]array=new int[1001][1001];
        array[0][1]=1;
        long num=1;
        Out:
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j <=i+1 ; j++) {
                array[i][j]=array[i-1][j-1]+array[i-1][j];
                num++;
                if (array[i][j]==n){
                    System.out.println(num);
                    break Out;
                }
            }
        }
    }
}
