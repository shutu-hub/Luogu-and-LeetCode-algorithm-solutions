package RuMen;

import java.util.Scanner;

public class P1597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next(); // 读取输入字符串
        // 将字母映射到数组上 a:0 b:1 c:2 这样在后边赋值变量值时，可以取变量的值
        int[]array=new int[3];
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i)=='='){
                char ele = s.charAt(i - 2);
                char value = s.charAt(i + 1);
                if (value>='0' && value<='9'){
                    array[ele-'a']=value-'0';
                }else{
                    if (value=='a'){
                        array[ele-'a']=array[0];
                    }else if (value=='b'){
                        array[ele-'a']=array[1];
                    }else{
                        array[ele-'a']=array[2];
                    }
                }
            }
        }
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}