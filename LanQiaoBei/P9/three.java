package LanQiaoBei.P9;


import java.math.BigInteger;

public class three {
    public static void main(String[] args) {
        Complex base=new Complex(new BigInteger("2"), new BigInteger("3"));
        Complex complex = quickMi(base, 123456);
        System.out.print(complex.a);
        if (complex.b.compareTo(BigInteger.ONE)>0){
            System.out.print("+"+complex.b+"i");
        }else{
            System.out.print(complex.b+"i");
        }
    }

//    public static Complex quickMi(Complex base,int n){
//        Complex result=new Complex(BigInteger.ONE, BigInteger.ZERO);
//        while (n>0){
//            if ((n&1)==1){
//                // 奇数
//                result=result.multiply(base);
//            }
//            base=base.multiply(base);
//            n>>=1;
//        }
//        return result;
//    }

    public static Complex quickMi(Complex base, int n) {
        if (n==1){
            return base;
        }
        if ((n&1)==0){
            // 偶数
            Complex complex = quickMi(base, n >> 1);
            return complex.multiply(complex);
        }else{
            // 奇数
            Complex complex = quickMi(base, n >> 1);
            return complex.multiply(complex).multiply(base);
        }
    }

}
class Complex{
    BigInteger a;
    BigInteger b;
    public Complex(BigInteger a, BigInteger b){
        this.a = a;
        this.b = b;
    }
    public Complex multiply(Complex c){
        // 实数部分
        // 2+3i * 2+3i
        BigInteger ta=a.multiply(c.a).subtract(b.multiply(c.b));
        BigInteger tb=a.multiply(c.b).add(b.multiply(c.a));
        return new Complex(ta,tb);
    }
}