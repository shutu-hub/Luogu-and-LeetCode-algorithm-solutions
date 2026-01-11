package Competition.First;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int zeroNumber=0;
        int oneNumber=0;
        String str=sc.next();
        char[]s=str.toCharArray();
        for(int i=0;i<n;i++){
            if(s[i]=='0'){
                zeroNumber++;
            }else{
                oneNumber++;
            }
        }
        int t_zeroNumber=0;
        int t_oneNumber=0;
        String str2=sc.next();
        char[]t=str2.toCharArray();
        for(int i=0;i<n;i++){
            if(t[i]=='0'){
                t_zeroNumber++;
            }else{
                t_oneNumber++;
            }
        }
        int one=Math.min(zeroNumber,t_oneNumber);
        int two=Math.min(oneNumber,t_zeroNumber);
        System.out.println(one+two);
        sc.close();
    }
}
