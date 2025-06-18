package SprakOJ.Ten;

import java.math.BigInteger;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String one = scanner.next();
        String two = scanner.next();
        BigInteger bigInteger = new BigInteger(one);
        BigInteger bigInteger1 = new BigInteger(two);
        BigInteger bigInteger2 = bigInteger.add(bigInteger1);
        System.out.println(bigInteger2);
    }
}
