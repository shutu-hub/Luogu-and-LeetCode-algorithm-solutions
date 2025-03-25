package LanQiaoBei.P10;

import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long sum=0;
        for (int i = 1; i <=n ; i++) {
            String str=i+"";
            char[] chars = str.toCharArray();
            int length=chars.length;
            for (int j = 0; j < length; j++) {
                if (chars[j]=='2' || chars[j]=='0' || chars[j]=='1' || chars[j]=='9') {
                    sum+=i;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
