package LanQiaoBei;
import java.util.Scanner;

public class P11_seven {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        int[]chars=new int[26];
        char[] array = str.toCharArray();
        for (char ele : array) {
            chars[ele-'a']++;
        }
        int max=-1;
        for (int i = 0; i < chars.length; i++) {
            max=Math.max(max,chars[i]);
        }
        for (int i = 0; i < chars.length; i++) {
            if (max==chars[i]){
                System.out.println((char)(i+'a'));
                System.out.println(max);
                break;
            }
        }
    }
}
