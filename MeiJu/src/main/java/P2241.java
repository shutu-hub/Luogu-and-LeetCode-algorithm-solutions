
import java.util.Scanner;

public class P2241 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m= scanner.nextInt();
        // 1*1正方形
        long countZheng=0;
        long countJu=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
               countZheng+=Math.min(i,j);
               countJu+= (long) i *j;
            }
        }
        System.out.print(countZheng+" ");
        System.out.println(countJu-countZheng);
    }



}
