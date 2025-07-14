import java.util.Scanner;

public class P1706 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] number = new int[n];
        boolean[] flags = new boolean[n + 1];
        digui(1, n, number, flags);
    }
    public static void digui(int index,int n,int[]number,boolean[]flags) {
        if (index>n){
            for (int num : number) {
                   System.out.print("    " + num);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <=n ; i++) {
            if (!flags[i]){
                number[index-1]=i;
                flags[i] = true;
                digui(index+1,n,number,flags);
                flags[i]=false;
            }
        }
    }
}



