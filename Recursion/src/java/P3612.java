package Recursion.src.java;

import java.util.Scanner;

public class P3612 {
    static long initialLength=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        long n=scanner.nextLong();

        // COW -> COWWCO -> COWWCOOCOWWC
        // WAC -> WACCWA -> WACCWAAWACCW
        // 待找字符在后半段
        long length=str.length();
        initialLength=length;
        // k记录要经过多少次变化长度可以>=n
        while(length<n){
            // length扩大两倍
            length<<=1;
        }
        int index = fenzhi( n, length,initialLength);
        System.out.println(str.charAt(index-1));
    }

    public static int fenzhi(long n,long l,long initialLength){
       if (n<=initialLength){
           // 回到初始字符串 返回指定下标对应位置
           return (int)n;
       }
        // 前一次待找位置
        if (n-l/2>1){
            n=n-l/2-1;
        }else{
            if (n-l/2==1){
                // 要找的是上一个字符的最后一个位置
                return fenzhi(l/2,l/2,initialLength);
            }
        }
        return fenzhi(n,l/2,initialLength);
    }
}
// CADERF  CADERFFCADER  CADERFFCADERRCADERFFCADE