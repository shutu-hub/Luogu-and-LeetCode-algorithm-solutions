package RuMen;

import java.util.Scanner;

public class Smith {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        while(true){
            n++;
            if (!isPrime(n) && getSelfSum(n)==getSum(n)){
                System.out.println(n);
                break;
            }
        }
    }

    public static int getSelfSum(int n){
        int sum=0;
        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= n/i ; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static int getSum(int n) {
        int sum=0;
        if (n <= 1) return 1;
        // 8=2*2*2  30=2*3*5
        // 处理 2的因子
        while (n % 2 == 0) {
            sum+=2;
            n /= 2;
        }
        // 处理奇数因子
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                sum+=getSelfSum(i);
                n /= i;
            }
        }
        // 如果剩下的n是质数
        if (n > 2) {
            sum+=n;
        }
        return sum;
    }
}
