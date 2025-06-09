package TanXin;

import java.math.BigInteger;
import java.util.Scanner;

public class P1106 {

    public static void main(String[] args) {
        // n位数 去掉k位 剩余n-k位
        // 选择n-k位数字构成最小的数
        /**
         * 每次选择一个最小的数作为该位的数
         * m为删去的个数 因为最后要留下一个最小的数 所以选择范围为m+1位  题目中要求从左到右
         * 找到最小的数后则该数左边的数均删除 因为是从左边开始找的 该数的左边均在比较范围内且大于该数
         * 1753983
         * 13983
         * 133
         *
         * 7153983
         * 153983
         * 13983
         * 133
         * @param index
         * @param sum
         */
        Scanner scanner=new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        int k=scanner.nextInt();
        int m=k;
        String result=n.toString();
        char[] chars = result.toCharArray();
        int start=0;
        int l=-1;
        int minIndex=0;
        int length=n.toString().length();
        StringBuilder stringBuilder=new StringBuilder();
        boolean flag=true;
        while(stringBuilder.length()<(length-k)){
            // 位数大于n-k位 在左边m+1位中找到最小数
            for (int i = start; i<chars.length && i <start+m+1 ; i++) {
                if (chars[i]<chars[minIndex]){
                    minIndex=i;
                }
            }
            // minIndex左边的数删除
            stringBuilder.append(chars[minIndex]);
            start=minIndex+1;
            m=m-(minIndex-l-1);
            l=minIndex;
            minIndex++;
        }
        // 001
        boolean isPrint=false;
        for (char c : stringBuilder.toString().toCharArray()) {
            if (c=='0' && flag){
               // 前置0
                continue;
            }
            System.out.print(c);
            isPrint=true;
            flag=false;
        }
        if (!isPrint){
            System.out.println(0);
        }
    }



}
