package Simulate;

import java.util.Scanner;

public class P1042 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        // 输入为空则比赛结束
        int w_count=0;
        int l_count=0;
        int w_count_partTwo=0;
        int l_count_partTwo=0;
        StringBuilder stringBuilder=new StringBuilder();

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            stringBuilder.append(line);
        }
        char[] chars=stringBuilder.toString().toCharArray();
        for (char c : chars) {
            if (c == 'E') {
                System.out.println(w_count + ":" + l_count);
                break;
            }
            if (c == 'W') {
                w_count++;
            } else {
                l_count++;
            }
            if ((w_count >= 11 || l_count >= 11) && Math.abs(w_count-l_count)>=2) {
                System.out.println(w_count + ":" + l_count);
                w_count = 0;
                l_count = 0;
            }
        }
        System.out.println();

        for (char c : chars) {
            if (c == 'E') {
                System.out.println(w_count_partTwo + ":" + l_count_partTwo);
                break;
            }
            if (c == 'W') {
                w_count_partTwo++;
            } else {
                l_count_partTwo++;
            }
            if ((w_count_partTwo >= 21 || l_count_partTwo >= 21) && Math.abs(w_count_partTwo-l_count_partTwo)>=2) {
                System.out.println(w_count_partTwo + ":" + l_count_partTwo);
                w_count_partTwo = 0;
                l_count_partTwo = 0;
            }
        }
    }
}
