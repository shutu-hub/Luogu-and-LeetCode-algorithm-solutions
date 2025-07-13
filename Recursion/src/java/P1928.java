package Recursion.src.java;

import java.util.Scanner;

public class P1928 {
    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {
        System.out.println(decompress());
    }

    public static String decompress() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";

        while (scanner.hasNext()) {
            input = scanner.next();
            if (input.equals("[")) {
                int k = scanner.nextInt();
                str = decompress();
                while (k > 0) {
                    stringBuilder.append(str);
                    k--;
                }
            } else if (input.equals("]")) {
                return stringBuilder.toString();
            } else {
                stringBuilder.append(input);
            }
        }
        return stringBuilder.toString();
    }
}