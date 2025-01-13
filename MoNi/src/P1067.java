import java.util.Scanner;

public class P1067 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array=new int[n+2];
        for (int i = 1; i <= n+1; i++) {
            array[i]=scanner.nextInt();
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i < array.length; i++) {
            int xiShu=array[i];
            int zhiShu=n-i+1;
            if (xiShu==0){
                continue;
            }
            // 除了开头的+号
            if (xiShu>0 && i !=1){
                sb.append("+");
            }
            if (xiShu!=1 && xiShu !=-1){
                sb.append(xiShu);
            }else{
                // 绝对值为 1
                if (xiShu<0){
                    sb.append("-");
                }
            }
            if (zhiShu!=0){
                if (zhiShu!=1){
                    sb.append("x^").append(zhiShu);
                }else{
                    sb.append("x");
                }
            } else{
                // 质数=0 如果系数为 1，-1则需要补上
                if (xiShu==1){
                    sb.append("1");
                }else if (xiShu==-1){
                    sb.append("1");
                }
            }
        }
        System.out.println(sb);
    }
}
