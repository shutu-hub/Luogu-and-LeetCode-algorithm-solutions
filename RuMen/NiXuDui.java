package RuMen;

import java.util.Scanner;


public class NiXuDui {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
        }
        long count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if (array[i]>array[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
