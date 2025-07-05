package Prefix;
import java.util.Arrays;
import java.util.Scanner;

public class P1496 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][]array=new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0]=sc.nextInt();
            array[i][1]=sc.nextInt();
        }
        Arrays.sort(array, (t1, t2) -> {
            if (t1[0]!=t2[0]){
                return t1[0]-t2[0];
            }else{
                return t1[1]-t2[1];
            }
        });
        long len=0;
        for (int i = 0; i < n-1; i++) {
            if (array[i][1]>array[i+1][0]){
                // 当前区间的结束点>下一个区间的开始点 重合 让这两个区间合并
                // 当前区间的开始点要比下一个节点的开始点小 所以让结束点是这两个区间结束点的较大值即可
                // 最后需要更新下一个区间和当前区间重合
                array[i][1]=Integer.max(array[i][1],array[i+1][1]);
                array[i+1][0]=array[i][0];
                array[i+1][1]=array[i][1];
            }else{
                len+=array[i][1]-array[i][0];
            }
        }
        len+=array[n-1][1]-array[n-1][0];
        System.out.println(len);
    }
}
