package LanQiaoBei;

import java.util.*;

public class P12_three {
        public static void main(String[] args) {
            Set<String> stringSet = new HashSet<>();
            for(int i = 0; i < 20; i++) { // x1
                for (int j = 0; j < 21; j++) {  // y1
                    for (int l = 0; l < 20; l++) {  // x2
                        for (int m = 0; m < 21; m++) {  // y2
                            if(i == l || j == m) continue;
                            double k = (double) (j - m) / (i - l);
                            double b = j - k * i;
                            stringSet.add(String.format("%.5f %.5f", k, b)); // 保留小数位数
                        }
                    }
                }
            }
            System.out.println(stringSet.size() + 20 + 21);
        }

}


