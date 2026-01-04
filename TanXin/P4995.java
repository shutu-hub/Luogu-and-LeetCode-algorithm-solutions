package TanXin;

import java.util.Arrays;
import java.util.Scanner;

public class P4995 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]h=new int[n];
        for (int i = 0; i <n; i++) {
            h[i]=scanner.nextInt();
        }
        // 每次跳跃花费最大的体力值
        Arrays.sort(h);
        long maxSpent=0;
        maxSpent+=h[n-1]*h[n-1];
        int l=0;
        int r=n-1;
        int i=1;
        while(l<r){
            // 选择高度差最大的两块石头 即最低的和最高的
            if (i%2==1){
                // 从高出蹦到地处
                maxSpent+=(h[r]-h[l])*(h[r]-h[l]);
                r--;
            }else{
                // 从低处蹦到高处
                maxSpent+=(h[r]-h[l])*(h[r]-h[l]);
                l++;
            }
           i++;
        }
        System.out.println(maxSpent);
    }
}
