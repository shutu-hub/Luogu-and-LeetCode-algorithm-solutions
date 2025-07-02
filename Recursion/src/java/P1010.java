package Recursion.src.java;
import java.util.ArrayList;
import java.util.Scanner;

public class P1010 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        // 找到n的最大幂
        // 找一个数的最大幂
        dfs(n);
    }

    public static void dfs(double n) {
        if (n<=0){
            return;
        }
        int i=0;
        while(Math.pow(2,i)<=n){
            i++;
        }
        i-=1;
        System.out.print("2");
        if (i!=1){
            System.out.print("(");
        }
        if (i==0){
            System.out.print("0)");
            return;
        }
        if (i==2){
            System.out.print("2)");
        }
        if (i>=3){
            dfs(i);
            System.out.print(")");
        }
        double a = n - Math.pow(2, i);
        if (a>0){
            System.out.print("+");
            dfs(a);
        }
    }
}
class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>();
    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            // { 临界区, 会产生竞态条件
            method2();
            method3();
            // } 临界区
        }
    }
    private void method2() {
        list.add("1");
    }

    private void method3() {
        list.remove(0);
    }
}



