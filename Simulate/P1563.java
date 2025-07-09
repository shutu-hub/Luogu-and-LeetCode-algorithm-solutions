package Simulate;

import java.util.Scanner;

public class P1563 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[]chaoXiang=new int[n];
        String[]zhiye=new String[n];
        for (int i = 0; i < n; i++) {
            chaoXiang[i]=scanner.nextInt();
            zhiye[i]=scanner.next();
        }
        // 当前人
        int current=0;
        for (int i = 0; i < m; i++) {
            int fangXiang=scanner.nextInt();
            int bushu=scanner.nextInt();
            if (fangXiang==0){
                // 左数
                if (chaoXiang[current]==0){
                    // 当前人朝圈内
                    current=current-bushu;
                    if (current<0){
                        current+=chaoXiang.length;
                    }
                }else{
                    // 当前人朝圈外
                    current=current+bushu;
                    if (current> chaoXiang.length-1){
                        current-=chaoXiang.length;
                    }
                }
            }else{
                // 右数
                if (chaoXiang[current]==0){
                    // 当前人朝圈内
                    current=current+bushu;
                    if (current> chaoXiang.length-1){
                        current-=chaoXiang.length;
                    }
                }else{
                    // 当前人朝圈外
                    current=current-bushu;
                    if (current<0){
                        current+=chaoXiang.length;
                    }
                }
            }
        }
        System.out.println(zhiye[current]);
    }
}