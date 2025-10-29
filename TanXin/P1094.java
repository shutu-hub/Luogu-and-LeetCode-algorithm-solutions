package TanXin;

import java.util.Arrays;
import java.util.Scanner;

public class P1094 {
    public static void main(String[] args) {
        // 纪念品分组 每组<=2件 价值和<=w 求分组数最少(尽量两两一组)
        // 90 (20，80)  (20,70) (30,60) 50 90
        // 每次挑选一个最大的和最小的，如果相加>w,最大的单独一组
        Scanner scanner=new Scanner(System.in);
        int w = scanner.nextInt();
        int g = scanner.nextInt();
        int[]price=new int[g];
        for (int i = 0; i < g; i++) {
            price[i]=scanner.nextInt();
        }
        int count=0;
        Arrays.sort(price);
        int l=0;
        int r=price.length-1;
        while(l<=r){
              if (price[l]+price[r]<=w){
                  // 最小值和最大值组合
                  count++;
                  l++;
                  r--;
              } else{
                  // 最大值单独一组 然后r指针--
                  count++;
                  r--;
              }
        }
        System.out.println(count);
    }
}
