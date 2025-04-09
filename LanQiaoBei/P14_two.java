package LanQiaoBei;

import java.util.Scanner;

public class P14_two {
        static long count=0L;
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int t=scanner.nextInt();
            for (int i = 0; i < t; i++) {
                int n=scanner.nextInt();
                long[]number=new long[n];
                long sum=0;
                for (int j = 0; j < n; j++) {
                    number[j]=scanner.nextLong();
                    sum+=number[j];
                }
                count=0;
                dfs(number,0,0,sum);
                count=(long) (count%(10e9+7));
                System.out.println(count);
            }
        }
        public static void dfs(long[]number,int start,long r,long sum) {
            if (r%2==0 && (sum-r)%2==0 ) {
                count++;
            }
            for (int i = start; i < number.length; i++) {
                dfs(number, i+1,r+number[i],sum);
            }
        }
    }


