package SouSuo;

import java.util.Scanner;

public class P2404 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n];
        dfs(n,0,array,0);
    }

    /**
     *
     * @param target n
     * @param sum 已选数之和
     * @param array 存储所选数字
     * @param k 当前数索引
     */
    public static void dfs(int target,int sum,int[] array,int k) {
        if (sum>=target){
            int total=0;
            for (int j : array) {
                if (j != 0) {
                    total += j;
                    if (total < sum) {
                        System.out.print(j + "+");
                    } else {
                        System.out.print(j);
                    }
                }
            }
            System.out.println();
        }
        // 总数-该数之前已经拆分的数之和 等于当前数可以取到的最大值
        for (int i = 1; i <= target-sum; i++) {
            if (k>=1 && i<array[k-1]){
                // 拆分的数字由小到大排列
                continue;
            }
            if (i==target){
                break;
            }
            array[k]=i;
            dfs(target,sum+i,array,k+1);
            array[k]=0;
        }
    }
}
