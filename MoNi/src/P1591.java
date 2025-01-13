import java.math.BigInteger;
import java.util.Scanner;

public class P1591 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a= scanner.nextInt();
            BigInteger m=new BigInteger("1");
            for (int j = 1; j <=n ; j++) {
                m=m.multiply(new BigInteger(j+""));
            }
            System.out.println(m);
            // 求sum中a的个数
            String string = m.toString();
            char[] chars = string.toCharArray();
            int count=0;
            for (char c : chars) {
                if (c-'0'==a){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
