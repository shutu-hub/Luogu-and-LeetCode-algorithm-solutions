package LanQiaoBei;

import java.util.Scanner;

public class P12_two {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long n = scanner.nextLong();
        int l=1;int r=100000;
        while (l<=r){
            int mid=(l+r)>>1;
            long sum=(long)mid*(mid+1)/2;
            if (sum>=n){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println(r+1);
    }
}
