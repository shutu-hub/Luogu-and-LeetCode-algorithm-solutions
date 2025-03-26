package ShuLun;

import java.util.Scanner;

public class P1143 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        String num = scanner.next();
        int target = scanner.nextInt();
        // 将n进制数下的num转为target进制下的数
        // 将n进制转为10进制 再将10进制转为对应target进制
        int ten = goToTen(num, n);
        if (target==10){
            System.out.println(ten);
        }else{
            String result = goToTarget(ten, target);
            System.out.println(result);
        }
    }
    public static int goToTen(String num,int n){
        // 将该数转为10进制
        int sum=0;
        for (int i =  num.length()-1 ,k=0; i >=0; i--,k++) {
            char ele = num.charAt(i);
            if (ele>='A' && ele<='F'){
                sum+= (int) ((10+ele-'A')*Math.pow(n,k));
            }else{
                sum+=(int)((ele-'0')*Math.pow(n,k));
            }
        }
        return sum;
    }

    public static String goToTarget(int num,int target){
        StringBuilder sb=new StringBuilder();
        while (num>0){
            // end是最后一位 最后要反序返回
            int end = num % target;
            if (end>=10){
                // 将其转为字符
                sb.append((char) ('A'+end-10));
            }else{
                sb.append(end);
            }
            num/=target;
        }
        return sb.reverse().toString();
    }
}
