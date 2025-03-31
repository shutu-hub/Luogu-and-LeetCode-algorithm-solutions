package Simulate;

import java.util.Scanner;

public class P1328 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int na = scanner.nextInt();
        int nb = scanner.nextInt();
        int[]arrayA=new int[na+1];
        int[] arrayB=new int[nb+1];
        for (int i = 1; i <= na; i++) {
            arrayA[i]=scanner.nextInt();
        }
        for (int i = 1; i <= nb; i++) {
            arrayB[i]=scanner.nextInt();
        }
        int a=1,b=1;
        int aScore = 0,bScore=0;
        int[][] arr=new int[5][5];
        // 剪刀 石头 布 蜥蜴人 斯波克
        // 对角线为平局
        for (int i = 0; i < arr.length; i++) {
            arr[i][i]=0;
        }
        initArray(arr);

        for (int i = 0; i < n; i++) {
            int aInput = arrayA[a];
            int bInput = arrayB[b];
            if (arr[aInput][bInput]==1){
                // A赢一分
                aScore++;
            } else if (arr[aInput][bInput]==-1) {
                // B赢一分
                bScore++;
            }
            a++;
            b++;
            if (a>na){
                a=1;
            }
            if (b>nb){
                b=1;
            }
        }
        System.out.print(aScore+" "+bScore);
    }

    private static void initArray(int[][] arr) {
        arr[0][1]=-1;arr[1][0]=1;
        arr[0][2]=1;arr[2][0]=-1;
        arr[0][3]=1;arr[3][0]=-1;
        arr[0][4]=-1;arr[4][0]=1;
        arr[1][2]=-1;arr[2][1]=1;
        arr[1][3]=1;arr[3][1]=-1;
        arr[1][4]=-1;arr[4][1]=1;
        arr[2][3]=-1;arr[3][2]=1;
        arr[2][4]=1;arr[4][2]=-1;
        arr[3][4]=1;arr[4][3]=-1;
    }
}
