package TanXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1478 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int s=scanner.nextInt();
        int a = scanner.nextInt();
        int b=scanner.nextInt();
        int[]xi=new int[n];
        int[][]array=new int[n][2];
        for (int i = 0; i < n; i++) {
            xi[i]=scanner.nextInt();
            array[i][0]=i;
            array[i][1]=scanner.nextInt();
        }
        Arrays.sort(array, (o1, o2) -> o1[1]-o2[1]);
        int count=0;
        int i=0;
        int maxHeight=a+b;
        while(s>0){
            int index = array[i][0];
            if (xi[index]<=maxHeight){
               // 可以拿到苹果
               s-=array[i][1];
               if (s>=0){
                   count++;
               }
           }
           i++;
        }
        System.out.println(count);
    }
}
