package LanQiaoBei.P9;



public class two {
    public static void main(String[] args) {
        // 枚举出第一象限所有点 * 4 即范围内的所有点
        long r2=50000*50000L;
        long count=0;
        for (int i = 1; i <=50000 ; i++) {
            for (int j = 1; j <=50000 ; j++) {
                // i横坐标 j纵坐标 距离和
                long distance=(long)i*i+(long)j*j;
                if (distance<=r2){
                    count++;
                }
            }
        }
        System.out.println(count*4);
    }
}
//BigInteger a=BigInteger.ZERO;BigInteger b=BigInteger.ZERO;
//BigInteger sum=BigInteger.ZERO;
//BigInteger add=new BigInteger("2");
//        for (int i = 1; i <=5 ; i++) {
//sum=a.multiply(b);
//a = a.add(add);
//b=b.add(add);
//        }
//                System.out.println(sum);