package LanQiaoBei;

import java.util.Arrays;

public class P15_two {
        public static void main(String[] args) {
            long max=-1;
            OUT:
            for (int i = 10000000; i >=1; i--) {
                String str=i+"";
                int weishu=str.length();
                int[]number=new int[weishu];
                for (int j = 0; j < str.length(); j++) {
                    number[j]=str.charAt(j)-'0';
                }
                int k=0;
                for (int l=weishu;k<i;l++) {
                    k= Arrays.stream(number).sum();
                    number[l%weishu]=k;
                }
                if (k==i) {
                    System.out.print(k);
                    break OUT;
                }
            }
        }
}
