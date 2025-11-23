package TanXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P2240 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[][]array=new int[n][2];
        // 单价
        for (int i = 0; i < n; i++) {
            // 重量
            array[i][0] = scanner.nextInt();
            // 价值
            array[i][1] = scanner.nextInt();
        }
        Arrays.sort(array,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                double v1=o2[1]*1.0/o2[0];
                double v2=o1[1]*1.0/o1[0];
                return Double.compare(v1,v2);
            }
        });
        double sumValue=0;
        double sumWeight=0;
        for (int i = 0; i < array.length; i++) {
            if (sumWeight>=t){
                // 已放满
                break;
            }
            if (array[i][0]<=(t-sumWeight)){
                // 该物品可以全部存
                sumValue+=array[i][1];
                sumWeight+=array[i][0];
            }else {
                // 放不下该物品 放多少是多少
                sumValue+= array[i][1]*1.0 / array[i][0] *(t-sumWeight);
                break;
            }
        }
        System.out.printf("%.2f",sumValue);



    }
}
