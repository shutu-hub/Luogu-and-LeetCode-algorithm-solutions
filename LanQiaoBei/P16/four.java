package LanQiaoBei.P16;

import java.util.HashSet;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[]ai=new int[n];
        int[]bi=new int[m];
        for (int i = 0; i < n; i++) {
              ai[i]=scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
              bi[i]=scanner.nextInt();
        }
        HashSet<Integer>set=new HashSet<>();
        boolean[]isUse=new boolean[20001];
        boolean[]isUseTwo=new boolean[20001];
        int nm=n+m;
        for (int i = 0; i < ai.length; i++) {
            if (isUse[ai[i]]){
                continue;
            }
            isUse[ai[i]]=true;
            for (int j = 0; j < bi.length; j++) {
                if (isUseTwo[bi[j]]){
                    continue;
                }
                isUseTwo[bi[j]]=true;
                int s=ai[i]+bi[j];
                if (s<=nm && isPrime(s)){
                    set.add(s);
                }
            }
        }
        System.out.println(set.size());
    }

    public static boolean isPrime(int s){
        for (int i = 2; i <=s/i ; i++) {
            if (s%i==0){
                return false;
            }
        }
        return true;
    }
}
