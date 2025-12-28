package BinarySearch;

import java.util.Scanner;

public class P2440 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int k=scanner.nextInt();
        int[]len=new int[n];
        int r=-1;
        for (int i = 0; i < n; i++) {
            len[i]=scanner.nextInt();
            if (len[i]>r){
                r=len[i];
            }
        }
        int l=0;
        while(l<=r){
            int mid=(l+r)>>1;
            int count=0;
            for (int i = 0; i <n ; i++) {
                count+=len[i]/mid;
                if (count>=k){
                    break;
                }
            }
            if (count>=k){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        // 因为mid是最大有效输出长度 mid=l-1
        System.out.println(l-1);

    }
}
