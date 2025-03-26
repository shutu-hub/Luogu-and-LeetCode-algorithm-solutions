package ShuLun;

import jdk.jfr.Unsigned;

import java.util.Scanner;

public class P1100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // 保留低32位 其余为0
        long value = n & 0xFFFFFFFFL;
        // 只保留低16位且左移16位
        long low16 = (value & 0xFFFFL) << 16;
        // 高16位右移16位且只保持低16位
        long high16 = (value >>> 16) & 0xFFFFL;
        long result = low16 ^ high16;
        System.out.println(result);
    }

//    public static void printEr(int num){
//        StringBuilder sb=new StringBuilder();
//        while (num>0){
//            sb.append(num%2);
//            num/=2;
//        }
//        System.out.println(sb.reverse());
//    }
}
