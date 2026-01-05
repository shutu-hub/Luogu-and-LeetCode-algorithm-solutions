package RuMen;

import java.util.Scanner;

/**
 * 2.国王将金币作为工资，发放给忠诚的骑士。第一天，骑士收到一枚金币；之后两天（第二天和第三天），每天收到两枚金币；
 * 之后三天（第四、五、六天），每天收到三枚金币；之后四天（第七、八、九、十天），每天收到四枚金币……；
 * 这种工资发放模式会一直这样延续下去：当连续 n 天每天收到 n 枚金币后，骑士会在之后的连续 n + 1 天里，每天收到 n + 1 枚金币。
 * 请计算在前 k 天里，骑士一共获得了多少金币。
 */
public class Jinbi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int cur = 1;
        long sum=0;
        int add=1;
        if (k==0){
            System.out.println(0);
            return;
        }
        int count=0;
        // 1 2 2 3 3 3 4 4 4 4
        // 1 1
        // 2-3 2
        // 4-6 3
        // 7-11 4
        // 12-16 5
        while (cur<=k){
            sum+=add;
            cur++;
            // add和天数的关系
            count++;
            if (count>=add){
                add++;
                count=0;
            }
        }
        System.out.println(sum);
    }
}
