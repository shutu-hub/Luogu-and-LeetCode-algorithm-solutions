import java.util.Scanner;

public class P3392 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[][] array = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            char[] chars = input.toCharArray();
            for (int j = 0; j < M; j++) {
                array[i][j] = chars[j];
            }
        }
        int sum=Integer.MAX_VALUE;
        // 使用前缀和数组来优化统计过程
        // 因为不知道这一行要涂白还是蓝或者红 所以我们需要创建一个二维数组 行为行号 列为白蓝红
        int[][]prefix=new int[N][3];
        // 双指针 对应了两个边界
        for (int i = 0; i < N-2; i++) {
            // i代表白色占的行数 即与蓝色的分界线
            for (int j = i+1; j <N-1 ; j++) {
                // 三个计数变量 仅代表当前行
                int countW = 0, countR = 0, countB = 0;
                // j代表蓝色的行数 即与红色的分界线
                // 白色是一个区域 所以需要双层循环 从0-i
                // 只遍历第i行的 然后使用前缀数组记录 避免重复统计
                for (int l = 0; l < M; l++) {
                    if (!(array[i][l] ==('W'))) {
                        countW++;
                    }
                }
                if (i!=0){
                    prefix[i][0]=prefix[i-1][0]+countW;
                }else{
                    prefix[i][0]=countW;
                }
                // 此为蓝色区域
                for (int l = 0; l < M; l++) {
                    if (!(array[j][l] ==('B'))) {
                        countB++;
                    }
                }
                prefix[j][1]=prefix[j-1][1]+countB;
                // 剩下的红色区域
                for (int k = j+1; k < N; k++) {
                    for (int l = 0; l < M; l++) {
                        if (!(array[k][l] ==('R'))) {
                            countR++;
                        }
                    }
                }
                sum=Math.min(sum, prefix[i][0]+prefix[j][1]+countR);
            }
        }
        System.out.println(sum);
    }
    
}
