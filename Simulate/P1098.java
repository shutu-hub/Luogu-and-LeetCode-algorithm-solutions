package Simulate;

import java.util.Scanner;

public class P1098 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();
        int p3 = scanner.nextInt();
        String inputStr = scanner.next();
        char[] chars = inputStr.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='-' && i!=0 && i!= chars.length-1 ){
                // 前后字符展开
                char before=chars[i-1];
                char later=chars[i+1];
                if (!(judge(before) && judge(later)) && !(judgeNumber(before) && judgeNumber(later))){
                    // 不遵循规则
                    stringBuilder.append("-");
                    continue;
                }
                if (later-before==1){
                    continue;
                }else if (later<=before){
                    // 满足两边都是字母或数字 右边小于左边
                    stringBuilder.append("-");
                    continue;
                }
                if (p1==1){
                    // 输出k遍小写字母
                    StringBuilder sb=new StringBuilder();
                    for (int j = before+1; j < later ; j++) {
                        for (int k = 0; k < p2; k++) {
                            sb.append((char)j);
                        }
                    }
                    if (p3==2){
                        sb.reverse();
                    }
                    stringBuilder.append(sb);
                } else if (p1==2) {
                    // 输出k遍大写字母
                    StringBuilder sb=new StringBuilder();
                    for (int j = before+1; j < later ; j++) {
                        for (int k = 0; k < p2; k++) {
                            sb.append((char)j);
                        }
                    }
                    if (p3==2){
                        sb.reverse();
                    }
                    stringBuilder.append(sb.toString().toUpperCase());
                }else{
                    // * 来填充
                    for (int j = before+1; j < later ; j++) {
                        for (int k = 0; k < p2; k++) {
                            stringBuilder.append('*');
                        }
                    }
                }
            }else{
                // 不是-号
                // 不是-号
                stringBuilder.append(chars[i]);
            }
        }
        System.out.println(stringBuilder);
    }
    public static boolean judge(char ele) {
        return ele >= 'a' && ele <= 'z' ;
    }
    public static boolean judgeNumber(char ele) {
        return ele >= '0' && ele <= '9' ;
    }
}
