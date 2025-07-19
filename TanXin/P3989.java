package TanXin;

import java.util.Arrays;
import java.util.Scanner;

public class P3989 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n];
        int total=0;
        for (int i = 0; i < array.length; i++) {
            array[i]=scanner.nextInt();
            total+=array[i];
        }
        int minSum=Integer.MAX_VALUE;
        // 奶茶数量固定 价钱总数固定 尽可能多的使用优惠卷 即尽可能的原价多买几次 先买便宜的
        Arrays.sort(array);
        // 1 2 3 3 4
        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = 0; j <=i ; j++) {
                sum+=array[j];
            }
            int u =Math.min(i+1,total-sum);
            minSum=Math.min(minSum,total-u);
        }
        System.out.println(minSum);
    }
}
