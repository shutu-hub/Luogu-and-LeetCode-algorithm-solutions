package RuMen;

import java.util.ArrayList;
import java.util.List;

public class LintCode1902 {
    public static void main(String[] args) {
        List<String>s=new ArrayList<>();
        s.add("输入: \n" +
                "S = [\"#include<bits/stdc++.h>\",\"using namespace std;\",\"int main(){\",\"int Google = 0\",\"return 0;\",\"}\"]\n" +
                "输出: \n" +
                "false\n" +
                "说明: \n" +
                "google不在注释行内。");
        System.out.println(findGoogle(s));
    }

    public static boolean findGoogle(List<String> s) {
       // 检验注释行是否包含Google
       // 保证“Google”字符串在一个string内，不会换行
        for (String str : s) {
            int length = str.length();
            for (int j = 0; j < length; j++) {
                if (str.charAt(j) == '/' && j + 1 < length && str.charAt(j + 1) == '/') {
                    // 单行注释
                    int index = str.indexOf("Google", j + 2);
                    if (index != -1) {
                        return true;
                    }
                }
                if (str.charAt(j) == '/' && j + 1 < length && str.charAt(j + 1) == '*') {
                    int index = str.indexOf("*/", j + 2);
                    int Googleindex = str.indexOf("Google", j + 2);
                    if (Googleindex != -1 && index != -1 && Googleindex < index) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
