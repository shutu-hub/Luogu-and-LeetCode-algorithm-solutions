package Optimize;

import java.util.LinkedList;
import java.util.Scanner;

public class P1638 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[]authors=new int[n+1];
        for (int i = 1; i <= n; i++) {
            authors[i]=scanner.nextInt();
        }
        int see=0;
        int[]count=new int[m+1];
        int l=0;
        int minLen=Integer.MAX_VALUE;
        int ansL=1;int ansR=n;
        for (int r=1; r <=n ; r++) {
            if (count[authors[r]]==0){
                see++;
            }
            count[authors[r]]++;
            // 当窗口包含所有画师时，尝试收缩左边界
            while (see==m){
                if (r-l+1<minLen){
                    minLen=r-l+1;
                    ansL=l;
                    ansR=r;
                }
                // 让左边界的画对应的画家值-1
                count[authors[l]]--;
                if (count[authors[l]]==0){
                    see--;
                }
                l++;
            }
        }
        System.out.println(ansL+" "+ansR);
      }
    }

