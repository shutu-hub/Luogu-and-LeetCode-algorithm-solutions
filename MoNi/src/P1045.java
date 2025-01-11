import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class P1045 {
    public static void main(String[] args) {
        // 给一个数字P，求2的p次方-1 有多少位数字和最后500位
        Scanner scanner=new Scanner(System.in);
        int p=scanner.nextInt();
        int count= (int) ((Math.floor(p*Math.log10(2)))+1);
        System.out.println(count);
        // 直接算需要的后500位
        BigInteger two=new BigInteger("2");
        BigInteger mod=BigInteger.TEN.pow(500);
        BigInteger last500=two.modPow(new BigInteger(p+""),mod).subtract(BigInteger.ONE);
        String str=last500.toString();
        if (str.length()<500){
            // 高位补0
            int diff=500-str.length();
            StringBuilder stringBuilder=new StringBuilder(0);
            for (int i = 0; i < diff; i++) {
                stringBuilder.append("0");
            }
            str=stringBuilder+str;
        }else{
           str=str.substring(str.length()-500);
        }
        // 每行输出50位 输出10行
        for (int i = 0; i < 10; i++) {
            System.out.println(str.substring(i*50,i*50+50));
        }
        scanner.close();
    }

//    private static BigInteger quickMi(int p) {
//        if (p==1){
//            return new BigInteger("2");
//        }
//        if (p%2==0){
//            // p位偶数
//            BigInteger sum=quickMi(p/2);
//            return sum.multiply(sum);
//        }else{
//            // p为奇数
//            BigInteger sum=quickMi(p/2);
//            return sum.multiply(sum).multiply(new BigInteger("2"));
//        }
//    }
//    private static BigInteger quickMi(int p) {
//        BigInteger base = new BigInteger("2");
//        BigInteger result = BigInteger.ONE;
//
//        while (p > 0) {
//            if (p % 2 == 1) {
//                result = result.multiply(base);
//            }
//            base = base.multiply(base); // 平方
//            p /= 2; // 指数除以2
//        }
//        return result;
//    }
}
