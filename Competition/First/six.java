package Competition.First;

import java.util.Scanner;

public class six {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        long mod= (long) 1e9+7;
        for (int i = 0; i < t; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long n = scanner.nextLong();
            // 求abc的2的n次方幂
            // n<=1e9+7，2的n次方幂太大，使用欧拉定理转化
            long r = quickMi(2,n,mod-1);
            // 求ABC的2的r次方
//          会超出范围  long initial_number=((a%mod)*(b%mod)*(c%mod))%mod;
            // long最大范围小于10的19次方，abc最大均为10的9
            long initial_number=((a % mod) * (b % mod) % mod * (c % mod)) % mod;
            long result = quickMi(initial_number, r,mod)%mod;
            System.out.println(result);
        }
    }

    private static long quickMi(long dishu, long mi,long mod) {
        if (mi == 0) {
            return 1; // 任何数的0次方都是1
        }
        if (mi==1){
            return dishu%mod;
        }
        if (mi%2==0){
            // 偶数幂
            long num=quickMi(dishu,mi/2,mod);
            return (num*num)%mod;
        }else{
            // 奇数幂
            long num=quickMi(dishu,mi/2,mod);
            return (num * num  % mod * dishu) % mod;
        }
    }
    }















