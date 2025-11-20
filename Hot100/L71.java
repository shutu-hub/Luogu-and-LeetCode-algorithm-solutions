package Hot100;

import java.util.Stack;

public class L71 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])){
                // 继续累加数字
                num = num*10+chars[i]-'0';
            }else if(chars[i]=='['){
                // 遇到左括号，数字入栈，字符串入栈
                numStack.push(num);
                strStack.push(curr);
                // 开启新的计算,如:3[a2[c]],2入数栈，a入字符串栈，curr清零，准备计算c
                num = 0;
                curr = new StringBuilder();
            }else if (chars[i]==']'){
                // 遇到右括号，数字出栈，字符串出栈
                Integer times = numStack.pop();
                StringBuilder prev = strStack.pop();
                for (int j = 0; j < times; j++) {
                    prev.append(curr);
                }
                curr = prev;
            }else {
                // 连续字符继续拼接
                curr.append(chars[i]);
            }
        }
        return curr.toString();
    }

}
