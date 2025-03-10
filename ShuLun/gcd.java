package ShuLun;
import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gongyueshu = gcd(a, b);
        System.out.print(gongyueshu+" ");
        System.out.print((long)a*b/gongyueshu);
    }

    public static int gcd(int a,int b){
        while (b!=0){
            int tmp=b;
            b=a%b;
            a=tmp;
        }
        return a;
    }
}
