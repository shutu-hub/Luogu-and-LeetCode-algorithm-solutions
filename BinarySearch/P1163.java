package BinarySearch;


import java.util.Scanner;

public class P1163 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long w0 = scanner.nextLong();
        long w = scanner.nextLong();
        long m = scanner.nextLong();
        // 每月偿还的为 固定本金/(1+利率)的i次方
        double r=300.0;
        double l=0;
        while(r-l>0.00000000001){
            double mid=(l+r)/2;
            double money=judge(mid/100,w,m);
            if (Math.abs(money-w0)<0.0001){
                System.out.printf("%.1f",mid);
                break;
            }else if (money>w0){
                // 大于贷款原值 利率低
                l=mid;
            }else if (money<w0){
                r=mid;
            }
        }
    }

    private static double judge(double mid,long w,long m) {
        // 计算偿还总数
        // mid越大 分母越大 总还款越少
        double money=0;
        for (int i = 1; i <=m ; i++) {
            money+=w/Math.pow(1+mid,i);

        }
        return money;
    }
}
