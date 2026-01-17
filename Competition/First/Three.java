package Competition.First;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // L=R U=D 可以回到起点 否则为-1
        char[]chars=scan.next().toCharArray();
        int r=0;
        int l=0;
        int u=0;
        int d=0;
        for(char ele:chars){
            if(ele=='L'){
                l++;
            }else if(ele=='R'){
                r++;
            }else if(ele=='U'){
                u++;
            }else{
                d++;
            }
        }
        // 多的减少少的增加
        if((l+u+r+d)%2!=0){
            System.out.println(-1);
        }else{
            // 相同的抵消
            int diffLR=Math.abs(l-r);
            int diffUD=Math.abs(u-d);
            int result = (diffUD + diffLR) / 2;
            System.out.println(result);
        }
        scan.close();
    }
}
