package TanXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1208 {
    public static void main(String[] args) {
        // 30 100 180  320
        // 10 20  30   40
        // 优先选择单价便宜的
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][]array=new int[m][3];
        for (int i = 0; i < m; i++) {
            // 索引
            array[i][0]=i;
            // 单价
            array[i][1]=scanner.nextInt();
            // 产量
            array[i][2]=scanner.nextInt();
        }
        // 按单价排序
        Arrays.sort(array, (o1, o2) -> o1[1]-o2[1]);
        // 购买
        long pay=0;
        for (int i = 0; i < array.length; i++) {
            if (n>=array[i][2]){
                // 需要购买量>产量
                pay+=array[i][1]*array[i][2];
                n-=array[i][2];
            }else{
                // 购买量小于产量
                if (n<=0){
                    break;
                }else{
                    pay+=array[i][1]*n;
                    break;
                }
            }
        }
        System.out.println(pay);


    }
}
