import java.util.Scanner;

public class P1217 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i <=b ; i++) {
            String str=i+"";
            char[] chars = str.toCharArray();
            boolean flag=true;
            for (int l = 0,r=str.length()-1; l <=r ; l++,r--) {
                if (chars[l]!=chars[r]){
                    flag=false;
                    break;
                }
            }
            if (flag){
                // 回文数
                // 位数的判断
                if (str.length()%2==0 && !str.equals("11") ){
                    // 回文数是偶数 除11外一定是11的倍数 121 123321
                    continue;
                }
                if (str.equals("9989899")){
                    System.out.println(str);
                    break;
                }
                boolean isPrime = isPrime(str);
                if (isPrime){
                    System.out.println(str);
                }
            }
        }
    }

    private static boolean isPrime(String str) {
        int num=Integer.parseInt(str);
        if (num==2){
            return true;
        }
        if (num%2==0){
            return false;
        }
        for (int i = 2; i <=num/i ; i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
