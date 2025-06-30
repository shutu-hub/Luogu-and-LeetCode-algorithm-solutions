import java.util.Scanner;

public class P1157 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[]number=new int[r];
        boolean[]flags=new boolean[n+1];
        digui(1,n,r,number,flags,1);
    }

    public static void digui(int index,int n, int r,int[]number,boolean[]flags,int start) {
        if (index>r){
            for (int num : number) {
                if (num > 0 && num < 10) {
                    System.out.print("  " + num);
                } else {
                    System.out.print(" " + num);
                }
            }
            System.out.println();
            return;
        }
        for (int i = start; i <=n ; i++) {
                if (!flags[i]){
                    number[index-1]=i;
                    flags[i] = true;
                    digui(index+1,n,r,number,flags,i+1);
                    flags[i]=false;
                }
        }
    }
}
