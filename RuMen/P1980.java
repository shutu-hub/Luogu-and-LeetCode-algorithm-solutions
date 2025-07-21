package RuMen;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //1-n
        int k = sc.nextInt();
        long count =0;
        int targer=k+'0';
        for (int i = 1; i <= n; i++) {
            String str = i + "";
            char[] chars = str.toCharArray();
            for (char ele : chars) {
                if (ele==targer){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
