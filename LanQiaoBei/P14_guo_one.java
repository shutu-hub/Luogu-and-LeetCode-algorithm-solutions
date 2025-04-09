package LanQiaoBei;

import java.math.BigInteger;

public class P14_guo_one {
    public static void main(String[] args) {
        BigInteger bigInteger=new BigInteger("2023");
        BigInteger pow = bigInteger.pow(2023);
       // 找到范围内7和17的倍数有多少个
        BigInteger seven=pow.divide(new BigInteger("7"));
        BigInteger seventeen=pow.divide(new BigInteger("17"));
        BigInteger gongbeishu=pow.divide(new BigInteger("119"));
        BigInteger result = pow.subtract(seven).subtract(seventeen).add(gongbeishu).mod(new BigInteger("1000000007"));
        System.out.println(result);
    }
}
