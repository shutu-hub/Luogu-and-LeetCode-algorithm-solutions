package LanQiaoBei;

import java.math.BigInteger;

public class p14_guo_two {
    public static void main(String[] args) {
        long sum=0;
        BigInteger mod=new BigInteger("2146516019");
        BigInteger pow=new BigInteger("2146516017");
        for (int i = 1; i <=233333333 ; i++) {
            BigInteger num=new BigInteger(String.valueOf(i));
            BigInteger bigInteger = num.modPow(pow, mod);
            int n = Integer.parseInt(bigInteger.toString());
            sum^=n;
        }
        System.out.println(sum);
    }
}
