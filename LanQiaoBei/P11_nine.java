package LanQiaoBei;

import java.util.Scanner;

public class P11_nine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        long sum=0;
        int length = str.length();
        char[] array = str.toCharArray();
        char[]counts=new char[26];
        // 从i到j的不同字符的个数
        long[][]dp=new long[length+1][length+1];
        for (int start = 1; start <= length; start++) {
            for (int end = start; end <=length ; end++) {
                if (counts[array[end-1] - 'a'] == 0) {
                    dp[start][end]=dp[start][end-1]+1;
                }else{
                    dp[start][end]=dp[start][end-1];
                }
                counts[array[end-1] - 'a']++;
                sum+=dp[start][end];
            }
            counts=new char[26];
        }
        System.out.println(sum);
    }
}
