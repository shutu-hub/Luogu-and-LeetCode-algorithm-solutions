package RuMen;

import java.util.Scanner;

public class P3954 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int score=(int)(a*0.2+b*0.3+c*0.5);
        System.out.println(score);
    }
}
