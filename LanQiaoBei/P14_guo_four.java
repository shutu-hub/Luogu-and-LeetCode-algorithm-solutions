package LanQiaoBei;

import java.util.Scanner;

public class P14_guo_four {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        String[] split = str.split("=");
        long sum=0;
        boolean flag=false;
        for (int i = 0; i < split.length; i++) {
            String ele = split[i];
            if (ele.equals("?")){
                if (split[i+1].equals("+") ||split[i-1].equals("-")||split[i-1].equals("*")||split[i-1].equals("/")||split[i-1].equals("=") ){
                    String num = split[i - 2];
                    String fuhao = split[i - 1];
                    String result = split[split.length - 1];
//                    jiSuan(Integer.parseInt(num),Integer.p)
                }
            }

        }
    }
    private static void getResult(int a,int b,int c){
        if (a*b==c){
            System.out.println("*");
        }else if (a+b==c){
            System.out.println("+");
        }else if (a-b==c){
            System.out.println("-");
        }else if (a/b==c){
            System.out.println("/");
        }
    }
    private static int jiSuan(int a,int b,String c){
        return switch (c) {
            case "+" -> b-a;
            case "-" -> a - b;
            case "*" -> b/a;
            default -> a/b;
        };
    }
}
